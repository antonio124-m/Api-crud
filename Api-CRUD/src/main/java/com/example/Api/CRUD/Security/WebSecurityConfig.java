package com.example.Api.CRUD.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig {

    private  final AccountAuthenticatorprovider accountAuthenticatorprovider;

    @Autowired

    public WebSecurityConfig(AccountAuthenticatorprovider accountAuthenticatorprovider) {
        this.accountAuthenticatorprovider = accountAuthenticatorprovider;
    }

//    @Bean

//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(null);
//          http.csrf().disable();
//          http.authorizeRequests()
//                  .requestMatchers(POST,"/api/**").permitAll();
//          http.authorizeRequests()
//                  .anyRequest()
//                  .hasAnyRole("USER", "ADMIN")
//                  .and()
//                  .httpBasic(Customizer.withDefaults())
//                  .sessionManagement()
//                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                  return http.build();


//     }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(null);


        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(POST,"/api/**")

                .permitAll();
        http.authorizeRequests()
                .anyRequest()
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic(Customizer.withDefaults())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }



}


