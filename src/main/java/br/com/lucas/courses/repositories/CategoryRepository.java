package br.com.lucas.courses.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.courses.entities.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
  Optional<CategoryEntity> findByName(String name);
}
