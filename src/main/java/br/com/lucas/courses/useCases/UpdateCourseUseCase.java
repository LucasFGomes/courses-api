package br.com.lucas.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.courses.entities.CourseEntity;
import br.com.lucas.courses.exceptions.CourseNotFoundException;
import br.com.lucas.courses.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;
  
  public CourseEntity execute(UUID id, CourseEntity courseUpdated) {
    Optional<CourseEntity> currentCourseOptional = this.courseRepository.findById(id);

    if (!currentCourseOptional.isPresent()) {
      throw new CourseNotFoundException();
    } 
    
    var currentCourse = currentCourseOptional.get();
    BeanUtils.copyProperties(courseUpdated, currentCourse, "id", "createdAt");
    return this.courseRepository.save(currentCourse);
  }

}
