package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService 
{
	@Autowired
	private IUserRepository userRepo;

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public User registerUser(User transientUser) {
		return userRepo.save(transientUser);
	}

	@Override
	public String deleteUser(int userId) {
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			return "User Details deleted with Id: " + userId;
		}
		throw new RuntimeException("User with id: " + userId + " Not found!");
	}

	@Override
	public User getUserDetailsById(int userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new RuntimeException("User with id: " + userId + " Not found!"));
	}

	@Override
	public User updateUserDetails(User detachedUser) {
		return userRepo.save(detachedUser);
	}

}
