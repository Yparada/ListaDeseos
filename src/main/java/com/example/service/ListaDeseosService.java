package com.example.service;

import com.example.entity.ListaDeseos;
import com.example.entity.Usuarios;

import java.util.List;

public interface ListaDeseosService {
    public List<ListaDeseos> getAllListaDeseos();
    public ListaDeseos createListaDeseos(ListaDeseos listaDeseos);
    public ListaDeseos updateListaDeseos(ListaDeseos listaDeseos);
    public ListaDeseos deleteListaDeseos(int id);
    public List<ListaDeseos> findByUsuario(Usuarios usuario);
    public ListaDeseos getListaDeseos(int id);
}
