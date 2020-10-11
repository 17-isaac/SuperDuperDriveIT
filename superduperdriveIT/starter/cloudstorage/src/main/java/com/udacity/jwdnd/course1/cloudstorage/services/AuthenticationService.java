package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

public class AuthenticationService implements AuthenticationProvider {
    private UsersMapper usersMapper;
    private HashService hashService;

    @Autowired
    public AuthenticationService(UsersMapper usersMapper, HashService hashService){
        this.usersMapper = usersMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Users users = usersMapper.getUser(username);
        if(users != null){
            String encodedSalt = users.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if(users.getPassword().equals(hashedPassword)){
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
    }
        return null;
}

@Override
public boolean supports(Class<?> authentication){
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}