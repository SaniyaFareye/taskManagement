package com.example.day1test.Services;

import com.example.day1test.Domains.Project;
import com.example.day1test.Repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by xplode on 10/8/17.
 */
@RunWith(MockitoJUnitRunner.class)

public class ProjectServiceTest {

    @InjectMocks
    ProjectService projectService;


    @Mock
    private  ProjectRepository projectRepository;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProjectList(){
        List<Project> projectList=new ArrayList<>();
        Project project=new Project();
        project.setProjectId(1L);
        project.setProjectName("project1");
        projectList.add(project);

        when(projectRepository.findAll()).thenReturn(projectList);
        List<Project> projectList1=projectService.getProjectList();
        assertEquals(1,projectList1.size());
    }
}