package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lista_deseos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deseos")
    private int idDeseos;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usuarios")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Usuarios usuarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_productos")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Productos productos;
}
