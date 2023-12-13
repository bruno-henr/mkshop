package com.mkshop.mkshop.data.infrastructure.services;

import com.mkshop.mkshop.data.enums.UserRole;
import com.mkshop.mkshop.data.infrastructure.model.*;
import com.mkshop.mkshop.data.infrastructure.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPopularService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageProductRepository imageProductRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;
    @Autowired
    private UserRepository userRepository;

    public void populateDatabaseWithSampleData() {
        this.userRepository.save(
                new User(
                        "Bruno Henrique", "bruno_henrique2",
                        "123",
                        "(83) 993378760",
                        "90009",
                        null,
                        null,
                        UserRole.USER
                )
        );
        this.categoryRepository.saveAll(
                new ArrayList<>(
                        List.of(
                                new Category(null,"Higiene", null),
                                new Category(null,"Laticinios", null),
                                new Category(null,"Padaria", null),
                                new Category(null,"Proteinas", null),
                                new Category(null,"Frutas & vegetais", null),
                                new Category(null,"Cafés & Chás", null),
                                new Category(null,"Bebidas alcoólicas", null),
                                new Category(null,"Salgados", null),
                                new Category(null,"Farofas", null),
                                new Category(null,"Massas", null)
                        )
                )
        );

        this.productRepository.saveAll(
                new ArrayList<>(
                        List.of(
                                new Product(
                                        "Doritos 300g",
                                        17.50,
                                        "Elma Chips",
                                        null,
                                        100,
                                        "main-products/doritos.png",
                                        true, this.categoryRepository.findByName("Salgados"),
                                        null,
                                        null, null),


                                new Product(
                                        "Baggio Café Torrado",
                                        24.90,
                                        "Baggio",
                                        null,
                                        100,
                                        "main-products/cafe.png",
                                        true,
                                        this.categoryRepository.findByName("Cafés & Chás"),
                                        null,
                                        null, null),

                                new Product(
                                        "Cerveja Brahma Duplo Malte",
                                        24.90,
                                        "Brahma",
                                        null, 100,
                                        "main-products/cerveja.png",
                                        true, this.categoryRepository.findByName("Cafés & Chás"),
                                        null,
                                        null, null),
                                new Product(
                                        "Farofa Tradicional 250g",
                                        12.90,
                                        "Yoki",
                                        null, 100,
                                        "main-products/farinha-yoki.png",
                                        true, this.categoryRepository.findByName("Farofas"),
                                        null,
                                        null, null),
                                new Product(
                                        "Macarrão Penne",
                                        13.50,
                                        "Barilla",
                                        null, 100,
                                        "main-products/macarrao.png",
                                        true, this.categoryRepository.findByName("Massas"),
                                        null,
                                        null, null),
                                new Product(
                                        "Pipoca Premium",
                                        12.70,
                                        "Yoki",
                                        null, 100,
                                        "main-products/pipoca.png",
                                        true, this.categoryRepository.findByName("Salgados"),
                                        null,
                                        null, null)
                        )
                )
        );
    }
}
