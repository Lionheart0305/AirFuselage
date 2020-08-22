package com.lti.airfuselage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.controller.UserControllerImpl.Status.StatusType;
import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.User;
import com.lti.airfuselage.service.UserService;

@RestController
@CrossOrigin
public class UserControllerImpl  {
	
	@Autowired
	private UserService userService;

	//@RequestMapping(path="/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public Status register(@RequestBody User user) {
		Status status= new Status();
		try {
			userService.register(user);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful");
		}catch (CustomerServiceException e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
		}
		return status;
	}
	
	public static class Status {
		private StatusType status;
		private String message;
		
		public static enum StatusType{
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		

	}

}

