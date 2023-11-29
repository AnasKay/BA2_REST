package com.kambal.ba_rest.controller;

import com.kambal.ba_rest.models.Student;
import com.kambal.ba_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    @RequestMapping(method= RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(value="/{studentId}", method=RequestMethod.GET)
    public Optional<Student> getStudent(@PathVariable(value = "studentId") Long id) {
        return studentService.getStudent(id);
    }

    @RequestMapping( method=RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value="/{studentId}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateStudents(@PathVariable(value = "studentId") Long id, @RequestBody Student student) {
        Student changedStudent = studentService.updateStudent(id, student);
        if (changedStudent.getId() == null){
            return ResponseEntity.status(501).body("not existent Student specified!!");
        }
        return ResponseEntity.status(200).body("Student was altered.");
    }

    @RequestMapping(value="/{studentId}", method=RequestMethod.DELETE)
    public void deleteStudents(@PathVariable(value = "studentId") Long id) {
        studentService.deleteStudent(id);
    }

}