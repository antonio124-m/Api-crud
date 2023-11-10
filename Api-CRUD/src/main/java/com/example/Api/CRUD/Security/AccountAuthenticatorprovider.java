package com.example.Api.CRUD.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountAuthenticatorprovider extends AbstractUserDetailsAuthenticationProvider {


    private final UserDetailsService userDetailsService;


    private  final PasswordEncoder encoder;
   @Autowired
    public AccountAuthenticatorprovider(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
       if (authentication.getCredentials() == null & userDetails.getPassword() == null){
           throw  new BadCredentialsException("credentials may not be null");
       }

       if (encoder.matches((String)authentication.getCredentials(), userDetails.getPassword())){
           throw  new BadCredentialsException("invalid crediantials");
       }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }
}
