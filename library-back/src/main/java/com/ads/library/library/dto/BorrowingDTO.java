package com.ads.library.library.dto;


import com.ads.library.library.models.Book;
import com.ads.library.library.models.Student;
import com.ads.library.library.models.StudentBookKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowingDTO {

    private StudentBookKey id;
    private Date creationDate;
    private Date updateDate;
    private String status;

    public void setId(Student student , Book book) {
        this.id.setBook(book);
        this.id.setStudent(student);
    }
}
