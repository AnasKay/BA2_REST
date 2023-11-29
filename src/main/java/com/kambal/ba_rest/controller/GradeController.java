package com.kambal.ba_rest.controller;

import com.kambal.ba_rest.models.Grade;
import com.kambal.ba_rest.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {
    @Autowired
    GradeService gradeService;


    @RequestMapping(method= RequestMethod.GET)
    public List<Grade> getGrades() {
        return gradeService.getGrades();
    }

    @RequestMapping(value="/{gradeId}", method=RequestMethod.GET)
    public Optional<Grade> getGrade(@PathVariable(value = "gradeId") Long id) {
        return gradeService.getGrade(id);
    }

    @RequestMapping( method=RequestMethod.POST)
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @RequestMapping(value="/{gradeId}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateGrade(@PathVariable(value = "gradeId") Long id, @RequestBody Grade grade) {
        Grade changedGrade = gradeService.updateGrade(id, grade);
        if (changedGrade.getId() == null){
            return ResponseEntity.status(501).body("not existent Grade specified!!");
        }
        return ResponseEntity.status(200).body("Grade was altered.");
    }

    @RequestMapping(value="/{gradeId}", method=RequestMethod.DELETE)
    public void deleteGrade(@PathVariable(value = "gradeId") Long id) {
        gradeService.deleteGrade(id);
    }

}