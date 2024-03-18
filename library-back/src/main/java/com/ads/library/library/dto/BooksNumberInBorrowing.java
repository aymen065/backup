package com.ads.library.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksNumberInBorrowing {

    private String bookName ;
    private String categoryName;
    private Long count;

}
