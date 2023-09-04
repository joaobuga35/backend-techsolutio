package tech.solutio.api.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import tech.solutio.api.domain.products.Product;
import tech.solutio.api.domain.products.dto.DataProductsList;
import tech.solutio.api.domain.products.dto.ProductRequest;
import tech.solutio.api.domain.products.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(@Valid ProductRequest productData){
        Product newProduct = new Product(productData);

        return productRepository.save(newProduct);
    }

    public Page<DataProductsList> findAllUsers(@PageableDefault(sort = {"name"}) Pageable pagination){
        return productRepository.findAll(pagination).map(DataProductsList::new);
    }
}
