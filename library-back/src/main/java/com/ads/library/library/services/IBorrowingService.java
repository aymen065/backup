package com.ads.library.library.services;

import com.ads.library.library.dto.BooksNumberInBorrowing;
import com.ads.library.library.dto.BorrowingDTO;
import com.ads.library.library.models.Book;
import com.ads.library.library.models.StudentBookKey;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IBorrowingService {
    Page<BorrowingDTO> getAllBorrowings(Integer page, Integer size);
    List<BorrowingDTO> getAllBorrowings();

    BorrowingDTO getBorrowingById(StudentBookKey id);
    BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO);
    BorrowingDTO updateBorrowing(BorrowingDTO borrowingDTO);

    void deleteBorrowingById(StudentBookKey id);
    void deleteAllBorrowings();

    void deleteBorrowings(List<StudentBookKey> borrowingsIds);

    Long getIssuedBooksNumber();
    List<Object> countBooksInBorrowings();
}
