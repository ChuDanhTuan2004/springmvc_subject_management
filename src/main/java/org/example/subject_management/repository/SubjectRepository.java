package org.example.subject_management.repository;

import org.example.subject_management.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByNameContaining(String name);

    List<Subject> findAllByCategoryId(Long id);
}
