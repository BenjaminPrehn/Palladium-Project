package com.managment.palladium.dao;


import com.managment.palladium.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    public Employee findByEmail(String value);

    public Employee findByEmployeeId(long theId);

}
