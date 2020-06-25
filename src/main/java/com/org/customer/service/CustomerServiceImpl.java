package com.org.customer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.customer.dao.CustomerDao;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public Map<String, Object> recharge(Map<String, Object> map) {
		return customerDao.recharge(map);
	}

	@Override
	public int updateCustomerVipTime( Map<String, Object> map )
	{
		return customerDao.updateCustomerVipTime(map);
	}

	@Override
	public int updateCardFlag( Map<String, Object> map )
	{
		return customerDao.updateCardFlag(map);
	}

	@Override
	public int insertRecharge( Map<String, Object> map )
	{
		return customerDao.insertRecharge(map);
	}

	@Override
	public Map<String, Object> getCustomer( Map<String, Object> map )
	{
		
		return customerDao.getCustomer(map);
	}

}
