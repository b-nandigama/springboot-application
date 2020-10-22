package com.example.springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapplication.configuration.ConfigProperties;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class SampleController {

	@Autowired
	private ConfigProperties config;
	
	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping("/greeting")
	public String greeting() {
		log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
		return "Hello!. Welcome Mr./Mrs."+appName;
	}
	
	@GetMapping("/getMail")
	public String getMail() {
		log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
		return "Mail Properties "+config.getHostName()+"-"+config.getPort()+"-"+config.getFrom(); 
	}
}
