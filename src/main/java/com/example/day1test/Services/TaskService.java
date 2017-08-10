package com.example.day1test.Services;

import com.example.day1test.DTO.TaskDTO;
import com.example.day1test.Domains.Task;
import com.example.day1test.Repository.ProjectRepository;
import com.example.day1test.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xplode on 10/8/17.
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Task addTask(TaskDTO taskDTO) {
        if(taskDTO.getDueDate()==null || taskDTO.getEmployee()==null||taskDTO.getProject()==null ||
                taskDTO.getStartDate()==null || taskDTO.getTaskDescription()==null ){
            return null;
        }
        //Converting date from string To Date format
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate=new Date();
        Date dueDate=new Date();
                try {
                    startDate = (Date)formatter.parse(taskDTO.getStartDate());
                    dueDate=(Date)formatter.parse(taskDTO.getDueDate());
                }
                catch (ParseException e){

                }
         Task task=new Task();
        task.setEmployee(taskDTO.getEmployee());
        task.setProject(taskDTO.getProject());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setDueDate(dueDate);
        task.setStartDate(startDate);

        Task task1=taskRepository.save(task);
        return task1;

    }

    public HashMap<String,List<TaskDTO>> getAllData(){
        List<Task> taskList=taskRepository.findAll();
        HashMap<String,List<TaskDTO>> map=convertToHashMap(taskList);
        return map;
    }
/*
  Converting date to String
 */
    public TaskDTO convertDateToString(Task task){
        TaskDTO taskDTO=new TaskDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String startDate = sdf.format(task.getStartDate() );
        String dueDate=sdf.format(task.getDueDate());

        taskDTO.setDueDate(dueDate);
        taskDTO.setStartDate(startDate);
        taskDTO.setEmployee(task.getEmployee());
        taskDTO.setProject(task.getProject());
        taskDTO.setTaskDescription(task.getTaskDescription());

        return taskDTO;

    }

   public HashMap<String,List<TaskDTO>> convertToHashMap(List<Task> taskList){
        HashMap<String,List<TaskDTO>> map=new HashMap<>();
        for(int i=0;i<taskList.size();i++){

            TaskDTO taskdto=convertDateToString(taskList.get(i));

            if(map.containsKey(taskdto.getProject().getProjectName())){
                List<TaskDTO> list=map.get(taskdto.getProject().getProjectName());
                list.add(taskdto);
                map.put(taskdto.getProject().getProjectName(),list);
            }
            else{
                List<TaskDTO> list=new ArrayList<>();
                list.add(taskdto);
                map.put(taskdto.getProject().getProjectName(),list);

            }

            System.out.print(map);
        }
        return map;
    }

    public HashMap<String,List<TaskDTO>> getSelectedData(Long id){
        List<Task> taskList=taskRepository.findById(id);
        HashMap<String,List<TaskDTO>> map=convertToHashMap(taskList);
        return map;


    }
}
