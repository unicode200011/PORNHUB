package com.org.customer.service;

import java.util.Map;

public interface RegService
{
	/**
	 * 验证用户帐号是否已经存在
	 * 
	 * @param userAccount
	 * @return
	 */
	public Integer verificationAccount( String userAccount );

	public Integer verificationIp( String ip );

	/**
	 * 注册用户
	 * 
	 * @param map
	 * @return
	 */
	public Integer regCustomer( Map<String, Object> map );
}
