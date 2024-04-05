package com.example.api_jdbc.service;

import com.example.api_jdbc.model.Student;

import java.util.List;

public interface StudentService_interface {

    int add(Student student);

    int update(Student student,int id);

    int delete(int id);

    List<Student> getAll();

    Student getById(int id);
}
