package com.mkshop.mkshop.controller;

import com.mkshop.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.model.Category;
import com.mkshop.mkshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<Category>>> getAllCategory() {
        return new ResponseEntity<>(
                new ResponseAPI<>(
                        this.categoryRepository.findAll(),
                        false, HttpStatus.OK.value(), null),
                HttpStatus.OK
        );
    }

    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Optional<Category>>> getCategoryById(@PathVariable String id) {
        try {
            Optional<Category> category = this.categoryRepository.findById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(category, false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<Category>> addCategory(@RequestBody Category category) {
        try {
            Category categorySaved = this.categoryRepository.save(category);
            return new ResponseEntity<>(
                    new ResponseAPI<>(categorySaved, false, HttpStatus.CREATED.value(), null),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Category>> editCategory(@RequestBody Category category, @PathVariable String id) {
        try {
            return this.categoryRepository.findById(id).map(c -> {
                c.setName(category.getName());
                this.categoryRepository.save(c);

                return new ResponseEntity<>(
                        new ResponseAPI<>(c, false, HttpStatus.OK.value(), null),
                        HttpStatus.OK
                );
            }).orElseGet(() -> {
                Category category1 = this.categoryRepository.save(category);

                return new ResponseEntity<>(
                        new ResponseAPI<>(category1, false, HttpStatus.CREATED.value(), null),
                        HttpStatus.CREATED
                );
            });
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, false, HttpStatus.CREATED.value(), e.toString()),
                    HttpStatus.CREATED
            );
        }
    }

    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteById(@PathVariable String id) {
        try {
            this.categoryRepository.deleteById(id);
            return new ResponseEntity<>(
                    new ResponseAPI<String>(
                            "Categoria removida com sucesso.",
                            false,
                            HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            "Erro ao excluir categoria",
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
