package com.spring.container.spring.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "TestResponse")
public class TestResponse {
  @Schema()
  private String name;
  @Schema()
  private int id;
}
