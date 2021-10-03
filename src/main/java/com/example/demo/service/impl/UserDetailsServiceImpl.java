package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	   @Autowired
	   private UsuarioRepository usuarioRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Usuario usuario = usuarioRepository.findByUsername(username);
	        UserBuilder userBuilder = null;
	        if (usuario != null) {
	            userBuilder = User.withUsername(username);
	            userBuilder.disabled(false);
	            userBuilder.password(usuario.getPassword());
	            userBuilder.authorities(new SimpleGrantedAuthority("ROL_USER"));
	        } else {
	            throw new UsernameNotFoundException("Usuario no registrado");
	        }
	        return userBuilder.build();
	    }
}
