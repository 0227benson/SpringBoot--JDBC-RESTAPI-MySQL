package com.example.api_jdbc.controller;

import com.example.api_jdbc.model.Student;
import com.example.api_jdbc.service.StudentService_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService_interface eDAO;

    @GetMapping("/getallstudents")
    public List<Student> getallStudents() {
        return eDAO.getAll();
    }//獲取所有資料庫資料

    @GetMapping("/getstudent/{id}")
    public Student getStudentById(@PathVariable int id) {
        return  eDAO.getById(id);
    }//獲取指定id資料

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student student){
        return eDAO.add(student)+"Add success";
    }//新增資料到資料庫

    @PutMapping("/updatestudent/{id}")
    public String updatestudent(@RequestBody Student student,@PathVariable int id) {
        return  eDAO.update(student,id)+"Update success";
    }//對資料庫指定資料進行更新

    @DeleteMapping("/deletestudent/{id}")
    public String deletestudentById(@PathVariable int id) {
        return eDAO.delete(id)+"Delete success";
    }//刪除資料庫中指定資料
}