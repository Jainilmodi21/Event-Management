package com.springrest.Event.rest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;



@Configuration
public class SecurityConfiguration {

	@Bean
	 public UserDetailsManager userDetailsManager(DataSource dataSource) {
	 return new JdbcUserDetailsManager(dataSource);
	 }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/events").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/events/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/events").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/events").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/events/**").hasRole("ADMIN")
                        
                        .requestMatchers(HttpMethod.GET, "/api/attendee").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/attendee/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/attendee").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/attendee").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/attendee/**").hasRole("ADMIN")
                        
                        .requestMatchers(HttpMethod.GET, "/api/location").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/location/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/location").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/location").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/location/**").hasRole("ADMIN")
                        
                        .requestMatchers(HttpMethod.GET, "/api/organizer").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/organizer/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/organizer").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/organizer").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/organizer/**").hasRole("ADMIN")
                        
                        
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}














