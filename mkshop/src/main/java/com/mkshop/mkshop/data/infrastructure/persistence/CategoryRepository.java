package com.mkshop.mkshop.data.infrastructure.persistence;

import com.mkshop.mkshop.data.infrastructure.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
