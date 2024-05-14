package com.example.Spring_demo.controller;

import com.example.Spring_demo.student.Student;
import com.sun.net.httpserver.Authenticator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/db")
    public String getStudentDataFromDb(){
        StudentDbService studentDbService = new StudentDbService();
        try {
            return studentDbService.getStudent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/name/{studentId}")
    public String getStudentName(@RequestParam String id ){
          if (id.equals("1")){
              return "Samir";
          }else if(id.equals("2")){
              return "LAmiye";
          }
          else
              return "NOT DATA F";

    }
    @PostMapping("/age")
    public String saveData(@RequestBody Student student) {

        System.out.println( student.getAge());
        return "Succses";
    }
    @PutMapping("/update/student")
    public void updateStudent(@RequestBody Student student){
        System.out.println("ST name : " + student.getName());
        System.out.println("ST age : " + student.getAge());

        System.out.println("Student name is changed");

    }
    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable String id){
        System.out.println("Student is deleted");
    }

}
