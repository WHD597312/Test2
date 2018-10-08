package com.peihou.service.impl;

import com.peihou.dao.StudentDao;
import com.peihou.pojo.Student;
import com.peihou.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;
    public Student getStudentName(int id) {
        return studentDao.queryById(id);
    }
}
