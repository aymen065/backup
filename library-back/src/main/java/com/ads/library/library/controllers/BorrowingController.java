package com.ads.library.library.controllers;

import com.ads.library.library.dto.BooksNumberInBorrowing;
import com.ads.library.library.dto.BorrowingDTO;
import com.ads.library.library.models.Book;
import com.ads.library.library.models.StudentBookKey;
import com.ads.library.library.services.IBorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/borrowings")
@AllArgsConstructor
public class BorrowingController {
    private IBorrowingService borrowingService;

    @GetMapping()
    public ResponseEntity<Page<BorrowingDTO>> getAllBorrowings(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "3") int size) {
        try {
            return new ResponseEntity<>(borrowingService.getAllBorrowings(page,size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<BorrowingDTO>> getAllBorrowings() {
        try {
            return new ResponseEntity<>(borrowingService.getAllBorrowings(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/count")
    public ResponseEntity<Long> getBooksNumber() {
        try {
            return new ResponseEntity<>(borrowingService.getIssuedBooksNumber(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDTO> getBorrowingById(@PathVariable("id") StudentBookKey id){
        try {
            return new ResponseEntity<>(borrowingService.getBorrowingById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/count/books")
    public ResponseEntity<Object> countBooksInBorrowings(){
        try {
            return new ResponseEntity<>(borrowingService.countBooksInBorrowings(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<BorrowingDTO> createBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        try {
            return new ResponseEntity<>(borrowingService.createBorrowing(borrowingDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping()
    public ResponseEntity<BorrowingDTO> updateBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        BorrowingDTO borrowing = borrowingService.updateBorrowing(borrowingDTO);
        if (borrowing != null) {
            return new ResponseEntity<>(borrowing, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBorrowingById(@PathVariable("id") StudentBookKey id) {

        try {
            borrowingService.deleteBorrowingById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllBorrowings() {
        try {
            borrowingService.deleteAllBorrowings();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/ids/in")
    @Transactional
    public ResponseEntity<HttpStatus> deleteBorrowings(@RequestBody List<StudentBookKey> borrowingsIds) {
        try {
            borrowingService.deleteBorrowings(borrowingsIds);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
