package com.example.prabodha_rice_salary_manegement_system.service;

import com.example.prabodha_rice_salary_manegement_system.dto.EmployeeDto;
import com.example.prabodha_rice_salary_manegement_system.dto.request.EmployeeDataRequestDto;
import com.example.prabodha_rice_salary_manegement_system.dto.response.EmployeeDataResponseDto;
import com.example.prabodha_rice_salary_manegement_system.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployee();

   Employee getEmployeeById(Long id);

    String deleteEmployee(Long id);

    Employee updateUser(EmployeeDto employeeDto,Long id);

    List<EmployeeDataResponseDto> getEmployeeData(Long employeeId, LocalDate fromDate,LocalDate toDate);
}
