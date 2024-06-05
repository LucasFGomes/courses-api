package br.com.lucas.courses.dtos;

import java.util.UUID;

import br.com.lucas.courses.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
  private UUID id;
  private String name;
  private StatusEnum status;
  private String categoryName;
}
