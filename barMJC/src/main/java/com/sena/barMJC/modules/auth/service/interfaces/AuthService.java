package com.sena.barMJC.modules.auth.service.interfaces;

import com.sena.barMJC.modules.auth.dto.request.ChangePasswordDTO;
import com.sena.barMJC.modules.auth.dto.request.LoginRequestDTO;
import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.dto.response.UserResponseDTO;

public interface AuthService {

    UserResponseDTO register(RegisterRequestDTO dto);

    UserResponseDTO login(LoginRequestDTO dto);

    void changePassword(
            Long userId,
            ChangePasswordDTO dto
    );

    void deactivateUser(Long userId);
}