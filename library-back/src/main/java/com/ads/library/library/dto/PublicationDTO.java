package com.ads.library.library.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationDTO {
    private Long id;
    private String name;
    private Date creationDate;

    private Date updateDate;
}
