package com.org.customer.dao;

import java.util.Map;

import com.common.base.MyBatisRepository;

@MyBatisRepository
public interface LoginDao
{
	public Map<String, Object> login(Map<String, Object> map);

}
