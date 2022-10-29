package com.crud.students.controller;

import com.crud.students.model.Student;
import com.crud.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> saveStudent (/*@Valid*/ @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent (){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable ("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok(!studentService.existById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Student> editStudent (/*@Valid*/ @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(student));
    }


}
