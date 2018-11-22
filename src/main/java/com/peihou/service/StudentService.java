package com.peihou.service;

import com.peihou.dao.StudentDao;
import com.peihou.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentService {
    @Resource
    StudentDao studentDao;


    public boolean insert(Student student) {
        return studentDao.insert(student);
    }


    public boolean delete(int id) {
        return studentDao.deleteById(id);
    }

    public Student getStudentById(int id) {
        return studentDao.queryById(id);
    }


    public Student getStudentByCodes(String codes) {
        return studentDao.queryStudentByCodes(codes);
    }


    public boolean updateById(Student student) {
        if (student!=null){
            return studentDao.updateById(student);
        }
        return false;
    }

    public List<Student> findAllStudent() {
        List<Student> students=null;
        students=studentDao.findAllStudent();
        return students;
    }
}
