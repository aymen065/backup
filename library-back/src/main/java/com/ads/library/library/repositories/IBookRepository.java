package com.ads.library.library.repositories;

import com.ads.library.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Long> {
    void deleteByIdIn(List<Long> ids);
}
