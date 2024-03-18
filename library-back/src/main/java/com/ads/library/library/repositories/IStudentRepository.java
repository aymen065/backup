package com.ads.library.library.repositories;

import com.ads.library.library.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    void deleteByIdIn(List<Long> ids);
}
