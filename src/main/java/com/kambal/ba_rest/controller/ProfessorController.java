package com.kambal.ba_rest.controller;

import com.kambal.ba_rest.models.Grade;
import com.kambal.ba_rest.models.Professor;
import com.kambal.ba_rest.service.GradeService;
import com.kambal.ba_rest.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/professors")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;


    @RequestMapping(method= RequestMethod.GET)
    public List<Professor> getProfessors() {
        return professorService.getProfessor();
    }

    @RequestMapping(value="/{professorId}", method=RequestMethod.GET)
    public Optional<Professor> getProfessor(@PathVariable(value = "professorId") Long id) {
        return professorService.getProfessor(id);
    }

    @RequestMapping( method=RequestMethod.POST)
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @RequestMapping(value="/{professorId}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateProfessor(@PathVariable(value = "professorId") Long id, @RequestBody Professor professor) {
        Professor changedProf = professorService.updateProfessor(id, professor);
        if (changedProf.getId() == null){
            return ResponseEntity.status(501).body("not existent Grade specified!!");
        }
        return ResponseEntity.status(200).body("Grade was altered.");
    }

    @RequestMapping(value="/{professorId}", method=RequestMethod.DELETE)
    public void deleteProfessor(@PathVariable(value = "professorId") Long id) {
        professorService.deleteProfessor(id);
    }

}