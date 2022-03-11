package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private IUserService userService;
	
	public UserController() 
	{
		System.out.println("In User Controller /=> Ctor");
	}
	
	//REST API end point to get all users
	@GetMapping
	public ResponseEntity<?> fetchAllUsers() 
	{
		System.out.println("in Fetch All users");
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	//REST API end point to add a new user
	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody User transisentUser) 
	{
		System.out.println("In Add new user");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(transisentUser));
	}
	
	//REST API end point to delete a user
	@DeleteMapping("/{userId}")
	public String deleteUserById(@PathVariable int userId) 
	{
		System.out.println("in Delete user ");
		return userService.deleteUser(userId);
	}
	
	//REST API end point to get a particular user details
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserDetailsById(@PathVariable int userId) 
	{
		System.out.println("in get User Details");
		return ResponseEntity.ok(userService.getUserDetailsById(userId));
	}
	
	//REST API end point to update a user
	@PutMapping
	public User updateUser(@RequestBody User detachedUser) 
	{
		System.out.println("in Update User Details");
		return userService.updateUserDetails(detachedUser);
	}

}
