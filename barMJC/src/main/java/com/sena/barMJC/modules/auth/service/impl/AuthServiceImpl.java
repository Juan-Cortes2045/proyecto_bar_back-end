package com.sena.barMJC.modules.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.barMJC.modules.auth.dto.request.ChangePasswordDTO;
import com.sena.barMJC.modules.auth.dto.request.LoginRequestDTO;
import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.dto.response.UserResponseDTO;
import com.sena.barMJC.modules.auth.entity.Role;
import com.sena.barMJC.modules.auth.entity.User;
import com.sena.barMJC.modules.auth.exceptions.InvalidCredentialsException;
import com.sena.barMJC.modules.auth.exceptions.RoleNotFoundException;
import com.sena.barMJC.modules.auth.exceptions.UserNotFoundException;
import com.sena.barMJC.modules.auth.mapper.UserMapper;
import com.sena.barMJC.modules.auth.repository.RoleRepository;
import com.sena.barMJC.modules.auth.repository.UserRepository;
import com.sena.barMJC.modules.auth.service.interfaces.AuthService;
import com.sena.barMJC.modules.auth.validator.AuthValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final AuthValidator authValidator;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO register(RegisterRequestDTO dto) {

        authValidator.validateRegister(dto);

        Role role = roleRepository
                .findById(dto.getRoleId())
                .orElseThrow(() ->
                        new RoleNotFoundException(
                                "Role not found with id: "
                                        + dto.getRoleId()
                        ));

        User user = userMapper.toEntity(dto);

        user.setRole(role);

        user.setPassword(
                passwordEncoder.encode(
                        dto.getPassword()
                )
        );

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO dto) {

        User user = userRepository
                .findByUsernameAndStatusTrue(
                        dto.getUsername()
                )
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid username or password"
                        ));

        if (!passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword()
        )) {

            throw new InvalidCredentialsException(
                    "Invalid username or password"
            );
        }

        return userMapper.toResponse(user);
    }

    @Override
    public void changePassword(
            Long userId,
            ChangePasswordDTO dto
    ) {

        authValidator.validateChangePassword(dto);

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: "
                                        + userId
                        ));

        if (!passwordEncoder.matches(
                dto.getCurrentPassword(),
                user.getPassword()
        )) {

            throw new InvalidCredentialsException(
                    "Current password is incorrect"
            );
        }

        user.setPassword(
                passwordEncoder.encode(
                        dto.getNewPassword()
                )
        );

        userRepository.save(user);
    }

    @Override
    public void deactivateUser(Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: "
                                        + userId
                        ));

        user.setStatus(false);

        userRepository.save(user);
    }

}