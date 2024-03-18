package com.ads.library.library.models;


import com.ads.library.auth.models.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {


}
