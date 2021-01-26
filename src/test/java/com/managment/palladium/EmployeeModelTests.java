package com.managment.palladium;

import com.managment.palladium.dao.EmployeeRepository;
import com.managment.palladium.entities.Employee;
import com.managment.palladium.services.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeModelTests {

    @Autowired
    private EmployeeService empService;

    @MockBean
    private EmployeeRepository empRepo;

    //Test for getter method
    public void getModelTest() {
        //arrange
        Employee testEmployee = new Employee("Emil", "Madsen", "em@mail.dk", "Employee");
        //act
        String expected = "Emil";
        String actual = testEmployee.getFirstname();
        //assert
        assertEquals(expected, actual);
    }

    //Test using mockito method when().then() for getAll()
    @Test
    public void getAllEmployeesTest() {
        when(empService.getAll()).thenReturn(
                Stream.of(
                        new Employee("Emil", "Madsen", "em@mail.dk", "Employee"),
                        new Employee("Theis", "Schlander", "ts@mail.dk", "Employee"))
                        .collect(Collectors.toList()));
        assertEquals(2, empService.getAll().size());
    }

}