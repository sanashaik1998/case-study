package com.hcl.service;

import com.hcl.exception.ApplicationException;
import com.hcl.model.User;

public interface LoginService {

	public User validateUser(User user) throws ApplicationException;
}
