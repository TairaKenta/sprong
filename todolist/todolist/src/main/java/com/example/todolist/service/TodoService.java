package com.example.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todolist.entity.Todo;
import com.example.todolist.form.TodoForm;
import com.example.todolist.repository.TodoRepository;

@Service
public class TodoService{
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.selectAllTodos();
    }

    public List<Todo> getAllDones(){
        return todoRepository.selectAllDones();
    }

    public void createTodo(TodoForm todoForm){
        Todo todo = new Todo();
        todo.setTask(todoForm.getTask());
        todo.setMemo(todoForm.getMemo());
        todo.setDeadline(todoForm.getDeadline());
        todo.setImportance(todoForm.getImportance());
        todoRepository.insertTodo(todo);
    }

    public void deleteTodoById(long id){
        todoRepository.deleteTodoById(id);
    }
    
    public void updateTodo(Todo todo, long id) {
        todoRepository.updateTodo(todo, id);
    }

    public void cancelTodo(Todo todo, long id) {
        todoRepository.cancelTodo(todo, id);
    }

    public void completeTodo(Todo todo, long id) {
        todoRepository.completeTodo(todo, id);
    }

    public Todo getTodoById(long id) {
        return todoRepository.getTodoById(id);
    }
}