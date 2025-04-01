package com.placement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.placement.entity.Student;
import com.placement.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    public StudentRepository srepo;

    public Student addStudent(Student student) {
        return srepo.save(student);
    }

    public List<Student> getStudent() {
        return srepo.findAll();
    }

    public Student updateStudent(Student student) {
        long studentId = student.getId();
        Student s1 = srepo.findById(studentId).get();
        s1.setStudentName(student.getStudentName());
        s1.setRoll(student.getRoll());
        s1.setQualification(student.getQualification());
        s1.setCourse(student.getCourse());
        s1.setYear(student.getYear());
        s1.setHallTicketNo(student.getHallTicketNo());
        return srepo.save(student);
    }

    public boolean deleteStudent(long id) {
        if (srepo.existsById(id)) {
            srepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Student searchStudent(long id) {
        return srepo.findById(id).orElse(null);
    }
}