package com.example.day1test.Controllers;

import com.example.day1test.Domains.Project;
import com.example.day1test.Repository.ProjectRepository;
import com.example.day1test.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xplode on 9/8/17.
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /*
    Returning Project list
     */
    @RequestMapping(value = "/projectList",method = RequestMethod.POST)
    public ResponseEntity getProjectList(){

            List<Project> projectList= projectService.getProjectList();
            if(projectList.isEmpty()){
                return new ResponseEntity("NO Data Found",HttpStatus.NOT_FOUND);

            }
            return new ResponseEntity(projectList,HttpStatus.OK);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

    }
}
