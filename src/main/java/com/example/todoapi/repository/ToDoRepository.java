package com.example.todoapi.repository
import com.example.todoapi.model.ToDo

import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
