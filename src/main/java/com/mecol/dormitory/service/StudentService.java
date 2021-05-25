package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Menu;
import com.mecol.dormitory.entity.Student;
import com.mecol.dormitory.entity.StudentSearch;
import com.mecol.dormitory.util.ResultUtil;

import java.util.List;

public interface StudentService {
    ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search);

    Student selStudentByStudentname(String username);

    void insertStudent(Student student);

    ResultUtil deleteStudentById(int id);

    Student getStudentById(int id);

    ResultUtil updateStudent(Student student);

    Student login(String username, String encrypt);

    List<Menu> getMenus(Student student1);

    Student getStudentByUsername(String username);
}
