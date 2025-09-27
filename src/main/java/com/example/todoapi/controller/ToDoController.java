package com.example.todoapi.controller;
import com.example.todoapi.service.ToDoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.todoapi.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    // GET /todos
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos(){
        return ResponseEntity.ok(toDoService.getAllToDos());
    }

    //GET /todos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id){
        return ResponseEntity.ok(toDoService.getToDoById(id));
    }

    //POST /todos
    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo){
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.createToDo(toDo));
    }

    //PUT /todos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails){
        return ResponseEntity.ok(toDoService.updateToDo(id, toDoDetails));
    }

    //DELETE /todos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}