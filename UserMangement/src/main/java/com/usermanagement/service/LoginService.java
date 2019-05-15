package com.usermanagement.service;

import com.usermanagement.domain.User;
import com.usermanagement.domain.UserLogin;
import com.usermanagement.exceptions.ServiceException;
/**
 * 
 * @author rathanakumark
 *
 */
public interface LoginService {

	User authenticateUser(UserLogin userLogin) throws ServiceException;

}
