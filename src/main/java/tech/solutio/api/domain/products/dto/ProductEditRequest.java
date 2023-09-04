package tech.solutio.api.domain.products.dto;

public record ProductEditRequest(
        String name,
        String supplier,
        Double price,
        String image
) { }
