package com.yhh.rest;

import com.yhh.primary.dao.StudentDao;
import com.yhh.secondary.dao.TeacherDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
@Slf4j
public class ShowController {

    private final StudentDao studentDao;
    private final TeacherDao teacherDao;

    public ShowController(StudentDao studentDao, TeacherDao teacherDao) {
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
    }

    @GetMapping(value = "/muti-data")
    public ResponseEntity queryMutiData() {
        log.info("query muti-data.");

        List result = new ArrayList<>();

        result.addAll(studentDao.findAll());
        result.addAll(teacherDao.findAll());

        log.info("result size is {}.", result.size());

        return ResponseEntity.ok(result);
    }

}
