package com.yoda.YodaApi.security.jwt;

import java.util.Collection;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String schoolName;

    public CustomAuthenticationToken(Object principal, Object credentials, String schoolName) {
        super(principal, credentials);
        this.schoolName = schoolName;
        super.setAuthenticated(false);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, String schoolName,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.schoolName = schoolName;
        super.setAuthenticated(true); // must use super, as we override
    }

    public String getSchoolName() {
        System.out.println("exe");
        return schoolName;

    }
}
