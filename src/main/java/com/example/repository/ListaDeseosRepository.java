package com.example.repository;

import com.example.entity.ListaDeseos;
import com.example.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaDeseosRepository extends JpaRepository<ListaDeseos, Integer> {
    public List<ListaDeseos> findByUsuarios(Usuarios usuario);
}
