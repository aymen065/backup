package com.ads.library.library.dto;

import com.ads.library.library.models.Category;
import com.ads.library.library.models.Publication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private double price;
    private Category category;
    private long isbn;
    private Publication publication;
    private int numOfCopies;
    private int issuedCopies;
    private String description;

}
