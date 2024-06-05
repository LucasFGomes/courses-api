package br.com.lucas.courses.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.courses.dtos.CourseResponseDTO;
import br.com.lucas.courses.repositories.CourseRepository;

@Service
public class ListAllCoursesUseCase {
  
  @Autowired
  private CourseRepository courseRepository;

  public List<CourseResponseDTO> execute() {
    return this.courseRepository.findAll().stream().map(course -> (
      CourseResponseDTO.builder()
                       .id(course.getId())
                       .name(course.getName())
                       .status(course.getStatus())
                       .categoryName(course.getCategory().getName())
                       .build()
    )).collect(Collectors.toList());
  }
}
