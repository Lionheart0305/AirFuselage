package com.lti.airfuselage.repository;

import javax.transaction.Transactional;

import com.lti.airfuselage.model.Role;
import com.lti.airfuselage.model.User;

public interface UserRepository {

	void add(User user);

	void addRole(Role role);

	boolean isCustomerPresent(String email);

}