package com.example.Thymeleaf_to_doList.API.repository;

import com.example.Thymeleaf_to_doList.API.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
