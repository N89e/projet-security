package com.example.porjet_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello/public").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")     // Désactiver CSRF pour H2 console
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())     // Autoriser iframe pour H2 console
                )
                .formLogin(form -> form
                        .successHandler((request, response, authentication) -> {
                            if(authentication.getAuthorities().stream()
                                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                                response.sendRedirect("/hello/private");
                            } else {
                                response.sendRedirect("/current-user");
                            }
                        })
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
