package com.yhh.primary.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "student")
public class StudentDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private Integer age;
}
