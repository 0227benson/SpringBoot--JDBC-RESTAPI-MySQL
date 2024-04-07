package com.example.api_jdbc.service;

import com.example.api_jdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//標記這個類別為資料存取層
public class StudentService implements StudentService_interface{//需要實現interface中定義的所有方法

    @Autowired
    JdbcTemplate jdbcTemplate;//將JdbcTemplate物件注入到 StudentService中

    @Override
    public int add(Student student) {
        return jdbcTemplate.update("INSERT INTO student (name, age, email, phonenumber) VALUES(?, ?, ?, ?)",new Object[]{student.getName(),student.getAge(),student.getEmail(),student.getPhonenumber()});
    }//新增資料到資料庫中

    @Override
    public int update(Student student, int id) {
        return jdbcTemplate.update("UPDATE student SET name=?,age=?,email=?,phonenumber=? WHERE id=?",new Object[]{student.getName(),student.getAge(),student.getEmail(),student.getPhonenumber(),id});
    }//更新資料庫中已有的資料

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id=?",id);
    }//刪除資料庫中的資料

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<Student>(Student.class));
    }//獲取資料庫中所有的資料,並使用BeanPropertyRowMapper將結果映射到Student列表。

    @Override
    public List<Student> getById(int id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE id=?",new BeanPropertyRowMapper<Student>(Student.class),id);
    }//根據提供的id獲取特定的資料,並使用BeanPropertyRowMapper將結果映射到Student列表。
}
