package com.hcl.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.LoginDao;
import com.hcl.exception.ApplicationException;
import com.hcl.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDaoImpl;
	
	private static final Logger logger= LogManager.getLogger(LoginServiceImpl.class);
	
	@Override
	@Transactional
	public User validateUser(User user) throws ApplicationException {
	
		logger.info(user.getUserName()+" entered into validateUser method of LoginDao in service layer");
		return loginDaoImpl.validateUser(user);
	}
}
