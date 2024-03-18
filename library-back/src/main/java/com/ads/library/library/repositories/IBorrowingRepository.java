package com.ads.library.library.repositories;

import com.ads.library.library.models.Borrowing;
import com.ads.library.library.models.StudentBookKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBorrowingRepository extends JpaRepository<Borrowing, StudentBookKey> {

    void deleteByIdIn(List<StudentBookKey> ids);

    @Query(value = "SELECT book.name as book_name, category.name as category_name, COUNT(*) as count FROM borrowing JOIN book ON borrowing.book_id = book.id JOIN category ON book.category_id = category.id GROUP BY book.id LIMIT 6", nativeQuery = true)
    List<Object> countBooksInBorrowings();

}
