package com.lti.airfuselage;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.airfuselage.model.Flight;
import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;
import com.lti.airfuselage.repository.FlightRepository;
import com.lti.airfuselage.repository.UserRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class AirFuselageApplicationTests {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Test
	void register() {

		User u = new User();
		u.setFirstName("Sam");
		u.setLastName("Munro");
		u.setEmail("sam@lti");
		u.setPassword("wefcdfsgs");
		u.setDateOfBirth(LocalDate.of(1999, 10, 20));
		u.setMobileNumber("78451865655");

		userRepo.add(u);

	}

	@Test
	void addAdmin() {
		SystemAdmin admin = new SystemAdmin();
		admin.setFirstName("Admin");
		admin.setLastName("Singh");
		admin.setEmail("admin@lti");
		admin.setPassword("Admin");
		admin.setDateOfBirth(LocalDate.of(1990, 11, 20));
		admin.setMobileNumber("9758830865");

		userRepo.addAdmin(admin);
	}

	@Test
	void login() {
		int id = userRepo.login("sahil@lti", "12345");
		System.out.println(id);
	}

	@Test
	void add() {
		Flight f = new Flight();
		f.setDepartureTime(LocalDateTime.of(2020, 8, 25, 11, 45));
		f.setArrivalTime(LocalDateTime.of(2020, 8, 25, 12, 25));
		f.setDestination("Delhi");
		f.setSource("Lucknow");
		flightRepo.add(f);
	}

	@Test
	void viewRespectiveFlights() {
		System.out.println(flightRepo.viewRespectiveFlights("Delhi", "Mumbai"));
		// return viewRespectiveFlights();

	}

	@Test
	public void updateFlight() {
		Flight f = new Flight();
		f.setFlightNumber(20202);
		f.setDepartureTime(LocalDateTime.of(2020, 9, 2, 11, 00));
		f.setArrivalTime(LocalDateTime.of(2020, 9, 2, 13, 30));
		f.setSource("Delhi");
		f.setDestination("Lucknow");
		flightRepo.updateFlight(f);
	}

	@Test
	public void deleteFlight() {

		System.out.println(flightRepo.deleteFlight(20202));
	}

	@Test
	public void findAFlight() {

		System.out.println(flightRepo.findAFlight(20201));

	}

}
