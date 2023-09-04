package tech.solutio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.solutio.api.domain.products.Product;
import tech.solutio.api.domain.products.dto.DataProductsList;
import tech.solutio.api.domain.products.dto.ProductRequest;
import tech.solutio.api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataProductsList> register(@RequestBody @Valid ProductRequest productData, UriComponentsBuilder uriBuilder){
        Product newProduct = productService.createProduct(productData);
        var uri = uriBuilder.path("/product/{id}").buildAndExpand(newProduct.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataProductsList(newProduct));
    }

    @GetMapping
    public ResponseEntity findAllProducts(Pageable pagination){
        var products = productService.findAllUsers(pagination);
        return ResponseEntity.ok(products);
    }

}
