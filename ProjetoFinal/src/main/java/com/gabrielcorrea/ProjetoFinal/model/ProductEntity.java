package com.gabrielcorrea.ProjetoFinal.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "setor")
    private String setor;

}
