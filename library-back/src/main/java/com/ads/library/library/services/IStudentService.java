package com.ads.library.library.services;

import com.ads.library.library.dto.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {

    Page<StudentDTO> getAllStudents(Integer page, Integer size);
    StudentDTO getStudentById(Long id);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);

    Long getStudentsNumber();

    void deleteStudentById(Long id);
    void deleteAllStudents();

    void deleteStudents(List<Long> booksIds);
}
