package com.example.service;

import com.example.entity.ListaDeseos;
import com.example.entity.Usuarios;
import com.example.repository.ListaDeseosRepository;
import com.example.service.ListaDeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeseosServiceImpl implements ListaDeseosService {

    @Autowired
    private ListaDeseosRepository listaDeseosRepository;

    @Override
    public List<ListaDeseos> getAllListaDeseos() {
        return listaDeseosRepository.findAll();
    }

    @Override
    public ListaDeseos createListaDeseos(ListaDeseos listaDeseos) {
        return listaDeseosRepository.save(listaDeseos);
    }

    @Override
    public ListaDeseos updateListaDeseos(ListaDeseos listaDeseos) {
        ListaDeseos listaDeseosbd = getListaDeseos(listaDeseos.getIdDeseos());

        if (listaDeseos == null) return  null;
        listaDeseosbd.setProductos(listaDeseos.getProductos());
        listaDeseos.setUsuarios(listaDeseos.getUsuarios());

        return listaDeseosRepository.save(listaDeseosbd);
    }

    @Override
    public ListaDeseos deleteListaDeseos(int id) {
        ListaDeseos listaDeseosbd = getListaDeseos(id);

        if (listaDeseosbd == null) return null;
        listaDeseosRepository.delete(listaDeseosbd);
        return listaDeseosbd;
    }

    @Override
    public List<ListaDeseos> findByUsuario(Usuarios usuario) {
        return listaDeseosRepository.findByUsuarios(usuario);
    }

    @Override
    public ListaDeseos getListaDeseos(int id) {
        return listaDeseosRepository.findById(id).orElse(null);
    }
}
