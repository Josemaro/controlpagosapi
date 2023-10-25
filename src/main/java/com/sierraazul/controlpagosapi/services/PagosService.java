package com.sierraazul.controlpagosapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sierraazul.controlpagosapi.models.PagosModel;
import com.sierraazul.controlpagosapi.repositories.PagosRepository;

@Service
public class PagosService {
    
    @Autowired
    PagosRepository pagosRepository;
        public Page<PagosModel> obtenerPagos(Pageable pageable){
        return pagosRepository.findAll(pageable);
    }
}
