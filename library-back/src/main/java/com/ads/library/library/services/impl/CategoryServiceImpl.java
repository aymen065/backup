package com.ads.library.library.services.impl;

import com.ads.library.library.dto.CategoryDTO;
import com.ads.library.library.dto.PublicationDTO;
import com.ads.library.library.models.Category;
import com.ads.library.library.models.Publication;
import com.ads.library.library.repositories.ICategoryRepository;
import com.ads.library.library.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository categoryRepository;
    private Mapper mapper;
    @Override
    public Page<CategoryDTO> findAllCategories(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return categoryRepository.findAll(paging).map(category -> mapper.map(category, CategoryDTO.class));
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
         return categoryRepository.findAll().stream().map(category -> mapper.map(category, CategoryDTO.class)).toList();
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapper.map(categoryRepository.findById(id).orElse(null), CategoryDTO.class);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return mapper.map(categoryRepository.save(mapper.map(categoryDTO,Category.class)), CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return mapper.map(categoryRepository.save(mapper.map(categoryDTO, Category.class)), CategoryDTO.class);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Override
    public void deleteCategories(List<Long> categoriesIds) {
        categoryRepository.deleteByIdIn(categoriesIds);
    }
}
