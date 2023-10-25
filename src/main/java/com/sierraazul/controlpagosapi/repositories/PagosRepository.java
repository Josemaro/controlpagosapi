package com.sierraazul.controlpagosapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierraazul.controlpagosapi.models.PagosModel;

@Repository
public interface PagosRepository extends JpaRepository <PagosModel,Long>{
    
}
