package com.kambal.ba_rest.service;

import com.kambal.ba_rest.models.Student;
import com.kambal.ba_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long studentId){
        return studentRepository.findById(studentId);
    }

    public void deleteStudent(Long studentId) {
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
    }

    public Student updateStudent(Long studentId, Student student) {
        Student student1 = new Student();

        if(studentRepository.findById(studentId).isPresent()) {
           student1 = studentRepository.findById(studentId).get();

            if (!(student.getFirstName() == null)){
                student1.setFirstName(student.getFirstName());
            }
            if (!(student.getLastName() == null)){
                student1.setLastName(student.getLastName());
            }
            if (!(student.getEmailId() == null)){
                student1.setEmailId(student.getEmailId());
            }

            return studentRepository.save(student1);
        }

        return student1;
    }

}
