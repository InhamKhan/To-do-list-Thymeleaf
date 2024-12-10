package com.example.Thymeleaf_to_doList.API.controller;

import com.example.Thymeleaf_to_doList.API.model.Employee;
import com.example.Thymeleaf_to_doList.API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Home page: List all employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index"; // Ensure you have an index.html for the view
    }

    // Show new employee form
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new_employee"; // Your form to add new employee
    }

    // Save new employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "new_employee";
        }
        employeeService.save(employee);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee"; // Your form to update employee
    }


    // Update employee
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @Validated @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "update_employee";
        }
        employee.setId(id); // Ensure the employee ID is set correctly
        employeeService.updateEmployee(id, employee);
        return "redirect:/";
    }

    // Delete employee
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/"; // Redirect to the employee list after deletion
    }
}
