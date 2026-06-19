package com.sena.barMJC.modules.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.dto.response.UserResponseDTO;
import com.sena.barMJC.modules.auth.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)

    @Mapping(target = "role", ignore = true)

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)

    User toEntity(RegisterRequestDTO dto);

    @Mapping(
            target = "role",
            source = "role.name"
    )
    UserResponseDTO toResponse(User user);

}