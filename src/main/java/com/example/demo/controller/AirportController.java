package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MockServiceAirportImp;

@RestController
@CrossOrigin("*")
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private MockServiceAirportImp msai;

	@RequestMapping(method = RequestMethod.GET)
	public String getAirports() {
		return msai.listAirports();
	}

	@GetMapping("/{term}")
	public String getAirportWithTerm(@PathVariable String term) {
		return msai.getAirportWithTerm(term);
	}

	@RequestMapping(method = RequestMethod.GET, params = "term")
	public Object getAirportWithpage(@RequestParam(defaultValue = 0 + "", required = false) String page,
			@RequestParam String term) {
		return msai.getAirportWithpage(page, term);
	}
}
