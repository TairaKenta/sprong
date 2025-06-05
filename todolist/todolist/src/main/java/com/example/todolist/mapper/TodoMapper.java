package com.example.todolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.todolist.entity.Todo;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todolist WHERE done = false ORDER BY deadline ASC, importance DESC")
    List<Todo> selectAllTodos();
    
    @Select("SELECT * FROM todolist WHERE done = true ORDER BY deadline ASC, importance DESC")
    List<Todo> selectAllDones();

    @Delete("DELETE FROM todolist WHERE id = #{id}")
    void deleteTodoById(long id);

    @Insert("INSERT INTO todolist (task,memo,deadline,importance) VALUES (#{task},#{memo},#{deadline},#{importance})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTodo(Todo todo);

    //編集
    @Update("UPDATE todolist SET task = #{todo.task}, memo = #{todo.memo}, deadline = #{todo.deadline}, importance = #{todo.importance} WHERE id = #{id}")
    void updateTodo(Todo todo, long id);

    @Update("UPDATE todolist SET done = false WHERE id = #{id}")
    void cancelTodo(Todo todo, long id);

    @Update("UPDATE todolist SET done = true WHERE id = #{id}")
    void completeTodo(Todo todo, long id);

    @Select("SELECT * FROM todolist WHERE id = #{todoId}")
    Todo getTodoById(long id);
}
