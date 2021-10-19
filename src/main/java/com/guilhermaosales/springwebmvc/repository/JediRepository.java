package com.guilhermaosales.springwebmvc.repository;

import com.guilhermaosales.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {
        List<Jedi> findByNameContainingIgnoreCase(final String name);
}