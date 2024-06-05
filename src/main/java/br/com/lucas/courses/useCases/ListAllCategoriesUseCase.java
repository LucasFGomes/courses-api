package br.com.lucas.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.courses.entities.CategoryEntity;
import br.com.lucas.courses.repositories.CategoryRepository;

@Service
public class ListAllCategoriesUseCase {
  
  @Autowired
  private CategoryRepository categoryRepository;

  public List<CategoryEntity> execute() {
    return this.categoryRepository.findAll();
  }

}
