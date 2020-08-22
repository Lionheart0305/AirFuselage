package com.lti.airfuselage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.User;
import com.lti.airfuselage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void register(User user) {
		if (!userRepo.isCustomerPresent(user.getEmail()))
			userRepo.add(user);
		else
			throw new CustomerServiceException("User Already Registered");

	}

}
