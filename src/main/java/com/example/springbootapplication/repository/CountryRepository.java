package com.example.springbootapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootapplication.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	Country findByName(String name);
}
