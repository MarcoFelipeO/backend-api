package com.backend.mapper;

import com.backend.dto.UsuarioDTO;
import com.backend.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toDto(Usuario usuario);
    Usuario toEntity(UsuarioDTO usuarioDTO);

}
