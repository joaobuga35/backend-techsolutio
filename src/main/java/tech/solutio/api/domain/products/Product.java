package tech.solutio.api.domain.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.solutio.api.domain.products.dto.ProductEditRequest;
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
    private  String image;

    public Product(ProductRequest productData) {
        this.name = productData.name();
        this.supplier = productData.supplier();
        this.price = productData.price();
        this.image = productData.image();
    }

    public void updateProduct(ProductEditRequest findProduct) {
        if (findProduct.name() != null){
            this.name = findProduct.name();
        }

        if (findProduct.supplier() != null){
            this.supplier = findProduct.supplier();
        }

        if (findProduct.price() != null){
            this.price = findProduct.price();
        }

        if (findProduct.image() != null){
            this.image = findProduct.image();
        }
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

    public String getImage() {
        return image;
    }
}
