package com.sena.barMJC.modules.auth.service.impl;

import org.springframework.stereotype.Service;

import com.sena.barMJC.modules.auth.dto.request.LoginRequestDTO;
import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.dto.response.UserResponseDTO;
import com.sena.barMJC.modules.auth.service.interfaces.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public UserResponseDTO register(RegisterRequestDTO dto) {
        return null;
    }
    
    @Override
    public UserResponseDTO login(LoginRequestDTO dto) {
        return null;
    }

    @Override
    public void changePassword(
            Long userId,
            String currentPassword,
            String newPassword
    ) {

    }

    @Override
    public void deactivateUser(Long userId) {

    }
}