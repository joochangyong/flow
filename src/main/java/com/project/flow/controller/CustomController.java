package com.project.flow.controller;

import com.project.flow.model.Custom;
import com.project.flow.service.CustomService;
import com.sun.jdi.request.DuplicateRequestException;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 커스텀확장자 컨트롤러
 * @author joo
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/custom")
@Log4j2
public class CustomController {
  private final CustomService customService;

  @ApiOperation(value = "커스텀확장자List 가져오기")
  @GetMapping()
  public ResponseEntity<Object> findAll() {
    try {
      return new ResponseEntity<Object>(customService.findAll(), HttpStatus.OK);
    } catch (NullPointerException e) {
      log.error("데이터 없음");
      return new ResponseEntity<Object>("데이터 없음", HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      log.error(e);
      return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ApiOperation(value = "커스텀확장자 추가")
  @PostMapping()
  public ResponseEntity<Object> create(@RequestBody Custom custom) {
    try {
      return new ResponseEntity<Object>(customService.create(custom), HttpStatus.CREATED);
    } catch (DuplicateRequestException e) {
      log.error("중복된 확장자");
      return new ResponseEntity<Object>("중복된 확장자", HttpStatus.CONFLICT);
    } catch (IllegalArgumentException e) {
      log.error("입력 길이 20자리 초과");
      return new ResponseEntity<Object>("입력 길이 20자리 초과", HttpStatus.CONFLICT);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      log.error("200개 초과");
      return new ResponseEntity<Object>("200개 초과", HttpStatus.CONFLICT);
    } catch (Exception e) {
      log.error(e);
      return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ApiOperation(value = "커스텀확장자 삭제")
  @DeleteMapping
  public ResponseEntity<Object> delete(@RequestParam("idx") int idx) {
    try {
      return new ResponseEntity<Object>(customService.delete(idx), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e);
      return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
