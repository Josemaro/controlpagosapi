package com.sierraazul.controlpagosapi.services;


import java.util.Optional;

import com.sierraazul.controlpagosapi.models.UsuarioModel;
import com.sierraazul.controlpagosapi.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    // public ArrayList<UsuarioModel> obtenerUsuarios(){
    //     return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    // }

    public Page<UsuarioModel> obtenerUsuarios(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }


    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public Page<UsuarioModel>  obtenerPorPrioridad(Integer prioridad,Pageable pageable) {
        return usuarioRepository.findByPrioridad(prioridad,pageable);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
