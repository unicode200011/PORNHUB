package com.org.customer.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.customer.service.RegService;

@Controller
@RequestMapping("/regController")
public class RegController
{
	private static Logger logger = LoggerFactory.getLogger(RegController.class.getName());

	@Autowired
	public RegService regService;

	/**
	 * 注册帐号
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registration.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> registration( HttpServletRequest request )
	{
		Map<String, Object> res = new HashMap<String, Object>();
		String account = request.getParameter("account");
		String passWord = request.getParameter("passWord");
		String invitationCode = request.getParameter("invitationCode");
		String registerIp = getIpAddr(request);
		logger.info("帐号注册" + account + "||" + passWord);
		// 判断账号是否已经存在.
		int i = regService.verificationAccount(account);

		if (i > 0)
		{
			res.put("code", 100);// 帐号已经存在
		}
		else
		{
			// 根据IP判断之前是否注册过
//			int ip_ = regService.verificationIp(registerIp);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(date);
//			if (ip_ == 0)
//			{
//				cal.add(Calendar.DAY_OF_MONTH, +7);
//			}
//			else
//			{
//				cal.add(Calendar.DAY_OF_MONTH, -1);
//			}

			Map<String, Object> custMap = new HashMap<String, Object>();
			custMap.put("pornhub_customer_account", account);
			custMap.put("pornhub_customer_password", passWord);
			custMap.put("pornhub_customer_type", "1");// 用户类型, 1 = 普通用户
			custMap.put("pornhub_customer_register_ip", registerIp);// 注册时的IP
			custMap.put("pornhub_customer_vip_time", df.format(new Date()));// 第一次注册赠送的VIP有效时间 1天
			custMap.put("pornhub_user_invitation_code", invitationCode); // 邀请码
			custMap.put("create_user", "system"); // system 代表用户通过前端注册

			int success;
			try
			{
				success = regService.regCustomer(custMap);
			}
			catch (Exception e)
			{
				success = 500;
			}
			if (success > 0)
			{
				res.put("code", 200);// 注册成功
			}
		}

		return res;
	};

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
	 */
	private String getIpAddr( HttpServletRequest request )
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
		{
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			if (ip.indexOf(",") != -1)
			{
				ip = ip.split(",")[0];
			}
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
