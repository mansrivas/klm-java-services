package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
public class MockServiceImplementation implements MockServiceI {

	@Autowired
	private Environment env;

	private String uri;

	@Autowired
	private OAuth2RestOperations restO;


	@Override
	public Object getCalculatedFare(String originCode, String destinationCode) {
		uri = env.getProperty("method.name.fare-calculate") + "/{originCode}/{destinationCode}";
		System.out.println(uri);
		return restO.getForObject(uri, String.class, originCode, destinationCode);
	}

}
