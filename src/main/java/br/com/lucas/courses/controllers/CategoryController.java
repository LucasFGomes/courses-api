package br.com.lucas.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.courses.useCases.ListAllCategoriesUseCase;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private ListAllCategoriesUseCase listAllCategoriesUseCase;

  @GetMapping("/")
  public ResponseEntity<Object> get() {
    try {
      var result = this.listAllCategoriesUseCase.execute();
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
