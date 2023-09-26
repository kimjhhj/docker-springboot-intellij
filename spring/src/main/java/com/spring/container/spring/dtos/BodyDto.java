package com.spring.container.spring.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "BodyDto")
public class BodyDto {
  @Schema(defaultValue = "name",description = "name")
  private String name;
  
  @Schema(defaultValue = "1",description = "id")
  private int id;
}
