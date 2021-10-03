package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.builder.UsuarioBuilder;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.SendMailService;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{


    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SendMailService sendMailService;

    @Override
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(UsuarioDto usuarioDto){
        Usuario usuario = new UsuarioBuilder().withUsuarioDto(usuarioDto).build();
        usuario = usuarioRepository.save(usuario);
        sendMailService.sendEmail(usuario);
        return usuario;
    }
}
