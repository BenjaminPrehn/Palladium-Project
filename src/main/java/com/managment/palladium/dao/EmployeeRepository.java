package com.managment.palladium.dao;


import com.managment.palladium.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmail(String value);

    public Employee findByEmployeeId(long theId);

}
