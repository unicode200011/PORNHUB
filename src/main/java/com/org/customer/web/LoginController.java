package com.org.customer.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.util.CookieUtil;
import com.org.customer.service.LoginService;

@Controller
@RequestMapping("/loginController")
public class LoginController
{
	private static Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

	@Autowired
	public LoginService loginService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@ResponseBody
	public int login( HttpServletRequest request, HttpServletResponse resp ) throws ParseException
	{
		// 查询参数
		Map<String, Object> parm = new HashMap<String, Object>();
		// 返回结果
		Map<String, Object> result = new HashMap<String, Object>();
		// 存放COOKIE 值
		Map<String, Object> cookieMap = new HashMap<String, Object>();

		String pornhub_customer_account = request.getParameter("account");
		String pornhub_customer_password = request.getParameter("passWord");
		parm.put("pornhub_customer_account", pornhub_customer_account);
		parm.put("pornhub_customer_password", pornhub_customer_password);
		result = loginService.login(parm);
		// 登录成功
		if (result != null)
		{
			HttpSession session = request.getSession();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

			// COOKIE 中存放 用户信息 用来和 SESSION 中的对比因此来做到免登录
			cookieMap.put("session_id", session.getId());
			cookieMap.put("pornhub_customer_account", result.get("pornhub_customer_account"));
			cookieMap.put("pornhub_customer_password", result.get("pornhub_customer_password"));
			cookieMap.put("pornhub_customer_vip_time", df.format(result.get("pornhub_customer_vip_time")));

			session.setAttribute("pornhub_customer_id", result.get("pornhub_customer_id"));
			session.setAttribute("pornhub_customer_account", result.get("pornhub_customer_account"));
			session.setAttribute("pornhub_customer_vip_time", result.get("pornhub_customer_vip_time"));
			CookieUtil.updateCookie(resp, cookieMap);
			return 200;
		}
		return 100;
	}

	/**
	 * 免登录与验证VIP
	 * 
	 * @param request
	 * @param resp
	 * @throws ParseException
	 */
	@RequestMapping(value = "/autoLogin.do", method = RequestMethod.GET)
	@ResponseBody
	public int autoLogin( HttpServletRequest request, HttpServletResponse resp ) throws ParseException
	{

		// 查询参数
		Map<String, Object> parm = new HashMap<String, Object>();
		// 返回结果
		Map<String, Object> result = new HashMap<String, Object>();
		// 存放COOKIE 值
		Map<String, Object> cookieMap = new HashMap<String, Object>();

		// 获取SESSION
		HttpSession session = request.getSession();

		// 获取COOKIE
		Cookie[] c = request.getCookies();

		if (c != null)
		{
			for (Cookie cookie : c)
			{
				parm.put(cookie.getName(), cookie.getValue());
			}
		}

		// 已登录未关闭过浏览器 -- 不用自动登录
		if (parm.get("session_id") != null && parm.get("session_id").equals(session.getId()))
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			Date date1 = df.parse((session.getAttribute("pornhub_customer_vip_time").toString()));
			Date date2 = new Date();
			long long1 = date1.getTime();
			long long2 = date2.getTime();
			if (long1 >= long2) // VIP时间大于当前时间
			{
				return 200;
			}
			else return 100;
		}

		// 已登录并关闭过浏览器 -- 自动登录更新用户资料
		if (parm.get("session_id") != null && !parm.get("session_id").equals(session.getId()))
		{
			// 通过 COOKIE中的账号密码后台登录并获取最新的用户信息更新COOKIE中.
			result = loginService.login(parm);
			SimpleDateFormat df_ = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

			cookieMap.put("session_id", session.getId());
			cookieMap.put("pornhub_customer_account", result.get("pornhub_customer_account"));
			cookieMap.put("pornhub_customer_password", result.get("pornhub_customer_password"));
			cookieMap.put("pornhub_customer_vip_time", df_.format(result.get("pornhub_customer_vip_time")));

			session.setAttribute("pornhub_customer_id", result.get("pornhub_customer_id"));
			session.setAttribute("pornhub_customer_account", result.get("pornhub_customer_account"));
			session.setAttribute("pornhub_customer_vip_time", result.get("pornhub_customer_vip_time"));
			CookieUtil.updateCookie(resp, cookieMap);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			Date date1 = df.parse((session.getAttribute("pornhub_customer_vip_time").toString()));
			Date date2 = new Date();
			long long1 = date1.getTime();
			long long2 = date2.getTime();
			if (long1 >= long2) // VIP时间大于当前时间
			{
				return 200;
			}
			else return 100;
		}

		return 100;
	}

	/**
	 * 退出登录
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/logOut.do", method = RequestMethod.GET)
	@ResponseBody
	public int logOut( HttpServletRequest request, HttpServletResponse resp )
	{
		try
		{
			Map<String, Object> cookieMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			session.invalidate(); // 注销SESSION
			cookieMap.put("session_id", "");
			cookieMap.put("pornhub_customer_account", "");
			cookieMap.put("pornhub_customer_password", "");
			cookieMap.put("pornhub_customer_vip_time", "");
			CookieUtil.invalidateCookie(resp, cookieMap); // 注销COOKIE
			return 1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}

	}
}
