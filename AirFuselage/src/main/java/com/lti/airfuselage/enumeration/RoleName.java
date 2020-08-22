package com.lti.airfuselage.enumeration;

public enum RoleName {

	ROLE_SYSTEMADMIN, ROLE_PASSENGER;

	public String getName() {
		switch (this) {
		case ROLE_PASSENGER:
			return "ROLE_PASSENGER";
		case ROLE_SYSTEMADMIN:
			return "ROLE_SYSTEMADMIN";
		default:
			return "";
		}
	}
}
