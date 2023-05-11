package com.robertp1.springbootspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    /**
     * UserDetails - This contract is the contract in Spring Security that defines the User, with its username, password and authorities.
     * UserDetailsService -> UserDetailsManager     (UserDetailsService is the contract used in order to retrieve the users. Or it's an object used to load the users from somewhere, like memory of the application, a file, a database or a web-service. )
     * PasswordEncoder - The object that deals with the hashing and matching of the password whenever a new password is sent for authentication purpose.
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();      /* In real life we would use this PasswordEncoder implementation, because NoOpPasswordEncoder is only for testing and learning purposes.*/
        return NoOpPasswordEncoder.getInstance();
    }

    // This provides to Springboot the possibility to find and access the users.
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("dwightSchrute")
                .password("123456")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("jimHalpert")
                .password("123456")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();

//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET).hasRole("ROLE_ADMIN")
//                .requestMatchers(HttpMethod.POST).hasAnyRole("ROLE_MANAGER")
//                .anyRequest().permitAll();

        http.authorizeHttpRequests()
                .requestMatchers("/hello").hasRole("ADMIN")
                .anyRequest().permitAll();

        return http.build();
   }
}
