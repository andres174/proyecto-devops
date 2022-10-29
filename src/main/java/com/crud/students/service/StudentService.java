package com.crud.students.service;

import com.crud.students.model.Student;
import com.crud.students.repositories.iStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private iStudentRepository iStudentRepository;

    public Student saveStudent (Student student){
        return iStudentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return iStudentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    public void deleteStudent(Long id){
        iStudentRepository.deleteById(id);
    }

    public Student editStudent (Student student){
        if (student.getId() != null && iStudentRepository.existsById(student.getId())){
            return iStudentRepository.save(student);
        }
        return null;
    }

    public boolean existById(Long id) {
        return iStudentRepository.existsById(id);

    }
}




