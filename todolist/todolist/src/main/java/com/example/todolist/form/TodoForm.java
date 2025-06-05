package com.example.todolist.form;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TodoForm {
    //タスク名、期日、重要度、メモ
    private String task;
    private LocalDateTime deadline;
    private long importance;
    private String memo;
}