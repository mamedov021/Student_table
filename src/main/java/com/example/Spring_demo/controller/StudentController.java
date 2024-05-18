package com.example.Spring_demo.controller;

import com.example.Spring_demo.entitiy.StudentEntity;
import com.example.Spring_demo.repositoty.StudentRepository;
import com.example.Spring_demo.student.Student;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class   StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public StudentEntity createStudent(@RequestBody  StudentEntity studentEntity) {
        StudentEntity studentEntityDb =  studentRepository .save(studentEntity);
        return studentEntityDb;
    }
    @GetMapping
    public  ResponseEntity<List<StudentEntity>> getStudentList(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <StudentEntity> getStudentById(@PathVariable String id) {
       var optionalStudent =  studentRepository.findById(id);
              //  .orElseThrow(() -> new RuntimeException("Student is not found"))
        if(optionalStudent.isPresent()){
            return ResponseEntity.ok(optionalStudent.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new StudentEntity());
    }

    @PutMapping
     public  ResponseEntity<StudentEntity> createOrUpDateStudent(@RequestBody StudentEntity studentEntity){
        return  ResponseEntity.ok(studentRepository.save(studentEntity));
    }
  @PatchMapping("/{id}")
   public ResponseEntity<StudentEntity> updateStudent(@PathVariable String id,@RequestBody StudentEntity studentEntity){
        var studentDb = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User is not found"));
        studentDb.setName(studentEntity.getName());
        studentDb.setSurname(studentEntity.getSurname());
        studentDb.setAge(studentEntity.getAge());
        studentDb.setUpdateAt(studentEntity.getUpdateAt());

        return ResponseEntity.ok(studentRepository.save(studentDb));
  }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id){
        var studentExc = studentRepository.findById(id)
                         .orElseThrow(()->new RuntimeException("User is not found"));
         studentRepository.delete(studentExc);
         return ResponseEntity.ok().build();
    }

}
