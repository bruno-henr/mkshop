package com.mkshop.mkshop.data.DTO;

import com.mkshop.mkshop.data.infrastructure.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private Number price;
    private String fabricator;
    private String composition;
    private Integer stockQuantity;
    private String imgUrl;
    private boolean main;
    private String categoryId;
    private List<String> imagesProduct = new ArrayList<>();

    public Product toProduct() {
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
        product.setFabricator(this.fabricator);
        product.setComposition(this.composition);
        product.setStockQuantity(this.stockQuantity);
        product.setImg_url(this.imgUrl);

        return product;
    }

}
