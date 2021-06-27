package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataJson {
	public static DataJson getFile(String fileName) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(fileName), DataJson.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstname")
	String firstname;

	@JsonProperty("lastname")
	String lastname;

	@JsonProperty("prefixemail")
	String prefixEmail;

	@JsonProperty("password")
	String password;

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String getPreFixEmail() {
		return prefixEmail;
	}

	public String getPassword() {
		return password;
	}
}
