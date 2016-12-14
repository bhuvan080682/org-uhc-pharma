package org.uhc.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private AccountUserDetailService userDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		System.out.println("#userDetails#");
		System.out.println("Username > "+userDetails.getUsername() + "Password" + userDetails.getPassword());;
		System.out.println("token > "+token.getCredentials());
		System.out.println("##################insedie AccountAuthenticationProvider.additionalAuthenticationChecks()>>>>>>>>>>>>>>>>>>>>>>>>");
		if(token.getCredentials()==null || userDetails.getPassword() == null){
			throw new BadCredentialsException("Credentials may not be null");
		}
		
		if(!passwordEncoder.matches((String) token.getCredentials(), userDetails.getPassword())){
			throw new BadCredentialsException("Invalid Credentials");
		}
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<End############################################");
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		System.out.println("##################inside AccountAuthenticationProvider.retrieveUser()>>>>>>>>>>>>>>>>>>>>>>>>");
		UserDetails userDetails = userDetailService.loadUserByUsername(username);
		return userDetails;
	}

}
