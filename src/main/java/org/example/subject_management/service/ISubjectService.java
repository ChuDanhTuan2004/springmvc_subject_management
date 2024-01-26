package org.example.subject_management.service;

import org.example.subject_management.model.Subject;

import java.util.List;

public interface ISubjectService extends IGeneralService<Subject> {
    List<Subject> findAllByCategoryId(Long id);
}
