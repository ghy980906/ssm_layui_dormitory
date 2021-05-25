package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Student;
import com.mecol.dormitory.entity.StudentSearch;
import com.mecol.dormitory.util.ResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudentList(StudentSearch search);

    Student selStudentByStudentname(String username);

    void insertStudent(Student student);

    void deleteStudentById(int id);

    Student getStudentById(int id);

    void updateStudent(Student student);

    List<Student> getStudentByClassId(Integer classId);

    List<Student> getStudentByDormitoryId(Integer dormitoryId);

    List<Student> getAllStudent();

    Student getStudentBySIdAndDId(@Param("studentId") Integer studentId,
                                  @Param("dormitoryId")Integer dormitoryId);

    Student login(@Param("username") String username, @Param("password") String password);

    Student getStudentByUsername(String username);
}
