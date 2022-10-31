package com.fas10ver.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper getMapper() {
		
		ModelMapper mapper = new ModelMapper();
		
		mapper
		.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT);
		
		return mapper;
	}

}
