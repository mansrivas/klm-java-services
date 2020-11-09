package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class ApplicationController {
	@Autowired
	private OAuth2RestOperations restO;

	@Autowired
	private Environment env;

	private String uri;

	@GetMapping("/airports")
	public Object getAirports() {
		uri = env.getProperty("method.name.list-airports");
		return restO.getForObject(uri, Object.class);
	}

	@GetMapping("/airports/{term}")
	public Object getAirportWithTerm(@PathVariable String term) {
		uri = env.getProperty("method.name.list-airports") + "?term={term}";
		return restO.getForObject(uri, Object.class, term);
	}

	@GetMapping("/airportswithCondition")
	public Object getAirportWithpage(@RequestParam(required = false) String page,
			@RequestParam(required = false) String term) {
		uri = env.getProperty("method.name.list-airports") + "?page={page}&term={term}";
		return restO.getForObject(uri, Object.class, page, term);
	}

	@GetMapping("/calculateFare/{origin_code}/{destination_code}")
	public Object getCalculatedFare(@PathVariable String origin_code, @PathVariable String destination_code) {
		return restO.getForObject("http://localhost:8080/fares/{origin_code}/{destination_code}", String.class,
				origin_code, destination_code);
	}
}
