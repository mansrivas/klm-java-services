package com.example.demo.services;

public interface MockServiceAirport {

	public String listAirports();

	public String getAirportWithTerm(String term);

	public Object getAirportWithpage(String page, String term);
}
