package com.project.flow.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 커스텀 확장자 모델
 * @author joo
 */
@Data
@Entity
@Table(name="custom")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Custom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private Integer idx;

  @Column(name = "name", nullable = false, unique = true)
  private String name;
}
