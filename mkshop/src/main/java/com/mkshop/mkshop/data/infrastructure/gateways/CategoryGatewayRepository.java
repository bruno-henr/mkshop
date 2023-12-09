package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.persistence.CategoryRepository;
import com.mkshop.mkshop.data.mappers.CategoryMapper;
import com.mkshop.mkshop.domain.entities.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CategoryGatewayRepository implements CategoryGateway {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryGatewayRepository(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        Category categorySaved = this.categoryRepository.save(this.categoryMapper.toModel(category));
        return this.categoryMapper.toEntity(categorySaved);
    }

    @Override
    public String deleteCategoryById(String id) {
        this.categoryRepository.deleteById(id);
        return "Categoria removida com sucesso.";
    }

    @Override
    public CategoryEntity editCategory(String id, CategoryEntity categoryEntity) {
        return this.categoryRepository.findById(id).map(c -> {
            c.setName(categoryEntity.name());
            this.categoryRepository.save(c);

            return this.categoryMapper.toEntity(c);
        }).orElseGet(() -> {
            Category category1 = this.categoryRepository
                    .save(this.categoryMapper.toModel(categoryEntity));

            return this.categoryMapper.toEntity(category1);
        });
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return this.categoryRepository
                .findAll()
                .stream()
                .map(this.categoryMapper::toEntity).toList();
    }

    @Override
    public CategoryEntity getCategoryById(String id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        return category.map(this.categoryMapper::toEntity).orElse(null);
    }
}
