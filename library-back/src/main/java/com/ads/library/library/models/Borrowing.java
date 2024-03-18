package com.ads.library.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "borrowing")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowing {

    @EmbeddedId
    private StudentBookKey id;

    @Column(name="creation_date")
    @CreationTimestamp
    private Date creationDate;

    @Column(name="update_date")
    @UpdateTimestamp
    private Date updateDate;

    private String status;
}
