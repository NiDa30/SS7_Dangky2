package com.example.dangky.controller;

import com.example.dangky.dto.CandidateCreateDTO;
import com.example.dangky.model.Candidate;
import com.example.dangky.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    // Constructor injection
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public ResponseEntity<Candidate> registerCandidate(@Valid @RequestBody CandidateCreateDTO dto) {
        // Map DTO to Entity
        Candidate candidate = new Candidate();
        candidate.setFullName(dto.getFullName());
        candidate.setEmail(dto.getEmail());
        candidate.setAge(dto.getAge());
        candidate.setYearsOfExperience(dto.getYearsOfExperience());

        // Save candidate in database
        Candidate savedCandidate = candidateRepository.save(candidate);

        // Return saved entity with 201 Created status
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }
}
