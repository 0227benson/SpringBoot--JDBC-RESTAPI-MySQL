package com.example.api_jdbc.controller;

import com.example.api_jdbc.model.Student;
import com.example.api_jdbc.response.Common_Response;
import com.example.api_jdbc.service.StudentService_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService_interface eDAO;

    @GetMapping("/getallstudents")
    public Common_Response getallStudents() {
        List<Student> students = eDAO.getAll();
        if (students != null && !students.isEmpty()) {
            return new Common_Response(200, "success",students);
        } else {
            return Common_Response.FAIL(); // 回傳失敗訊息
        }
    }//獲取所有資料庫資料，判斷是否執行成功

    @GetMapping("/getstudent/{id}")
    public Common_Response getStudentById(@PathVariable int id) {
        List<Student> student = eDAO.getById(id);
        if (!student.isEmpty()) {
            return new Common_Response(200, "success", student);
        } else {
            return Common_Response.FAIL(); // 回傳失敗訊息
        }
    }//獲取指定id資料，判斷是否執行成功

    @PostMapping("/addstudent")
    public Common_Response addStudent(@RequestBody Student student){
        int result = eDAO.add(student);
        if (result == 1) {
            return Common_Response.SUCCESS(); // 回傳成功訊息
        } else {
            return Common_Response.FAIL(); // 回傳失敗訊息
        }
    }//新增資料到資料庫，判斷是否執行成功

    @PutMapping("/updatestudent/{id}")
    public Common_Response updateStudent(@RequestBody Student student, @PathVariable int id) {
        int result = eDAO.update(student, id);
        if (result == 1) {
            return Common_Response.SUCCESS(); // 回傳成功訊息
        } else {
            return Common_Response.FAIL(); // 回傳失敗訊息
        }
    }//對資料庫指定資料進行更新，判斷是否執行成功

    @DeleteMapping("/deletestudent/{id}")
    public Common_Response deleteStudentById(@PathVariable int id) {
        int result = eDAO.delete(id);
        if (result == 1) {
            return Common_Response.SUCCESS(); // 回傳成功訊息
        } else {
            return Common_Response.FAIL(); // 回傳失敗訊息
        }
    }//刪除資料庫中指定資料，判斷是否執行成功
}