package tech.solutio.api.domain.products.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ProductRequest(
        @NotBlank
        String name,
        @NotBlank
        String supplier,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false, message = "The field 'price' most be a positive number")
        Double price
) {
}
