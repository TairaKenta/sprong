package com.example.todolist.controller;

import com.example.todolist.service.TodoService;
import com.example.todolist.form.TodoForm;
import com.example.todolist.entity.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public String todos(Model model){
        List<Todo> Todos = todoService.getAllTodos();
        model.addAttribute("todoList", Todos);
        return "Todo/todo";
    }

    @GetMapping("/new")
    public String todoForm(Model model){
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoForm",todoForm);
        return "Todo/form";
    }

    @PostMapping("/new")
    public String createTodo(TodoForm todoForm){
        todoService.createTodo(todoForm);

        return "redirect:/todo";
    }

    //
    @PostMapping("/{todoId}/complete")
    public String completeTodo(Todo todo, @PathVariable long todoId){
        todoService.completeTodo(todo, todoId);
        return "redirect:/todo";
    }

    //編集したいtodoをform.htmlに送る
    @GetMapping("/{todoId}/edit")
    public String editTodo(@PathVariable long todoId, Model model){
        Todo todo = todoService.getTodoById(todoId);
        model.addAttribute("todo",todo);

        return "Todo/edit";
    }

    //編集されたtodoをデータベースに挿入する
    @PostMapping("/{todoId}/edit")
    public String updateTodo(Todo todo, @PathVariable long todoId){ 
        todoService.updateTodo(todo, todoId);
        return "redirect:/todo";
    }

    //donelist画面
    @GetMapping("/done")
    public String dones(Model model){
        List<Todo> Todos = todoService.getAllDones();
        model.addAttribute("todoList", Todos);
        return "Todo/done";
    }

    //doneからtodoに戻す
    @PostMapping("/{todoId}/cancel")
    public String cancel(Todo todo, @PathVariable long todoId){
        todoService.cancelTodo(todo, todoId);
        return "redirect:/todo";
    }

    //todoをデータベースから消す
    @PostMapping("/{todoId}/delete")  
    public String delete(@PathVariable long todoId){
        Todo todo = todoService.getTodoById(todoId);
        todoService.deleteTodoById(todoId);

        if (todo.isDone()) return "redirect:/todo/done";
        else return "redirect:/todo";
    }
}
