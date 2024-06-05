package br.com.lucas.courses.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.courses.entities.CourseEntity;
import br.com.lucas.courses.useCases.CreateCourseUseCase;
import br.com.lucas.courses.useCases.DeleteCourseUseCase;
import br.com.lucas.courses.useCases.ListAllCoursesUseCase;
import br.com.lucas.courses.useCases.UpdateCourseUseCase;


@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private ListAllCoursesUseCase listAllCoursesUseCase;

  @Autowired
  private UpdateCourseUseCase updateCourseUseCase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  public ResponseEntity<Object> get() {
    try {
      var result = this.listAllCoursesUseCase.execute();
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> put(@PathVariable UUID id, @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.updateCourseUseCase.execute(id, courseEntity);
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable UUID id) {
    try {
      this.deleteCourseUseCase.execute(id);
      return ResponseEntity.noContent().build();
    } catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
