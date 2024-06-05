package br.com.lucas.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.courses.entities.CourseEntity;
import br.com.lucas.courses.exceptions.CourseNotFoundException;
import br.com.lucas.courses.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {
  
  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    Optional<CourseEntity> course = this.courseRepository.findById(id);

    if (!course.isPresent()) {
      throw new CourseNotFoundException();
    }

    this.courseRepository.deleteById(id);
  }

}
