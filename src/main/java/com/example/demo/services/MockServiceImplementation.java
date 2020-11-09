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
	public Object getAirports() {
		uri = env.getProperty("method.name.list-airports");
		return restO.getForObject(uri, Object.class);
	}

	@Override
	public Object getAirportWithTerm(String term) {
		uri = env.getProperty("method.name.list-airports") + "?term={term}";
		return restO.getForObject(uri, Object.class, term);
	}

	@Override
	public Object getAirportWithpage(String page, String term) {
		uri = env.getProperty("method.name.list-airports") + "?term={term}&page={page}";
		return restO.getForObject(uri, Object.class, term, page);
	}

	@Override
	public Object getCalculatedFare(String originCode, String destinationCode) {
		uri = env.getProperty("method.name.fare-calculate") + "/{originCode}/{destinationCode}";
		System.out.println(uri);
		return restO.getForObject(uri, String.class, originCode, destinationCode);
	}

}
