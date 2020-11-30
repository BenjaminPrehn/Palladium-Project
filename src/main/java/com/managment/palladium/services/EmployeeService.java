package com.managment.palladium.services;

import com.managment.palladium.dao.EmployeeRepository;
import com.managment.palladium.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public Iterable<Employee> getAll() {
        return empRepo.findAll();
    }

    public Employee findByEmployeeId(long theId){
        return empRepo.findByEmployeeId(theId);
    }

    public void delete(Employee theEmp){
        empRepo.delete(theEmp);
    }

}
