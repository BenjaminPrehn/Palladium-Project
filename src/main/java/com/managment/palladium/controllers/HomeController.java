package com.managment.palladium.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.managment.palladium.dto.ChartData;
import com.managment.palladium.dto.EmployeeProject;
import com.managment.palladium.entities.Project;
import com.managment.palladium.services.EmployeeService;
import com.managment.palladium.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    EmployeeService empService;

    @Autowired
    ProjectService proService;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        Iterable<Project> projects = proService.getAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proService.getProjectStatus();

        // Convert projectData object into a json structure for us in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCnt", jsonString);

        List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
        model.addAttribute("employeesListProjectCnt", employeesProjectCnt);

        return "index";
    }



}
