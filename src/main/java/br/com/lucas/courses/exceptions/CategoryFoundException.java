package br.com.lucas.courses.exceptions;

public class CategoryFoundException extends RuntimeException {
  public CategoryFoundException() {
    super("Categoria já existe");
  }
}
