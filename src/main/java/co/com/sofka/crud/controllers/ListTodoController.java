package co.com.sofka.crud.controllers;

import co.com.sofka.crud.moldels.ListTodo;
import co.com.sofka.crud.services.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/list")

public class ListTodoController {
    @Autowired
        ListTodoService listtodoservice;

    @GetMapping()
    public ArrayList<ListTodo> obtenerListTodo() {
        return listtodoservice.obtenerListTodo();
    }

        @GetMapping(value = "listtodos")
        public Iterable<ListTodo> list(){
            return listtodoservice.list();
        }

        @PostMapping(value = "listtodo")
        public ListTodo save(@RequestBody ListTodo listTodo){
            return listtodoservice.save(listTodo);
        }

        @PutMapping(value = "listtodo")
        public ListTodo update(@RequestBody ListTodo listTodo){
            if(listTodo.getId() != null){
                return listtodoservice.save(listTodo);
            }
            throw new RuntimeException("No existe el id para actualziar");
        }

        @DeleteMapping(value = "{id}")
        public void delete(@PathVariable("id")Long id){
            listtodoservice.delete(id);
        }

        @GetMapping(value = "api/{id}/todo")
        public ListTodo get(@PathVariable("id") Long id){
            return listtodoservice.get(id);
        }

    }
