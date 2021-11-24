package com.example.controller;

import com.example.entity.ListaDeseos;
import com.example.entity.Usuarios;
import com.example.service.ListaDeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping(value = "/listaDeseos")
@RestController
public class ListaDeseosController {

    @Autowired
    private ListaDeseosService listaDeseosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListaDeseos> getAllListaDeseos(@PathVariable("id") int id){
        return ResponseEntity.ok(listaDeseosService.getListaDeseos(id));
    }

    @GetMapping
    public ResponseEntity<List<ListaDeseos>> getListaByUsuario(@RequestParam(name = "idUsuario",required = false) Integer idUsuario){
        List<ListaDeseos> list = new ArrayList<>();
        if (idUsuario == null){
            list = listaDeseosService.getAllListaDeseos();
            if (list.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            Usuarios usuarios = new Usuarios();
            usuarios.setIdUsuarios(idUsuario);
            list = listaDeseosService.findByUsuario(usuarios);
/*            if (list.isEmpty()){
                return ResponseEntity.notFound().build();
            }*/
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ListaDeseos> createListaDeseos(@RequestBody ListaDeseos listaDeseos){
        return ResponseEntity.ok(listaDeseosService.createListaDeseos(listaDeseos));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ListaDeseos> updateListaDeseos(@PathVariable("id") int id, @RequestBody ListaDeseos listaDeseos){
    listaDeseos.setIdDeseos(id);
    ListaDeseos listaDeseosbd = listaDeseosService.updateListaDeseos(listaDeseos);
    if (listaDeseos == null){
        ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(listaDeseosbd);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ListaDeseos> deleteListaDeseos(@PathVariable("id") int id){
        ListaDeseos listaDeseos = listaDeseosService.deleteListaDeseos(id);
        if (listaDeseos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaDeseos);
    }
}
