package com.example.todoapi.controller;
import com.example.todoapi.service.ToDoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.todoapi.model.ToDo;


@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    // GET /todos
    @GetMapping
    public List<ToDo> getAllToDos(){
        return toDoService.getAllToDos();
    }

    //GET /todos/{id}
    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id){
        return toDoService.getToDoById(id);
    }

    //POST /todos
    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo){
        return toDoService.createToDo(toDo);
    }

    //PUT /todos/{id}
    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails){
        return toDoService.updateToDo(id, toDoDetails);
    }

    //DELETE /todos/{id}
    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
    }
}