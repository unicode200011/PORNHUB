package com.org.customer.dao;

import java.util.Map;

import com.common.base.MyBatisRepository;

@MyBatisRepository
public interface CustomerDao
{
	public Map<String, Object> recharge( Map<String, Object> map );

	public int updateCustomerVipTime( Map<String, Object> map );

	public int updateCardFlag( Map<String, Object> map );

	public int insertRecharge( Map<String, Object> map );
	
	public Map<String, Object> getCustomer(Map<String, Object> map);

}
