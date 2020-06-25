package com.org.customer.service;

import java.util.Map;

public interface CustomerService {
	public Map<String, Object> recharge(Map<String, Object> map);
	
	
	public int updateCustomerVipTime(Map<String, Object> map);
	
	public int updateCardFlag(Map<String, Object> map);

	public int insertRecharge(Map<String, Object> map);
	
	public Map<String, Object> getCustomer(Map<String, Object> map);

}
