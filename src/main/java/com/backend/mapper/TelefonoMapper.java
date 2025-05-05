package com.backend.mapper;


import com.backend.dto.TelefonoDTO;
import com.backend.entity.Telefono;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefonoMapper {

    TelefonoDTO toDTO(Telefono telefono);
    Telefono toEntity(TelefonoDTO telefonoDTO);
}
