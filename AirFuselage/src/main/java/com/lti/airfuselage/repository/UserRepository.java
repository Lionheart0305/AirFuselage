package com.lti.airfuselage.repository;

import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;

public interface UserRepository {

	void add(User user);

	void addAdmin(SystemAdmin admin);

	boolean isUserPresent(String email);

	int login(String email, String password);

	User findById(int userId);

}
