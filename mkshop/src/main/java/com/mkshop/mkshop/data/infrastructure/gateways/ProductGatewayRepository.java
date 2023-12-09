package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.model.ImageProduct;
import com.mkshop.mkshop.data.infrastructure.model.Product;
import com.mkshop.mkshop.data.infrastructure.persistence.CategoryRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ImageProductRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductRepository;
import com.mkshop.mkshop.data.mappers.ProductMapper;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public class ProductGatewayRepository implements ProductGateway {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ImageProductRepository imageProductRepository;

    public ProductGatewayRepository(
            ProductRepository productRepository,
            ProductMapper productMapper,
            CategoryRepository categoryRepository,
            ImageProductRepository imageProductRepository
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
        this.imageProductRepository = imageProductRepository;
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        Product product1 = this.productMapper.toModel(productEntity);

        Category c = this.categoryRepository.findById(productEntity.categoryId()).get();

        product1.setCategory(c);

        Product p = this.productRepository.save(product1);

        productEntity.imageProducts().stream().forEach(prod -> {
            ImageProduct imgProduct = new ImageProduct(prod.getImg_url(), p);
            this.imageProductRepository.save(imgProduct);
        });

        return this.productMapper.toEntity(p);
    }

    @Override
    public List<ProductEntity> getAllMainProducts() {

        return this.productRepository
                .findByMainIsTrue()
                .stream()
                .map(this.productMapper::toEntity).toList();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return this.productRepository
                .findAll()
                .stream()
                .map(this.productMapper::toEntity)
                .toList();
    }

    @Override
    public ProductEntity getProductById(String id) {
        return this.productRepository
                .findById(id)
                .map(this.productMapper::toEntity).orElse(null);
    }

    @Override
    public ProductEntity editProduct(String id, ProductEntity productEntity) {
        Product product1 = this.productRepository.findById(id).get();
        if(!product1.getId().isEmpty()) {
            product1.setName(!(productEntity.name().isEmpty()) ? productEntity.name() : product1.getName());

            product1.setComposition(productEntity.composition() != null ? productEntity.composition() : product1.getComposition());

            product1.setPrice(productEntity.price() != null ? productEntity.price() : product1.getPrice());

            if(productEntity.StockQuantity() >= 0) {
                product1.setStockQuantity(productEntity.StockQuantity());
            }
            product1.setFabricator(!Objects.equals(productEntity.fabricator(), "") ? productEntity.fabricator() : product1.getFabricator());

            Product p = this.productRepository.save(product1);

            return this.productMapper.toEntity(p);
        }
        return null;
    }

    @Override
    public String deleteProductById(String id) {
        this.productRepository.deleteById(id);
        return "Produto removido com sucesso.";
    }

    @Override
    public List<ProductEntity> getProductsByName(String name) {
        return this.productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this.productMapper::toEntity)
                .toList();
    }
}
