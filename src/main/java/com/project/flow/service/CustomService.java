package com.project.flow.service;

import com.project.flow.model.Custom;
import com.project.flow.model.Fix;
import com.project.flow.repository.CustomRepository;
import com.project.flow.repository.FixRepository;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 커스텀확장자 서비스
 * @author joo
 */

@Service
@AllArgsConstructor
@Log4j2
public class CustomService {
  private final CustomRepository customRepository;
  private final FixRepository fixRepository;

  // 커스텀확장자List 가져오기
  @Transactional
  public List<Custom> findAll() {
    List<Custom> customList = customRepository.findAll();
    return customList;
  }

  // 커스텀확장자 추가
  @Transactional
  public Custom create(Custom custom) {
    List<Custom> customList = customRepository.findAll();
    List<Fix> fixList = fixRepository.findAll();
    // 중복 체크
    for(Custom customs : customList) {
      if(customs.getExtensions().equals(custom.getExtensions())) {
        throw new DuplicateRequestException();
      }
    }
    for(Fix fix : fixList) {
      if(fix.getExtensions().equals(custom.getExtensions())) {
        throw new DuplicateRequestException();
      }
    }
    // 입력 길이 20자리제한
    if(custom.getExtensions().length() > 20) {
      throw new IllegalArgumentException();
    }
    // 개수 체크
    if(customList.size() > 199) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return customRepository.save(custom);
  }

  // 커스텀확장자 삭제
  @Transactional
  public boolean delete(int idx) {
    Optional<Custom> customOptional = customRepository.findById(idx);
    if(customOptional.isPresent()){
      customRepository.delete(customOptional.get());
      return true;
    }
    return false;
  }
}
