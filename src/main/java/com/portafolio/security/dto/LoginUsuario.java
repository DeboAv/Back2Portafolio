package com.daa2.security.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    public LoginUsuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
}
