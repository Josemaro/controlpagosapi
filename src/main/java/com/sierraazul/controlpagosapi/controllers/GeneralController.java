package com.sierraazul.controlpagosapi.controllers;

import java.util.Optional;

import com.sierraazul.controlpagosapi.dto.LoginDto;
import com.sierraazul.controlpagosapi.dto.ResponseLoginDto;
import com.sierraazul.controlpagosapi.models.UsuarioModel;
import com.sierraazul.controlpagosapi.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping
public class GeneralController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseLoginDto login(@RequestBody LoginDto login) {
        ResponseLoginDto response = new ResponseLoginDto();
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(login.password.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            login.password = hashtext;
            UsuarioModel result = usuarioService.obtenerPorCorreo(login.email).get();

            if (result.getEmail().equals(login.email) && result.getPassword().equals(login.password)) {
                response.setUsuario(result);
                response.setMsg("OK");
                return response;

            } else {
                response.setMsg("Usuario o contraseña incorrecta");
                return response;
            }
        }
        // For specifying wrong message digest algorithms
        catch (Exception e) {
            response.setMsg("No se encontró correo electrónico");
            return response;
        }
    }
}
