package com.org.customer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.customer.dao.RegDao;

@Service("regServiceImpl")
public class RegServiceImpl implements RegService
{
	@Autowired
	public RegDao regDao;

	@Override
	public Integer verificationAccount( String userAccount )
	{
		return regDao.verificationAccount(userAccount);
	}

	@Override
	public Integer regCustomer( Map<String, Object> map )
	{
		return regDao.regCustomer(map);
	}

	@Override
	public Integer verificationIp( String ip )
	{
		return regDao.verificationIp(ip);
	}

}
