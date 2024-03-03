package com.baluchi.ecommerce.ecommerce.services.servicesjwt;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadedUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findFirstByEmail(username);
        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException("Username Not Found", null);
        return new org.springframework.security.core.usersdetails.User(optionalUser.get().getEmail(),optionalUser.get().getPassword(), new ArrayList<>());
    }
}
