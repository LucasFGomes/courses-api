package br.com.lucas.courses.exceptions;

public class CourseFoundException extends RuntimeException {
  public CourseFoundException() {
    super("Curso já existe");
  }
}
