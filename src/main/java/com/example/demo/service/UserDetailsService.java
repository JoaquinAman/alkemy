package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

	  UserDetails loadUserByUsername(String username);
}
