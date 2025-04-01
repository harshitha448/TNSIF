package com.placement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.entity.Student;
import com.placement.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    public StudentService sserv;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return sserv.addStudent(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return sserv.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return sserv.deleteStudent(id);
    }

    @GetMapping("/searchStudent/{id}")
    public Student searchStudent(@PathVariable Long id) {
        return sserv.searchStudent(id);
    }
    
    @GetMapping("/getStudent")
    public List<Student> getStudent() {
        return sserv.getStudent();
    }
}