package com.example.service;

import com.example.entity.Usuarios;
import com.example.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Usuarios getUsuario(int id) {
        return usuariosRepository.findById(id).orElse(null);
    }
}
