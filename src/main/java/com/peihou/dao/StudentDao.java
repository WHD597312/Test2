package com.peihou.dao;

import com.peihou.pojo.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDao {
   Student queryById(int id);
}
