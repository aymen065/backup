package com.ads.library.library.services.impl;

import com.ads.library.library.dto.BooksNumberInBorrowing;
import com.ads.library.library.dto.BorrowingDTO;
import com.ads.library.library.models.*;
import com.ads.library.library.repositories.IBorrowingRepository;
import com.ads.library.library.services.*;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BorrowingServiceImpl implements IBorrowingService {

    private IBorrowingRepository borrowingRepository;
    private IStudentService studentService;
    private IBookService bookService;
    private Mapper mapper;
    @Override
    public Page<BorrowingDTO> getAllBorrowings(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return borrowingRepository.findAll(paging).map(borrowing -> mapper.map(borrowing, BorrowingDTO.class));
    }

    @Override
    public List<BorrowingDTO> getAllBorrowings() {
        return borrowingRepository.findAll().stream().map(borrowing -> mapper.map(borrowing, BorrowingDTO.class)).toList();
    }

    @Override
    public BorrowingDTO getBorrowingById(StudentBookKey id) {
        return mapper.map(borrowingRepository.findById(id).orElse(null),BorrowingDTO.class);

    }

    @Override
    public BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO) {
        if(borrowingDTO.getId() != null){
            if(borrowingDTO.getId().getStudent().getId() != null && borrowingDTO.getId().getBook().getId() != null){
                borrowingDTO.setId(mapper.map(studentService
                                .getStudentById(borrowingDTO.getId().getStudent().getId()), Student.class),
                        mapper.map(bookService.
                                getBookById(borrowingDTO.getId().getBook().getId()),Book.class));
            }

        }
        return mapper.map(borrowingRepository.save(mapper.map(borrowingDTO, Borrowing.class)), BorrowingDTO.class);
    }

    @Override
    public BorrowingDTO updateBorrowing(BorrowingDTO borrowingDTO) {
        return mapper.map(borrowingRepository.save(mapper.map(borrowingDTO,Borrowing.class)),BorrowingDTO.class);
    }

    @Override
    public void deleteBorrowingById(StudentBookKey id) {

        borrowingRepository.deleteById(id);
    }

    @Override
    public void deleteAllBorrowings() {
        borrowingRepository.deleteAll();

    }

    @Override
    public void deleteBorrowings(List<StudentBookKey> booksIds) {

    }

    @Override
    public Long getIssuedBooksNumber() {
        return borrowingRepository.count();
    }

    @Override
    public List<Object> countBooksInBorrowings() {
        return borrowingRepository.countBooksInBorrowings();
    }
}
