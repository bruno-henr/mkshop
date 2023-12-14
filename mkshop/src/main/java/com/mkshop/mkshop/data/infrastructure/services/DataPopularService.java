package com.mkshop.mkshop.data.infrastructure.services;

import com.mkshop.mkshop.data.enums.UserRole;
import com.mkshop.mkshop.data.infrastructure.model.*;
import com.mkshop.mkshop.data.infrastructure.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                        "Bruno Henrique", "bruno_henr",
                        new BCryptPasswordEncoder().encode("123"),
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
                                new Category(null,"Massas", null),
                                new Category(null,"Suplementos", null),
                                new Category(null,"Maionese", null)
                        )
                )
        );

        this.productRepository.saveAll(
                new ArrayList<>(
                        List.of(
                                new Product(
                                        "Pré-Treino Crack 300g",
                                        109.00,
                                        "Demons Lab",
                                        null,
                                        100,
                                        "main-products/pre-treino.png",
                                        true, this.categoryRepository.findByName("Suplementos"),
                                        null,
                                        null, null),

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
                                        false, this.categoryRepository.findByName("Farofas"),
                                        null,
                                        null, null),
                                new Product(
                                        "Macarrão Penne",
                                        13.50,
                                        "Barilla",
                                        null, 100,
                                        "main-products/macarrao.png",
                                        false, this.categoryRepository.findByName("Massas"),
                                        null,
                                        null, null),
                                new Product(
                                        "Pipoca Premium",
                                        12.70,
                                        "Yoki",
                                        null, 100,
                                        "main-products/pipoca.png",
                                        false, this.categoryRepository.findByName("Salgados"),
                                        null,
                                        null, null),

                                new Product(
                                        "Pringles Creme & Cebola 109g",
                                        10.19,
                                        "Pringles",
                                        null, 100,
                                        "main-products/pringles-cebola.png",
                                        false, this.categoryRepository.findByName("Salgados"),
                                        null,
                                        null, null),
                                new Product(
                                        "Dr Peanut - Pasta de Amendoim 600g",
                                        49.99,
                                        "Dr Peanut",
                                        null, 100,
                                        "main-products/dr-peanut-pasta.png",
                                        false, this.categoryRepository.findByName("Suplementos"),
                                        null,
                                        null, null),
                                new Product(
                                        "Pringles Original 104g",
                                        10.19,
                                        "Pringles",
                                        null, 100,
                                        "main-products/pringles-original.png",
                                        false, this.categoryRepository.findByName("Salgados"),
                                        null,
                                        null, null),
                                new Product(
                                        "Vinho Chileno Branco 750ml",
                                        22.79,
                                        "Chilano",
                                        null, 100,
                                        "main-products/vinho-chileno.png",
                                        false, this.categoryRepository.findByName("Bebidas alcoólicas"),
                                        null,
                                        null, null),
                                new Product(
                                        "Heinz - Maionese, 390G",
                                        13.99,
                                        "Heinz",
                                        null, 100,
                                        "main-products/maionese-heinz.png",
                                        false, this.categoryRepository.findByName("Maionese"),
                                        null,
                                        null, null),

                                new Product(
                                        "3 Corações Café Torrado",
                                        15.79,
                                        "3 Corações",
                                        null, 100,
                                        "main-products/cafe-3-coracoes.png",
                                        false, this.categoryRepository.findByName("Cafés & Chás"),
                                        null,
                                        null, null)
                        )
                )
        );
    }
}
