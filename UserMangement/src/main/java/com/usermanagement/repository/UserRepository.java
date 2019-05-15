package com.usermanagement.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usermanagement.domain.User;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select user from User user where user.email = :email and user.password = :password")
	User findUserCredentials(@Param("email") String username, @Param("password") String Password);

	@Transactional
	@Modifying
	@Query("Update User user set user.lastLogin=:lastLogin  where user.email = :email and user.password = :password")
	void updateLastLogin(@Param("lastLogin") Date lastLogin, @Param("email") String username,
			@Param("password") String Password);

}
