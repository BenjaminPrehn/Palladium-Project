package com.managment.palladium.controllers;

import com.managment.palladium.entities.Employee;
import com.managment.palladium.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    // Loading all data from Employee table in our database
   @GetMapping
    public String displayEmployees(Model model) {
        Iterable<Employee> employees = empService.getAll();
        model.addAttribute("employees", employees);
        return "employees/employee-view";
    }

    // Loading form to create a new employee
    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee anEmployee = new Employee();

        model.addAttribute("employee", anEmployee);

        return "employees/employee-new";
    }

    // Saving the employee to our databae
    @PostMapping("/save")
    public String createEmployee(Model model, @Valid Employee employee, Errors errors) {

        if(errors.hasErrors())
            return "employees/employee-new";

        // save to the database using an employee crud repository
        empService.save(employee);

        return "redirect:/employees";
    }

    // Using the same page as create employee to load in an employee and change the data.
    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {

        Employee theEmp = empService.findByEmployeeId(theId);

        model.addAttribute("employee", theEmp);


        return "employees/employee-new";
    }

    // Delete an employee from the database.
    @GetMapping("delete")
    public String deleteEmployee(@RequestParam("id") long theId, Model model) {
        Employee theEmp = empService.findByEmployeeId(theId);
        empService.delete(theEmp);
        return "redirect:/employees";
    }

}
