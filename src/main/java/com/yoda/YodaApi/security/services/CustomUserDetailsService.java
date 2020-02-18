package com.yoda.YodaApi.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {

    UserDetails loadUserByUsernameAndSchool(String username, String domain) throws UsernameNotFoundException;

}
