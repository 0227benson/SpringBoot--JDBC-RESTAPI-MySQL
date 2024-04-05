package com.example.api_jdbc.service;

import com.example.api_jdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentService implements StudentService_interface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        return jdbcTemplate.update("INSERT INTO student (name, age, email, phonenumber) VALUES(?, ?, ?, ?)",new Object[]{student.getName(),student.getAge(),student.getEmail(),student.getPhonenumber()});
    }

    @Override
    public int update(Student student, int id) {
        return jdbcTemplate.update("UPDATE student SET name=?,age=?,eamil=?,phonenumber=? WHERE id=?",new Object[]{student.getName(),student.getAge(),student.getEmail(),student.getPhonenumber(),id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id=?",id);
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public Student getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",new BeanPropertyRowMapper<Student>(Student.class),id);
    }
}
