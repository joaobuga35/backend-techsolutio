package tech.solutio.api.domain.products.dto;

import tech.solutio.api.domain.products.Product;

public record DataProductsList(Long id, String name, String supplier, Double price) {
    public DataProductsList(Product newProduct) {
        this(newProduct.getId() , newProduct.getName() , newProduct.getSupplier() , newProduct.getPrice());
    }
}
