package com.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.domain.User;
import com.usermanagement.exceptions.ServiceException;
import com.usermanagement.service.UserService;

/**
 * 
 * @author rathanakumark
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public String savePerson(@RequestBody User user) throws ServiceException {
		userService.CreateUser(user);
		return "User Created";
	}

	@GetMapping("/users")
	private List<User> getAllPersons() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	private User getPerson(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	private void deletePerson(@PathVariable("id") int id) {
		userService.deleteUserById(id);
	}

}
