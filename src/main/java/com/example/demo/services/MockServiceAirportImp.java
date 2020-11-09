package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
public class MockServiceAirportImp implements MockServiceAirport {

	@Autowired
	private Environment env;

	private String uri;

	@Autowired
	private OAuth2RestOperations restO;

	@Override
	public String listAirports() {
		uri = env.getProperty("method.name.list-airports");
		return restO.getForObject(uri, String.class);
	}

	@Override
	public String getAirportWithTerm(String term) {
		uri = env.getProperty("method.name.list-airports") + "/{term}";
		System.out.println(uri + "...1");
		return restO.getForObject(uri, String.class, term);
	}

	@Override
	public Object getAirportWithpage(String page, String term) {
		uri = env.getProperty("method.name.list-airports") + "?term={term}&page={page}";
		return restO.getForObject(uri, Object.class, term, page);
	}

}
