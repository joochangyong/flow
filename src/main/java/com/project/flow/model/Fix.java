package com.project.flow.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 고정확장자 모델
 * @author joo
 */
@Data
@Entity
@Table(name="fix")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fix {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private int idx;

  @Column(name = "extensions", nullable = false, unique = true)
  private String extensions;

  @Column(name = "state", nullable = false)
  private int state;
}
