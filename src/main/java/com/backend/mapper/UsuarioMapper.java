package com.backend.mapper;

import com.backend.dto.UsuarioDTO;
import com.backend.entity.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {TelefonoMapper.class})
public interface UsuarioMapper {

    @Mappings({
            @Mapping(target = "password", ignore = true), //no queremos mapear password en el DTO
            @Mapping(target = "usuario_id", ignore = true) //no queremos pasar el id
    })
    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUsuarioFromDto(UsuarioDTO dto, @MappingTarget Usuario usuario);
}
