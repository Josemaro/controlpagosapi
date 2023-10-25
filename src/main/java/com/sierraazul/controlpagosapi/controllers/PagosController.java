package com.sierraazul.controlpagosapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sierraazul.controlpagosapi.dto.PagosFiltroDto;
import com.sierraazul.controlpagosapi.models.PagosModel;
import com.sierraazul.controlpagosapi.services.PagosService;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    @Autowired
    PagosService pagosService;

    @GetMapping()
    public Page<PagosModel> obtenerPagos(@PageableDefault(page = 0, size = 10000,sort = "id", direction = Direction.DESC) Pageable pageable) {
        return pagosService.obtenerPagos(pageable);
    }
}
