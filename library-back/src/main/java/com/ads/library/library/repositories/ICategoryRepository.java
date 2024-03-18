package com.ads.library.library.repositories;

import com.ads.library.library.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    void deleteByIdIn(List<Long> ids);
}
