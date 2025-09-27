package com.example.todoapi.service;
import com.example.todoapi.model.ToDo;
import com.example.todoapi.repository.ToDoRepository;
import com.example.todoapi.exception.ToDoNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(Long id){
        return toDoRepository.findById(id)
                .orElseThrow(() -> new ToDoNotFoundException("ToDo not found with id " + id));
    }

    public ToDo createToDo(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDo(Long id, ToDo toDoDetails){
        ToDo searchedToDo = getToDoById(id);
        searchedToDo.setTitle(toDoDetails.getTitle());
        searchedToDo.setDescription(toDoDetails.getDescription());
        searchedToDo.setDone(toDoDetails.isDone());
        return toDoRepository.save(searchedToDo);
    }

    public void deleteToDo(Long id){
        toDoRepository.deleteById(id);
    }

}