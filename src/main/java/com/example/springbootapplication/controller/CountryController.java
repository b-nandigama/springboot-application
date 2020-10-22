package com.example.springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapplication.entity.Country;
import com.example.springbootapplication.repository.CountryRepository;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/{name}")
	public Country findByName(@PathVariable String name) {
		return countryRepository.findByName(name);
	}
}
