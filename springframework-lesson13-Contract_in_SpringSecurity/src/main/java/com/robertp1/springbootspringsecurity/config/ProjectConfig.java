package com.robertp1.springbootspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    /**
     * UserDetails - This contract is the contract in Spring Security that defines the User, with its username, password and authorities.
     * UserDetailsService -> UserDetailsManager     (UserDetailsService is the contract used in order to retrieve the users. Or it's an object used to load the users from somewhere, like memory of the application, a file, a database or a web-service. )
     * PasswordEncoder - The object that deals with the hashing and matching of the password whenever a new password is sent for authentication purpose.
     */

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        return manager;
    }
}
