package com.crud.students.repositories;

import com.crud.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iStudentRepository extends JpaRepository<Student, Long> {


}
