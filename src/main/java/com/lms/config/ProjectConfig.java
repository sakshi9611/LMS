package com.lms.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		 enforces strict matching rules and raises an exception if there are any ambiguities 
//		 or multiple source property hierarchies.
		
//		modelMapper.getConfiguration().setAmbiguityIgnored(true);
//		this will tells ModelMapper to ignore ambiguities and not to raise exceptions.
		return new ModelMapper();

	}
}