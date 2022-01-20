package com.project.flow.controller;

import com.project.flow.service.FixService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 고정확장자 컨트롤러
 * @author joo
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/fix")
@Log4j2
public class FixController {
  private final FixService fixService;

  @ApiOperation(value = "고정확장자List 가져오기")
  @GetMapping()
  public ResponseEntity<Object> findAll() {
    try {
      return new ResponseEntity<Object>(fixService.findAll(), HttpStatus.OK);
    } catch (NullPointerException e) {
      log.error("데이터 없음");
      return new ResponseEntity<Object>("데이터 없음", HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      log.error(e);
      return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ApiOperation(value = "고정확장자 state값 변경")
  @PutMapping()
  public ResponseEntity<Object> update(@RequestParam(value = "idx") int idx) {
    try {
      return new ResponseEntity<Object>(fixService.update(idx), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e);
      return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
