package co.com.sofka.crud.services;

import co.com.sofka.crud.moldels.ListTodo;
import co.com.sofka.crud.repositories.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListTodoService {

    @Autowired
   ListTodoRepository listtodorepository;
    public ArrayList<ListTodo> obtenerListTodo(){
        return (ArrayList<ListTodo>) listtodorepository.findAll();
    }

    public Iterable<ListTodo> list(){
       return listtodorepository.findAll();
    }

    public ListTodo save(ListTodo listTodo){
        return listtodorepository.save(listTodo);
    }

    public void delete(Long id){
        listtodorepository.delete(get(id));
    }

    public ListTodo get(Long id){
         return listtodorepository.findById(id).orElseThrow();
    }

}
