package com.example.Thymeleaf_to_doList.API.service;

import com.example.Thymeleaf_to_doList.API.model.Employee;
import com.example.Thymeleaf_to_doList.API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees); // Debugging purpose
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById((int) id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById((int) id);
    }

    @Override
    public Employee updateEmployee(Long id, String name) {
        return null;
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo - 1, pageSize);
        return this.employeeRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(Math.toIntExact(id));
        if(existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setCityName(employee.getCityName());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setDesignation(employee.getDesignation());
            employeeRepository.save(updatedEmployee);
        }
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
