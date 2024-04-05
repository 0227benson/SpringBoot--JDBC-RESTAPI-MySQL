package com.example.api_jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;

    private String email;

    private String phonenumber;/*定義屬性名稱和資料型態*/
}
