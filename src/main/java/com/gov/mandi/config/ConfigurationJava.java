package com.gov.mandi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigurationJava implements WebMvcConfigurer {
	
	 @Bean
	    public TilesConfigurer tilesConfigurer() {
	        TilesConfigurer tilesConfigurer = new TilesConfigurer();
	        tilesConfigurer.setDefinitions(
	          new String[] { "/WEB-INF/tilesDefinition.xml" });
	        tilesConfigurer.setCheckRefresh(true);
	        return tilesConfigurer;
	    }
	 
	 @Override
	 public void configureViewResolvers(ViewResolverRegistry registry) {
	        TilesViewResolver viewResolver = new TilesViewResolver();
	        registry.viewResolver(viewResolver);
	    }
}
