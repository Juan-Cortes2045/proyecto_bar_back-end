package com.sena.barMJC.modules.auth.dto.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class ChangePasswordDTO {

    @NotBlank
    private String currentPassword;

    @NotBlank
    @Size(min= 8)
    private String newPassword;

}