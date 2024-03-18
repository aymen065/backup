package com.ads.library.library.services;

import com.ads.library.library.dto.CategoryDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    Page<CategoryDTO> findAllCategories(Integer page, Integer size);
List<CategoryDTO> findAllCategories();
    CategoryDTO findById(Long id);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void deleteCategories(List<Long> categoriesIds);

    void deleteCategoryById(Long id);
    void deleteAllCategories();
}
