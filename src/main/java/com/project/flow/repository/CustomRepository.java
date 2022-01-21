package com.project.flow.repository;

import com.project.flow.model.Custom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 커스텀확장자 인터페이스
 * @author joo
 */
public interface CustomRepository extends JpaRepository<Custom, Integer> {
}
