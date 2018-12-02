package com.yhh.dao;

import com.yhh.primary.dao.StudentDao;
import com.yhh.primary.entity.StudentDO;
import com.yhh.secondary.dao.TeacherDao;
import com.yhh.secondary.entity.TeacherDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class MutiDaoIT {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void muti_dao_IT() {
        List<TeacherDO> teacherDOList = teacherDao.findAll();

        List<StudentDO> studentDOList = studentDao.findAll();

        Assert.assertFalse(teacherDOList.isEmpty());
        Assert.assertFalse(studentDOList.isEmpty());
    }
}