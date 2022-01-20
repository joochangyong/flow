package com.project.flow.repository;

import com.project.flow.model.Custom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Custom, Integer> {
}
