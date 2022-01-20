package com.project.flow.service;

import com.project.flow.model.Fix;
import com.project.flow.repository.FixRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 고정확장자 서비스
 * @author joo
 */

@Service
@AllArgsConstructor
@Log4j2
public class FixService {
  private final FixRepository fixRepository;

  // 고정확장자List 가져오기
  @Transactional
  public List<Fix> findAll() {
    List<Fix> fixList = fixRepository.findAll();
    if(fixList.isEmpty()) {
      throw new NullPointerException("데이터 없음");
    }
    return fixList;
  }

  // 고정확장자 state값 변경
  @Transactional
  public Boolean update(int idx) {
    Optional<Fix> fixOptional = fixRepository.findById(idx);
    Fix fix = fixOptional.get();
    if(fix.getState() == 0) {
      fix.setState(1);
    } else {
      fix.setState(0);
    }
    fixRepository.save(fix);
    return true;
  }
}
