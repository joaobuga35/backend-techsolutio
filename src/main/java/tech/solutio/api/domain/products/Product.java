package tech.solutio.api.domain.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.solutio.api.domain.products.dto.ProductRequest;

@Table(name = "products")
@Entity(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String supplier;
    private Double price;

    public Product(ProductRequest productData) {
        this.name = productData.name();
        this.supplier = productData.supplier();
        this.price = productData.price();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSupplier() {
        return supplier;
    }

    public Double getPrice() {
        return price;
    }

}
