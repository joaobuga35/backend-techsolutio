package tech.solutio.api.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password

) { }
