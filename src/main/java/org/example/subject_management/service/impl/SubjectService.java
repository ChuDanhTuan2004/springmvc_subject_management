package org.example.subject_management.service.impl;

import org.example.subject_management.model.Subject;
import org.example.subject_management.repository.SubjectRepository;
import org.example.subject_management.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Iterable<Subject> findByName(String name) {
        return subjectRepository.findAllByNameContaining(name);
    }
}
