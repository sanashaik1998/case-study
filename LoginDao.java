package com.hcl.dao;

import com.hcl.exception.ApplicationException;
public interface LoginDao {

	public User validateUser(User user) throws ApplicationException;
}
