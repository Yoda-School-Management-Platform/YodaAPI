package com.yoda.YodaApi.security.services;

import com.yoda.YodaApi.models.User;
import com.yoda.YodaApi.repository.SchoolRepository;
import com.yoda.YodaApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsernameAndSchool(String username, String schoolName) throws UsernameNotFoundException {
        if (username.equals("") || schoolName.equals("")) {
            throw new UsernameNotFoundException("Username and domain must be provided");
        }
        User user = userRepository.findByUsernameAndSchool(username, schoolRepository.findSchoolByName(schoolName))
                .orElseThrow(() -> new UsernameNotFoundException("User/ School Not Found with username: " + username + "@" + schoolName));
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format("Username not found for domain, username=%s, domain=%s",
                            username, schoolName));
        }
        return UserDetailsImpl.build(user);
    }
}