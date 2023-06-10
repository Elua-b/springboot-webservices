package com.springrestApi.demo.controller;


import com.springrestApi.demo.model.Student;
import com.springrestApi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping(path = "/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @GetMapping(path = "y2/b")
    public String getStudent(){
        return  "hello student";
    }
    @GetMapping(path = "/student/{studId}")

    public Optional<Student> getStudent(@PathVariable("studId") Integer  studId){
        return  studentRepository.findById(studId);
    }
    @GetMapping(path="/student/age/{age}")

 public List<Student> getStudentByAge(@PathVariable("age") Integer age){
    return  studentRepository.findByAge(age);
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody  Student S){

        studentRepository.save(S);
        return S;
    }
    @PutMapping(path = "/student/update/{studId}")
    public Student updateStudent(@PathVariable("studId") Integer studId, @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(studId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            student.setLastName(updatedStudent.getLastName());
            student.setFirstName(updatedStudent.getFirstName());

            student.setAge(updatedStudent.getAge());
            // Set any other properties you want to update

            studentRepository.save(student);
            return student;
        } else {
            // Handle the case where the student is not found
            throw new RuntimeException("Student not found with ID: " + studId);
        }
    }

    @DeleteMapping("/student/delete/{studId}")
    public String deleteStudent(@PathVariable("studId") Integer studId) {
        Optional<Student> optionalStudent = studentRepository.findById(studId);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return "Student with ID: " + studId + " deleted successfully.";
        } else {
            throw new RuntimeException("Student not found with ID: " + studId);
        }
    }
}
