package br.com.lucas.courses.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
  Optional<CourseEntity> findByName(String name);
}
