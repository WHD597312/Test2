package com.peihou.service.impl;

import com.peihou.dao.StudentDao;
import com.peihou.pojo.Student;
import com.peihou.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;

    @Override
    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public boolean delete(int id) {
        return studentDao.deleteById(id);
    }

    public Student getStudentById(int id) {
        return studentDao.queryById(id);
    }

    @Override
    public Student getStudentByCodes(String codes) {
        return studentDao.queryStudentByCodes(codes);
    }

    @Override
    public boolean updateById(Student student) {
        if (student!=null){
            Student student2=studentDao.queryById(student.getId());
            if (student2!=null){
                student.setCodes(student2.getCodes());
                return studentDao.updateById(student);
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students=null;
        students=studentDao.findAllStudent();
        return students;
    }
}
