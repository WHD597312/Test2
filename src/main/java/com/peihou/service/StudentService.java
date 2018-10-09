package com.peihou.service;

import com.peihou.pojo.Student;

import java.util.List;

public interface StudentService {
    boolean insert(Student student);
    boolean delete(int id);
    Student getStudentById(int id);
    Student getStudentByCodes(String codes);
    boolean updateById(Student student);
    List<Student> findAllStudent();
}
