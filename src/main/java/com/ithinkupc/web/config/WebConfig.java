package com.ithinkupc.web.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.servlet.Filter;

@Configuration
@ComponentScan(basePackages= {"com.ithinkupc.web.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/layout").setViewName("layout");
		super.addViewControllers(registry);
		LayoutDialect dd;
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}

