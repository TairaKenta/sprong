package com.example.todolist.repository;

import org.springframework.stereotype.Repository;

import com.example.todolist.entity.Todo;
import com.example.todolist.mapper.TodoMapper;

import java.util.List;

@Repository
public class TodoRepository {
    private final TodoMapper todoMapper;

    public TodoRepository(TodoMapper todoMapper){
        this.todoMapper = todoMapper;
    }

    public List<Todo> selectAllTodos(){
        return todoMapper.selectAllTodos();
    }

    public List<Todo> selectAllDones(){
        return todoMapper.selectAllDones();
    }
    public void deleteTodoById(long id){
        todoMapper.deleteTodoById(id);

    }
    public void insertTodo(Todo todo){
        todoMapper.insertTodo(todo);

    }
    public void updateTodo(Todo todo, long id) {
        todoMapper.updateTodo(todo, id);
    }

    public void cancelTodo(Todo todo,long id) {
        todoMapper.cancelTodo(todo, id);
    }
    public void completeTodo(Todo todo,long id) {
        todoMapper.completeTodo(todo,id);
    }

    public Todo getTodoById(long id) {
        return todoMapper.getTodoById(id);
    }
}
