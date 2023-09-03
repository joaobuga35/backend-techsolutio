package tech.solutio.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserEditRequest(

        String name ,
        @Email
        String email ,

        String password
) {
}
