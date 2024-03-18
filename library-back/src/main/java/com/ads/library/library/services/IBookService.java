package com.ads.library.library.services;


import com.ads.library.library.dto.BookDTO;
import com.ads.library.library.models.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    Page<BookDTO> getAllBooks(Integer page, Integer size);
    BookDTO getBookById(Long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);

    void deleteBookById(Long id);
    void deleteAllBooks();

    void deleteBooks(List<Long> booksIds);

    Long getBooksNumber();


}
