package br.com.lucas.courses.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
  active("ativo"), 
  disabled("desativado");

  private String description;

  StatusEnum(String description) {
    this.description = description;
  }
}