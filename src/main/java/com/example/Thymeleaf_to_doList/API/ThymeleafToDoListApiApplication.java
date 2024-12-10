package com.example.Thymeleaf_to_doList.API;

import com.example.Thymeleaf_to_doList.API.model.Employee;
import com.example.Thymeleaf_to_doList.API.repository.EmployeeRepository;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ThymeleafToDoListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafToDoListApiApplication.class, args);
	}

}

