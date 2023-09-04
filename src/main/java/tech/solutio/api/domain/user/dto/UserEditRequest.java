package tech.solutio.api.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserEditRequest(

        String name ,
        @Email
        String email ,

        String password
) {
}
