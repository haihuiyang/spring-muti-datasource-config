package com.yhh.secondary.dao;

import com.yhh.secondary.entity.TeacherDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<TeacherDO, Integer> {
}
