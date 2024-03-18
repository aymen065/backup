package com.ads.library.library.services.impl;

import com.ads.library.library.dto.BookDTO;
import com.ads.library.library.models.Book;
import com.ads.library.library.models.Category;
import com.ads.library.library.models.Publication;
import com.ads.library.library.repositories.IBookRepository;
import com.ads.library.library.services.IBookService;
import com.ads.library.library.services.ICategoryService;
import com.ads.library.library.services.IPublicationService;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBookService {
    private IBookRepository bookRepository;
    private ICategoryService categoryService;
    private IPublicationService publicationService;
    private Mapper mapper;
    @Override
    public Page<BookDTO> getAllBooks(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return bookRepository.findAll(paging).map(book -> mapper.map(book, BookDTO.class));
    }

    @Override
    public BookDTO getBookById(Long id) {
        return mapper.map(bookRepository.findById(id).orElse(null),BookDTO.class);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        if(bookDTO.getCategory() != null){
            bookDTO.setCategory(mapper.map(categoryService.findById(bookDTO.getCategory().getId()), Category.class));
        }
        if(bookDTO.getPublication() != null){
            bookDTO.setPublication(mapper.map(publicationService.getPublicationById(bookDTO.getPublication().getId()), Publication.class));
        }
        return mapper.map(bookRepository.save(mapper.map(bookDTO, Book.class)), BookDTO.class);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        return mapper.map(bookRepository.save(mapper.map(bookDTO,Book.class)),BookDTO.class);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public void deleteBooks(List<Long> booksIds) {
        bookRepository.deleteByIdIn(booksIds);
    }

    @Override
    public Long getBooksNumber() {
        return bookRepository.count();
    }
}
