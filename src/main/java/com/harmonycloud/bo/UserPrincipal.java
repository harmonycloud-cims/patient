package com.harmonycloud.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String givenName;

    private String surName;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer userId, String givenName, String surName, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.givenName = givenName;
        this.surName = surName;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }


    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public String getUsername() {
        String username = givenName + "," + surName;
        return username;
    }
}
