package com.mkshop.mkshop.data.controller;

import com.mkshop.mkshop.data.DTO.ProductDTO;
import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.model.ImageProduct;
import com.mkshop.mkshop.data.infrastructure.model.Product;
import com.mkshop.mkshop.data.infrastructure.persistence.CategoryRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ImageProductRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
public class ProductController {

//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private ImageProductRepository imageProductRepository;
//
//    @GetMapping("/product/main")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<List<Product>>> getAllProduct() {
//        try {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            this.productRepository.findByMainIsTrue(),
//                            false,
//                            HttpStatus.OK.value(),
//                            null
//                    ), HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            null,
//                            true,
//                            HttpStatus.OK.value(),
//                            e.toString()
//                    ), HttpStatus.OK
//            );
//        }
//    }
//
//    @GetMapping("/product")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<List<Product>>> getAllProduct(
//            @RequestParam(value = "name", required = false) String name
//    ) {
//        try {
//            if(name == null) {
//                return new ResponseEntity<>(
//                        new ResponseAPI<>(
//                                this.productRepository.findAll(),
//                                false,
//                                HttpStatus.OK.value(),
//                                null
//                        ), HttpStatus.OK
//                );
//            }
//            List<Product> productList = this.productRepository.findByNameContainingIgnoreCase(name);
//            System.out.println("lista de carro => "+productList);
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            productList,
//                            false,
//                            HttpStatus.OK.value(),
//                            null
//                    ), HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            null,
//                            true,
//                            HttpStatus.OK.value(),
//                            e.toString()
//                    ), HttpStatus.OK
//            );
//        }
//    }
//
//    @GetMapping("/product/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<Optional<Product>>> getProductById(@PathVariable String id) {
//        try {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            this.productRepository.findById(id),
//                            false,
//                            HttpStatus.OK.value(),
//                            null
//                    ), HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            null,
//                            true,
//                            HttpStatus.OK.value(),
//                            e.toString()
//                    ), HttpStatus.OK
//            );
//        }
//    }
//
//    @PostMapping("/product")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ResponseAPI<ProductDTO>> addProduct(@RequestBody ProductDTO product) {
//        try {
//            Product product1 = product.toProduct();
//
//            Category c = this.categoryRepository.findById(product.getCategoryId()).get();
//
//            product1.setCategory(c);
//
//            System.out.println(product1);
//            Product p = this.productRepository.save(product1);
//
//            for (String img : product.getImagesProduct()) {
//                ImageProduct imgProduct = new ImageProduct(img, p);
//                this.imageProductRepository.save(imgProduct);
//            }
//
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(product, false, HttpStatus.CREATED.value(), null),
//                    HttpStatus.CREATED
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
//
//    @PutMapping("/product/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<Product>> editProduct(@RequestBody Product product, @PathVariable String id) {
//        try {
//            Product product1 = this.productRepository.findById(id).get();
//            if(!product1.getId().isEmpty()) {
//                product1.setName(!(product.getName().isEmpty()) ? product.getName() : product1.getName());
//                System.out.println("PORRAAAAa => "+product.getComposition());
//                if(product.getComposition() != null) {
//                    product1.setComposition(product.getComposition());
//                }
//
//                product1.setPrice(!(product.getPrice().equals(0)) ? product.getPrice() : product1.getPrice());
//
//                if(product.getStockQuantity() >= 0) {
//                    product1.setStockQuantity(product.getStockQuantity());
//                }
//                product1.setFabricator(product.getFabricator() != "" ? product.getFabricator() : product1.getFabricator());
//                this.productRepository.save(product1);
//                return new ResponseEntity<>(
//                        new ResponseAPI<>(product1, false, HttpStatus.OK.value(), null), HttpStatus.OK
//                );
//            }
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//
//        return new ResponseEntity<>(
//                new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), null),
//                HttpStatus.BAD_REQUEST
//        );
//    }
//
//    @DeleteMapping("/product/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<String>> deleteProductById(@PathVariable String id) {
//
//        try {
//            this.productRepository.deleteById(id);
//            System.out.println("DELETARRRRR"+id);
//            Product p = this.productRepository.findById(id).get();
//            System.out.println("essa piriquita "+p);
//
//            return new ResponseEntity<>(
//                    new ResponseAPI<>("Produto removido com sucesso.", false, HttpStatus.OK.value(), null),
//                    HttpStatus.OK
//            );
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
}
