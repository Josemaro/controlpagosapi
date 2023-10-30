package com.sierraazul.controlpagosapi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sierraazul.controlpagosapi.dto.PagosDto;
import com.sierraazul.controlpagosapi.models.PagosModel;

@Mapper(componentModel = "spring")
public interface PagosMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePagosFromDto(PagosDto dto, @MappingTarget PagosModel entity);
    
}