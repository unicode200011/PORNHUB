package com.common.util;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil
{

	/**
	 * 更新COOKIE,根据MAP进行遍历封装
	 * 
	 * @param resp
	 * @param map
	 */
	public static void updateCookie( HttpServletResponse resp, Map<String, Object> map )
	{

		for (Map.Entry<String, Object> a : map.entrySet())
		{

			Cookie c = new Cookie(a.getKey(), a.getValue().toString());

			c.setPath("/"); // cookie路径为全局

			c.setMaxAge(168 * 60 * 60); // 保存一个星期

			resp.addCookie(c); // 返回客户端

		}
	}

	public static void invalidateCookie( HttpServletResponse resp, Map<String, Object> map )
	{
		for (Map.Entry<String, Object> a : map.entrySet())
		{

			Cookie c = new Cookie(a.getKey(), a.getValue().toString());

			c.setPath("/"); // cookie路径为全局

			c.setMaxAge(0); // 保存一个星期

			resp.addCookie(c); // 返回客户端

		}
	};

}
