package com.example.api_jdbc.response;

import com.example.api_jdbc.model.Student;

import java.util.List;

public class Common_Response {
    private  String rsp_msg;
    private  int rsp_code;
    private List<Student> students;

    public Common_Response(int rsp_code, String rsp_msg, List<Student> students) {
        this.rsp_code = rsp_code;
        this.rsp_msg = rsp_msg;
        this.students = students;
    }

    public String getRsp_msg() {
        return rsp_msg;
    }

    public void setRsp_msg(String rsp_msg) {
        this.rsp_msg = rsp_msg;
    }

    public int getRsp_code() {
        return rsp_code;
    }

    public void setRsp_code(int rsp_code) {
        this.rsp_code = rsp_code;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // 建立成功回應
    public static Common_Response SUCCESS() {
        return new Common_Response(200, "success",null);
    }


    // 建立失敗回應
    public static Common_Response FAIL() {
        return new Common_Response(404, "Something happened", null);
    }

    // 建立參數錯誤回應
    public static Common_Response BAD_PARAM() {
        return new Common_Response(500, "Parameter error",null);
    }
}
