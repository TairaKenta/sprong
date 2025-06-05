package com.example.todolist.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Todo {
    private long id;  //todoのID
    private String memo;  //備考欄
    private String task;  //タスク名
    private long importance;  //重要度
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadline; //締め切り
    private boolean done;  //trueならdonelistにある
}


