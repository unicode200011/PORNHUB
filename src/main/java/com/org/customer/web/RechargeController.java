package com.org.customer.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.customer.service.CustomerService;

@Controller
@RequestMapping("/rechargeController")
public class RechargeController
{
	@Autowired
	public CustomerService customerService;

	@RequestMapping(value = "/recharge.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> recharge( HttpServletRequest request, HttpServletResponse resp ) throws ParseException
	{
		Map<String, Object> parm = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> insertParm = new HashMap<String, Object>();
		Map<String, Object> customer = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		String pornhub_card_number = request.getParameter("pornhub_card_number");
		String pornhub_card_password = request.getParameter("pornhub_card_password");
		// 未检查到账号
		if (session.getAttribute("pornhub_customer_account") == null)
		{
			customer.put("code", "10");
			return customer;
		}
		String pornhub_customer_account = session.getAttribute("pornhub_customer_account").toString();
		String pornhub_customer_vip_time = session.getAttribute("pornhub_customer_vip_time").toString();
		Integer pornhub_customer_id = (Integer) session.getAttribute("pornhub_customer_id");
		// 未检测到卡号卡密
		if (pornhub_card_number == "" || pornhub_card_password == "")
		{
			customer.put("code", "20");
			return customer;
		}
		parm.put("pornhub_card_number", pornhub_card_number);
		parm.put("pornhub_card_password", pornhub_card_password);
		parm.put("pornhub_customer_account", pornhub_customer_account);
		result = customerService.recharge(parm);
		// 卡密或者卡号不对
		if (result == null)
		{
			customer.put("code", "30");
			return customer;
		}
		// 卡号已经被使用过
		if (result.get("enable_flag").equals("0"))
		{
			customer.put("code", "40");
			return customer;
		}

		String pornhub_card_type = result.get("pornhub_card_type").toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date date1 = df.parse(pornhub_customer_vip_time); // 用户VIP时间
		Date date2 = new Date();// 系统当前时间
		long long1 = date1.getTime();
		long long2 = date2.getTime();
		Calendar cal = Calendar.getInstance();
		// 如果用户VIP时长大于当前时间直接累加
		if (long1 >= long2)
		{
			switch (Integer.parseInt(pornhub_card_type))
			{
				case 1:
					// 月卡
					cal.setTime(date1);
					cal.add(Calendar.DAY_OF_MONTH, +30);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
				case 2:
					// 季卡
					cal.setTime(date1);
					cal.add(Calendar.DAY_OF_MONTH, +90);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
				case 3:
					// 年卡
					cal.setTime(date1);
					cal.add(Calendar.DAY_OF_MONTH, +365);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
			}
		}
		// 如果用户VIP时长小于当前时间,那就在当前时间+卡的天数
		else
		{
			switch (Integer.parseInt(pornhub_card_type))
			{
				case 1:
					// 月卡
					cal.setTime(date2);
					cal.add(Calendar.DAY_OF_MONTH, +30);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
				case 2:
					// 季卡
					cal.setTime(date2);
					cal.add(Calendar.DAY_OF_MONTH, +90);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
				case 3:
					// 年卡
					cal.setTime(date2);
					cal.add(Calendar.DAY_OF_MONTH, +365);
					parm.put("pornhub_customer_vip_time", df.format(cal.getTime()));
					customerService.updateCustomerVipTime(parm);
					break;
			}
		}
		String rand = String.valueOf(Math.random());
		insertParm.put("pornhub_customer_id", pornhub_customer_id);
		insertParm.put("pornhub_card_id", (Integer) result.get("pornhub_card_id"));
		insertParm.put("pornhub_customer_recharge_number", date2.getTime() + rand.substring(5, 8));
		insertParm.put("pornhub_customer_recharge_time", date2);
		// 修改已使用的卡为无效
		customerService.updateCardFlag(parm);
		// 插入VIP激活记录
		customerService.insertRecharge(insertParm);

		// 查询更新后的VIP时间
		customer = customerService.getCustomer(parm);
		// 更新到SESSION中
		session.setAttribute("pornhub_customer_vip_time", customer.get("pornhub_customer_vip_time"));
		// 更新到Cookie中
		SimpleDateFormat df_ = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Cookie c = new Cookie("pornhub_customer_vip_time", df_.format(session.getAttribute("pornhub_customer_vip_time")));
		c.setPath("/"); // cookie路径为全局
		c.setMaxAge(168 * 60 * 60); // 保存一个星期
		resp.addCookie(c); // 返回客户端

		return customer;
	}

}
