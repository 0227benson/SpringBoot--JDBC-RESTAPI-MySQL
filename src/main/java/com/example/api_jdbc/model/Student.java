package com.example.api_jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//會自動生成 toString、equals、hashCode、getter、setter 方法
@AllArgsConstructor//會生成一個包含所有屬性的constructor
@NoArgsConstructor//會生成一個空的constructor
public class Student {
    private int id;
    private String name;
    private int age;

    private String email;

    private String phonenumber;//定義屬性名稱和資料型態
}
