package com.mkshop.mkshop.DTO;

import com.mkshop.mkshop.model.Category;
import com.mkshop.mkshop.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private Number price;
    private String fabricator;
    private String composition;
    private Integer stockQuantity;
    private String imgUrl;
    private String categoryId;

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
