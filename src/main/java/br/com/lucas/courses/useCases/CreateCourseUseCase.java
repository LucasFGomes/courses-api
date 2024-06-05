package br.com.lucas.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.courses.entities.CourseEntity;
import br.com.lucas.courses.exceptions.CourseFoundException;
import br.com.lucas.courses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    this.courseRepository.findByName(courseEntity.getName())
                          .ifPresent((course) -> {
                            throw new CourseFoundException();
                          });

    return this.courseRepository.save(courseEntity);
  }

}
