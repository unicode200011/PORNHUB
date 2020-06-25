package com.org.customer.service;

import java.util.Map;

public interface LoginService {
	/**
	 * 登录 ,检查账号密码是否正确,如果正確返回個人信息
	 */
	public Map<String, Object> login(Map<String, Object> map);

}
