package com.example.controller;

import com.example.entity.Usuarios;
import com.example.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/usuarios")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Usuarios> getUsuario(@PathVariable("id") int id){
        Usuarios usuariosbd= usuariosService.getUsuario(id);
        if (usuariosbd == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuariosbd);
    }
}
