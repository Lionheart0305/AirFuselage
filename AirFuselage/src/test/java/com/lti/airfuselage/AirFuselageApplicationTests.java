package com.lti.airfuselage;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.airfuselage.model.User;
import com.lti.airfuselage.repository.UserRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class AirFuselageApplicationTests {
	
	@Autowired
	private UserRepository userRepo;

	@Test
	void register() {
		
		User u=new User();
		u.setFirstName("John");
		u.setLastName("Kale");
		u.setEmail("john@lti");
		u.setPassword("12345fsgs");
		u.setConfirmPassword("12345fsgs");
		u.setDateOfBirth(LocalDate.of(1999, 10, 20));
		u.setMobileNumber("78451865655");
		
		
		userRepo.add(u);
		
	}

}
