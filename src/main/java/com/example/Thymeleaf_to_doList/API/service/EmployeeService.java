package com.example.Thymeleaf_to_doList.API.service;


import com.example.Thymeleaf_to_doList.API.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService  {

    void updateEmployee(int id, Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    Employee updateEmployee(Long id, String name);

    Page<Employee> findPaginated(int pageNo, int pageSize);

    void updateEmployee(Long id, Employee employee);

    void save(Employee employee);

    void deleteEmployee(int id);
}
