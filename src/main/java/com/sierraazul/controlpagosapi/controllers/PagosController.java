package com.sierraazul.controlpagosapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sierraazul.controlpagosapi.dto.PagosDto;
import com.sierraazul.controlpagosapi.mapper.PagosMapper;
import com.sierraazul.controlpagosapi.models.PagosModel;
import com.sierraazul.controlpagosapi.services.PagosService;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    @Autowired
    PagosService pagosService;
    
    @Autowired
    PagosMapper pagosMapper;

    @GetMapping()
    public Page<PagosModel> obtenerPagos(
            @PageableDefault(page = 0, size = 10000, sort = "id", direction = Direction.DESC) Pageable pageable) {
        return pagosService.obtenerPagos(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<PagosModel> obtenerPagoPorId(@PathVariable("id") Long id) {
        return pagosService.obtenerPorId(id);
    }

    @PutMapping(path = "/modificar")
    public PagosModel updateCustomer(@RequestBody PagosDto dto) {
        try {
            PagosModel entity = pagosService.obtenerPorId(dto.id).get();
            if (entity == null) {
                return null;
            } else {
                
            }
            pagosMapper.updatePagosFromDto(dto, entity);
            return pagosService.guardarPago(entity);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
