package org.example.subject_management.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void deleteById(Long id);

    Iterable<T> findByName(String name);
}
