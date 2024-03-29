package com.example.spring_boot_security.service;

import com.example.spring_boot_security.entity.MyUser;
import com.example.spring_boot_security.entity.User;
import com.example.spring_boot_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUsersByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found !");
        }

        return new MyUser(user);
    }





}

