package com.solance.security;

import com.solance.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final CustomUserDetailsService userDetailsService;

    public SpringSecurity(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // GET requests: any authenticated user
                        .requestMatchers(HttpMethod.GET, "/customer/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/customer/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/customer/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/customer/**").hasRole("ADMIN")

                        // Accounts
                        .requestMatchers(HttpMethod.GET, "/account/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/account/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/account/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/account/**").hasRole("ADMIN")

                        // Deposit Transactions
                        .requestMatchers(HttpMethod.GET, "/deposit/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/deposit/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/deposit/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/deposit/**").hasRole("ADMIN")

                        // Payment Instructions
                        .requestMatchers(HttpMethod.GET, "/payment/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/payment/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/payment/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/payment/**").hasRole("ADMIN")

                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
