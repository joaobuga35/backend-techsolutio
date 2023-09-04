package tech.solutio.api.domain.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.solutio.api.domain.products.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
