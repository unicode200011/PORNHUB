package com.org.customer.dao;

import java.util.Map;

import com.common.base.MyBatisRepository;

@MyBatisRepository
public interface RegDao
{
	public Integer verificationAccount( String userAccount );

	public Integer regCustomer( Map<String, Object> map );
	
	public Integer verificationIp( String ip );


}
