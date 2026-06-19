package com.sena.barMJC.modules.auth.controller;

import com.sena.barMJC.modules.auth.dto.request.ChangePasswordDTO;
import com.sena.barMJC.modules.auth.dto.request.LoginRequestDTO;
import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.dto.response.UserResponseDTO;
import com.sena.barMJC.modules.auth.service.interfaces.AuthService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @Valid @RequestBody RegisterRequestDTO dto
    ) {

        UserResponseDTO response =
                authService.register(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto
    ) {

        return ResponseEntity.ok(
                authService.login(dto)
        );
    }

    @PutMapping("/users/{id}/change-password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long id,
            @Valid @RequestBody ChangePasswordDTO dto
    ) {

        authService.changePassword(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deactivateUser(
            @PathVariable Long id
    ) {

        authService.deactivateUser(id);

        return ResponseEntity.noContent().build();
    }
}