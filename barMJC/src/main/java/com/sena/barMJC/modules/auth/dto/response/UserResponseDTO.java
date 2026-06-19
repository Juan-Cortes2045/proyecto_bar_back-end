package com.sena.barMJC.modules.auth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String username;

    private String email;

    private String role;

    private String workerName;

    private Boolean status;

}