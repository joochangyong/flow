package com.project.flow.repository;

import com.project.flow.model.Fix;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 고정확장자 인터페이스
 * @author joo
 */
public interface FixRepository extends JpaRepository<Fix, Integer> {
}
