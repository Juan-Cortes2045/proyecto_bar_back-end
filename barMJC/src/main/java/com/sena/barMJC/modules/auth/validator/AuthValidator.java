package com.sena.barMJC.modules.auth.validator;

import org.springframework.stereotype.Component;

import com.sena.barMJC.modules.auth.dto.request.ChangePasswordDTO;
import com.sena.barMJC.modules.auth.dto.request.LoginRequestDTO;
import com.sena.barMJC.modules.auth.dto.request.RegisterRequestDTO;
import com.sena.barMJC.modules.auth.entity.User;
import com.sena.barMJC.modules.auth.exceptions.InvalidCredentialsException;
import com.sena.barMJC.modules.auth.exceptions.UserAlreadyExistsException;
import com.sena.barMJC.modules.auth.repository.RoleRepository;
import com.sena.barMJC.modules.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthValidator {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void validateRegister(RegisterRequestDTO dto) {

        validateUsernameNotExists(dto.getUsername());

        validateEmailNotExists(dto.getEmail());

        validateRoleExists(dto.getRoleId());
    }


    public void validateUsernameNotExists(String username) {

        if (userRepository.existsByUsername(username)) {

            throw new UserAlreadyExistsException(
                    "Username already exists: " + username
            );
        }
    }

    public void validateEmailNotExists(String email) {

        if (userRepository.existsByEmail(email)) {

            throw new UserAlreadyExistsException(
                    "Email already exists: " + email
            );
        }
    }

    public void validateRoleExists(Long roleId) {

        if (!roleRepository.existsById(roleId)) {

            throw new IllegalArgumentException(
                    "Role not found with id: " + roleId
            );
        }
    }


    public void validateLogin(
            LoginRequestDTO dto,
            User user
    ) {

        if (user == null) {

            throw new InvalidCredentialsException(
                    "Invalid username or password"
            );
        }

        if (!Boolean.TRUE.equals(user.getStatus())) {

            throw new InvalidCredentialsException(
                    "User account is inactive"
            );
        }
    }

    public void validateChangePassword(
            ChangePasswordDTO dto
    ) {

        if (dto.getCurrentPassword()
                .equals(dto.getNewPassword())) {

            throw new IllegalArgumentException(
                    "The new password must be different from the current password"
            );
        }
    }

 
    public void validateUserIsActive(
            User user
    ) {

        if (user == null) {

            throw new IllegalArgumentException(
                    "User not found"
            );
        }

        if (!Boolean.TRUE.equals(user.getStatus())) {

            throw new IllegalArgumentException(
                    "User is already inactive"
            );
        }
    }
}