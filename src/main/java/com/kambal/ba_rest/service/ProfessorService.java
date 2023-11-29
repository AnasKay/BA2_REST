package com.kambal.ba_rest.service;

import com.kambal.ba_rest.models.Grade;
import com.kambal.ba_rest.models.Professor;
import com.kambal.ba_rest.repository.GradeRepository;
import com.kambal.ba_rest.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> getProfessor() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessor(Long professorId){
        return professorRepository.findById(professorId);
    }

    public void deleteProfessor(Long professorId) {
        if(professorRepository.existsById(professorId)){
            professorRepository.deleteById(professorId);
        }
    }

    public Professor updateProfessor(Long professorId, Professor professor) {
        Professor professor1 = new Professor();

        if(professorRepository.findById(professorId).isPresent()) {
            professor1 = professorRepository.findById(professorId).get();

            if (!(professor.getFirstName() == null)){
                professor1.setFirstName(professor.getFirstName());
            }
            if (!(professor.getLastName() == null)){
                professor1.setLastName(professor.getLastName());
            }
            if (!(professor.getEmailId() == null)){
                professor1.setEmailId(professor.getEmailId());
            }

            return professorRepository.save(professor1);
        }

        return professor1;
    }

}
