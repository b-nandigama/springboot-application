package com.example.springbootapplication.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigProperties {
	private String hostName;
	private int port;
	private String from;
	
}
