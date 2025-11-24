package com.example.meme.memeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())   // nouvelle syntaxe obligatoire
                .csrf(csrf -> csrf.disable())       // nouvelle syntaxe
                .headers(headers -> headers
                        .frameOptions(frame -> frame.deny())
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()  // remplace antMatchers()
                        .anyRequest().permitAll()          // ou adapte selon besoin
                );

        return http.build();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "OPTIONS");
            }
        };
    }
}
