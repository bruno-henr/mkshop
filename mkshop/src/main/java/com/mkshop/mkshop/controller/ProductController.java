package com.mkshop.mkshop.controller;

import com.mkshop.mkshop.DTO.ProductDTO;
import com.mkshop.mkshop.ResponseAPI;
import com.mkshop.mkshop.model.Category;
import com.mkshop.mkshop.model.Product;
import com.mkshop.mkshop.repository.CategoryRepository;
import com.mkshop.mkshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<Product>>> getAllProduct() {
        try {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            this.productRepository.findAll(),
                            false,
                            HttpStatus.OK.value(),
                            null
                    ), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.OK.value(),
                            e.toString()
                    ), HttpStatus.OK
            );
        }
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Optional<Product>>> getProductById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            this.productRepository.findById(id),
                            false,
                            HttpStatus.OK.value(),
                            null
                    ), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.OK.value(),
                            e.toString()
                    ), HttpStatus.OK
            );
        }
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<ProductDTO>> addProduct(@RequestBody ProductDTO product) {
        try {
            Product product1 = product.toProduct();

            Category c = this.categoryRepository.findById(product.getCategoryId()).get();
            product1.setCategory(c);

            System.out.println(product1);
            Product productSaved = this.productRepository.save(product1);


            return new ResponseEntity<>(
                    new ResponseAPI<>(product, false, HttpStatus.CREATED.value(), null),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Product>> editProduct(@RequestBody Product product, @PathVariable String id) {
        try {
            Product product1 = this.productRepository.findById(id).get();
            if(!product1.getId().isEmpty()) {
                product1.setName(!(product.getName().isEmpty()) ? product.getName() : product1.getName());
                System.out.println("PORRAAAAa => "+product.getComposition());
                if(product.getComposition() != null) {
                    product1.setComposition(product.getComposition());
                }

                product1.setPrice(!(product.getPrice().equals(0)) ? product.getPrice() : product1.getPrice());

                if(product.getStockQuantity() >= 0) {
                    product1.setStockQuantity(product.getStockQuantity());
                }
                product1.setFabricator(product.getFabricator() != "" ? product.getFabricator() : product1.getFabricator());
                this.productRepository.save(product1);
                return new ResponseEntity<>(
                        new ResponseAPI<>(product1, false, HttpStatus.OK.value(), null), HttpStatus.OK
                );
            }

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteProductById(@PathVariable String id) {
        try {
            this.productRepository.deleteById(id);
            return new ResponseEntity<>(
                    new ResponseAPI<>("Produto removido com sucesso.", false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
