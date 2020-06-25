package com.org.customer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.customer.dao.LoginDao;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao logindao;

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		return logindao.login(map);
	}

}
