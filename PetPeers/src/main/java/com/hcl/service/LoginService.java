package com.hcl.service;

import com.hcl.exception.ApplicationException;
import com.hcl.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

public interface LoginService {

	public User validateUser(User user) throws ApplicationException;
}
