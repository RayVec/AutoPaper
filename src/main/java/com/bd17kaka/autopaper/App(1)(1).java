package com.bd17kaka.autopaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bd17kaka.autopaper.controller.UserFilter;

/**
 * Hello world!
 *
 */
@EnableTransactionManagement
@SpringBootApplication
/*
public class App  {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"));
				container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html"));
				container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400.html"));
			}
		};
	}
}*/
public class App extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8089);
	}


	public App() {
		super();
//        setRegisterErrorPageFilter(true); // <- this one
	}

	@Bean
	public  ErrorPageFilter initErrorPageFilter() {
		ErrorPageFilter filter = new ErrorPageFilter();
		filter.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404.html"));
		filter.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500.html"));
		filter.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/error/400.html"));
		filter.addErrorPages(new ErrorPage(RuntimeException.class,"/error/500.html"));
		return filter;
	}
	
	@Bean
    public FilterRegistrationBean MyFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns("/*");
        registration.setName("UserFilter");
        registration.setOrder(1);
        return registration;
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
}
