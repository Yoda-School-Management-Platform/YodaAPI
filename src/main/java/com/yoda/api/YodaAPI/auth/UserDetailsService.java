package com.yoda.api.YodaAPI.auth;

import com.yoda.api.YodaAPI.model.User;
import com.yoda.api.YodaAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private UserRepository userRepository;

    public UserDetailsService() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
