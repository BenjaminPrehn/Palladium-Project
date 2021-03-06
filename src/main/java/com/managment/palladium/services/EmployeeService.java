package com.managment.palladium.services;

import com.managment.palladium.dao.EmployeeRepository;
import com.managment.palladium.dto.EmployeeProject;
import com.managment.palladium.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    // CRUD OPERATIONS
    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return empRepo.employeeProjects();
    }

    public Employee findByEmployeeId(long theId) {
        return empRepo.findByEmployeeId(theId);
    }

    public void delete(Employee theEmp) { empRepo.delete(theEmp);
    }

}
