package com.sierraazul.controlpagosapi.controllers;

import java.util.Optional;

import com.sierraazul.controlpagosapi.models.UsuarioModel;
import com.sierraazul.controlpagosapi.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    // @GetMapping()
    // public ArrayList<UsuarioModel> obtenerUsuarios(){
    //     return usuarioService.obtenerUsuarios();
    // }

    @GetMapping()
    public Page<UsuarioModel> obtenerUsuarios(@PageableDefault(page = 0, size = 15)  Pageable pageable){
        return usuarioService.obtenerUsuarios(pageable);
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public Page<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad,@PageableDefault(page = 0, size = 15)  Pageable pageable){
        return this.usuarioService.obtenerPorPrioridad(prioridad,pageable);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
