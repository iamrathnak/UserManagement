package com.usermanagement.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.domain.User;
import com.usermanagement.domain.UserLogin;
import com.usermanagement.exceptions.ServiceException;
import com.usermanagement.service.LoginService;
import com.usermanagement.utils.ResponseBuilder;

/**
 * 
 * @author rathanakumark
 *
 */
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseBuilder authenticateUser(@RequestBody UserLogin userLogin) throws ServiceException {
		User userDetails = loginService.authenticateUser(userLogin);
		if (userDetails == null) {
			return new ResponseBuilder("F00", "Failed to login. Please try again! ", userDetails);
		}

		return new ResponseBuilder("S00", "Login Success", userDetails);
	}
}
