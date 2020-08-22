package com.lti.airfuselage.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.airfuselage.model.Role;
import com.lti.airfuselage.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void add(User user) {
		
		em.merge(user);
		
	}
	
	@Transactional
	@Override
	public void addRole(Role role) {
		
		em.merge(role);
		
	}
	@Override
	public boolean isCustomerPresent(String email) {
		return (Long) em.createQuery("select count(u.id) from User u where u.email =: e")
				.setParameter("e", email).getSingleResult() ==1? true:false;
	}

}

