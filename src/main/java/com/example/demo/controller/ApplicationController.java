package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MockServiceImplementation;

@RestController
@CrossOrigin("*")
public class ApplicationController {

	@Autowired
	private MockServiceImplementation msi;

	@GetMapping("/calculateFare/{originCode}/{destinationCode}")
	public Object getCalculatedFare(@PathVariable String originCode, @PathVariable String destinationCode) {
		return msi.getCalculatedFare(originCode, destinationCode);
	}
}
