package com.example.service;

import com.example.entity.Productos;
import com.example.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> listAllProductos() {
        return productosRepository.findAll();
    }
}
