package com.ads.library.library.services.impl;

import com.ads.library.library.dto.StudentDTO;
import com.ads.library.library.models.Student;
import com.ads.library.library.repositories.IStudentRepository;
import com.ads.library.library.services.IStudentService;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private IStudentRepository studentRepository;
    private Mapper mapper;
    @Override
    public Page<StudentDTO> getAllStudents(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return studentRepository.findAll(paging).map(student -> mapper.map(student, StudentDTO.class));
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return mapper.map(studentRepository.findById(id).orElse(null), StudentDTO.class);    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return mapper.map(studentRepository.save(mapper.map(studentDTO, Student.class)), StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return mapper.map(studentRepository.save(mapper.map(studentDTO, Student.class)), StudentDTO.class);
    }

    @Override
    public Long getStudentsNumber() {
        return studentRepository.count();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();

    }

    @Override
    public void deleteStudents(List<Long> booksIds) {

        studentRepository.deleteByIdIn(booksIds);
    }


}
