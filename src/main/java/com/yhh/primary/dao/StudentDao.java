package com.yhh.primary.dao;

import com.yhh.primary.entity.StudentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentDO, Integer> {
}
