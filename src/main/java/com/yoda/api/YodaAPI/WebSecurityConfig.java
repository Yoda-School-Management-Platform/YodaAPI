package com.yoda.api.YodaAPI;

import com.yoda.api.YodaAPI.auth.AuthSuccessHandlerImpl;
import com.yoda.api.YodaAPI.auth.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    @Autowired
    private AuthSuccessHandlerImpl successHandler;


  /*  @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Regeln werden von oben nach unten berücksichtigt

        http
                .authorizeRequests()

                .antMatchers("/api/**").permitAll()
                    .antMatchers("/api/schools/register").hasAnyRole("TEST")
                    .and()
                    .formLogin()
                    .successHandler(successHandler)
                    .and()
                    .csrf().disable()
                .authorizeRequests()
                    .anyRequest().denyAll();
    }

/*
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }*/
}
