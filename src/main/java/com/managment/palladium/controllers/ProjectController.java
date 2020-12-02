package com.managment.palladium.controllers;

import com.managment.palladium.dao.EmployeeRepository;
import com.managment.palladium.dao.ProjectRepository;
import com.managment.palladium.entities.Employee;
import com.managment.palladium.entities.Project;
import com.managment.palladium.services.EmployeeService;
import com.managment.palladium.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeRepository empRepo;

    // An empty getmapping maps to the requestmapping for the controller class (in this case /projects)
    @GetMapping
    public String displayProjects(Model model) {
        Iterable<Project> projects = proService.getAll();
        model.addAttribute("projects", projects);
        return "projects/project-view";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "projects/project-new";
    }

    // This handles saving to the h2 database
    @PostMapping("/save")
    public String createProjectForm(Project project, Model model) {
        proService.save(project);

        // A redirect prevents duplicate submissions
        return "redirect:/projects";
    }

    @GetMapping("/update")
    public String displayProjectUpdateForm(@RequestParam("id") long theId, Model model) {

        Project thePro = proService.findByProjectId(theId);

        model.addAttribute("project", thePro);


        return "projects/project-new";
    }


    @GetMapping("delete")
    public String deleteProject(@RequestParam("id") long theId, Model model) {
        Project thePro = proService.findByProjectId(theId);
        proService.delete(thePro);
        return "redirect:/projects";
    }
}
