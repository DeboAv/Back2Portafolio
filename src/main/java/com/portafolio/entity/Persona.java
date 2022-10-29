package com.daa2.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id auto generado
    private Long id;

    @NotNull
    @Size(min = 1, max=50, message = "Cantidad de caracteres incorrecta")
    private String nombre;

    @NotNull
    @Size(min = 1, max=50, message = "Cantidad de caracteres incorrecta")
    private String apellido;

    private String img;
}
