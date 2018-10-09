package com.peihou.dao;

import com.peihou.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao {
   boolean insert(Student student);
   boolean deleteById(int id);
   Student queryStudentByCodes(String codes);
   Student queryById(int id);
   boolean updateById(Student student);
   List<Student> findAllStudent();
}
