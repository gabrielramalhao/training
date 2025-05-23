package com.studies.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

@SpringBootApplication
public class TrainingApplication {

	private static final String ACCOUNT_SID = System.getenv("twilio_account_sid");

	private static final String AUTH_TOKEN = System.getenv("twilio_auth_token");

	public static void main(String[] args) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		SpringApplication.run(TrainingApplication.class, args);
	}

}
