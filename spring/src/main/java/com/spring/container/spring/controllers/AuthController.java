package com.spring.container.spring.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.spring.container.spring.dtos.BodyDto;
import com.spring.container.spring.dtos.QueryDto;
import com.spring.container.spring.responses.TestResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "auth") // tag를 달아서 그룹을 정해줄 수 있습니다.
@RestController
@RequestMapping("auth")
public class AuthController {

  @Operation(
    description = "Test api"
  )
  @ApiResponse(
    responseCode = "200",
    content = @Content(
      schema = @Schema(
        /*
         * 프론트엔드가 response를 확인하고 modeling을 할 수 있게 합니다.
         */
        implementation = TestResponse.class
      )
    )
  )
  @PostMapping(
    name = "test",
    produces = MediaType.APPLICATION_JSON_VALUE // json string -> json
  )
  public ResponseEntity<String> test(
    @ParameterObject QueryDto query, // query
    @RequestParam String uuid, // param
    @RequestBody BodyDto body // body
  ) {
    try {
      System.out.println(query.getCount());
      System.out.println(query.getPage());
      System.out.println(uuid);
      return ResponseEntity
        .status(HttpStatus.OK)
        .body("{\"name\" : \""+body.getName()+"\" , \"id\":"+body.getId()+"}");
    } catch(Exception e) {
      System.out.println(e);
      return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(null);
    }
  }
}
