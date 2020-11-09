package com.example.demo.services;

public interface MockServiceI {

	public Object getAirports();

	public Object getAirportWithTerm(String term);

	public Object getAirportWithpage(String page, String term);

	public Object getCalculatedFare(String originCode, String destinationCode);

}
