package com.sierraazul.controlpagosapi.dto;

import com.sierraazul.controlpagosapi.models.UsuarioModel;

import lombok.Data;

@Data
public class ResponseLoginDto {
    public UsuarioModel usuario;
    public String msg;
}
