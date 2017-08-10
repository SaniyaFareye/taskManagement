package com.example.day1test.Controllers;

import com.example.day1test.DTO.Status;
import com.example.day1test.DTO.TaskDTO;
import com.example.day1test.Domains.Employee;
import com.example.day1test.Domains.Project;
import com.example.day1test.Domains.Task;
import com.example.day1test.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xplode on 10/8/17.
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    TaskService taskService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody TaskDTO taskDTO){
        Task task1=new Task();

        if(taskDTO==null){
            return new ResponseEntity(new Status("Empty data"),HttpStatus.NOT_ACCEPTABLE);
        }

       try {
            task1= taskService.addTask(taskDTO);
       }
       catch (Exception e){
        return  new ResponseEntity(new Status("Task Description should be unique"),HttpStatus.CONFLICT);
       }

       if(task1==null){
           return new ResponseEntity(new Status("Fill all the enteries"),HttpStatus.NOT_ACCEPTABLE);
       }

       return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/getTaskData",method = RequestMethod.GET)
    public ResponseEntity getTaskData(@Param("projectId")Long projectId) {
        if(projectId==null){
            return new ResponseEntity(new Status("Null Id"),HttpStatus.NOT_ACCEPTABLE);
        }

        if(projectId==0){
            HashMap<String,List<TaskDTO>> taskList=taskService.getAllData();
            if(taskList==null){
                return new ResponseEntity(new Status("nohjjjjjjjjjjjjjjj"),HttpStatus.NO_CONTENT);
            }
            else
                return new ResponseEntity(taskList,HttpStatus.OK);
        }

        HashMap<String,List<TaskDTO>> task=taskService.getSelectedData(projectId);
        if(task==null){
            return new ResponseEntity(new Status("no data found"),HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity(task,HttpStatus.OK);

    }

}

