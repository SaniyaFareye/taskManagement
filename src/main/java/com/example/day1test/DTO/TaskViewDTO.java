package com.example.day1test.DTO;

import com.example.day1test.Domains.Task;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xplode on 10/8/17.
 */
public class TaskViewDTO {
    HashMap<String,List<Task>> taskList;

    public TaskViewDTO() {
    }

    public HashMap<String, List<Task>> getTaskList() {
        return taskList;
    }

    public void setTaskList(HashMap<String, List<Task>> taskList) {
        this.taskList = taskList;
    }
}
