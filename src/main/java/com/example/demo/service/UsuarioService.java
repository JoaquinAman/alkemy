package com.example.demo.service;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.model.Usuario;

public interface UsuarioService {

    Usuario findByUsername(String username);
    Usuario save(UsuarioDto usuarioDto);
}
