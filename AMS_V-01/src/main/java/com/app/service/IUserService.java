package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService 
{
	//method to get a list of all users
	List<User> getAllUsers();

	//method to register a new user
	User registerUser(User transientUser);

	//method to delete a user
	String deleteUser(int userId);

	//method to get a particular user by id
	User getUserDetailsById(int userId);

	//method to update the details of a user
	User updateUserDetails(User detachedUser);

}
