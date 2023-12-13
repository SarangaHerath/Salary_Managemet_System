package com.example.prabodha_rice_salary_manegement_system.controller;

import com.example.prabodha_rice_salary_manegement_system.dto.EmployeeDto;
import com.example.prabodha_rice_salary_manegement_system.dto.response.EmployeeDataResponseDto;
import com.example.prabodha_rice_salary_manegement_system.entity.Employee;
import com.example.prabodha_rice_salary_manegement_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "**")
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody EmployeeDto employeeDto){
          Employee employee = employeeService.saveEmployee(employeeDto);
          return employee;
    }
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return employeeList;
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }
    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        String msg = employeeService.deleteEmployee(id);
        return msg;
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){
        Employee employee= employeeService.updateUser(employeeDto,id);
        return employee;
    }
    @GetMapping("/getDetailsBetweenDate")
    public ResponseEntity<List<EmployeeDataResponseDto>>  getEmployeeData(
            @RequestParam(name = "employee_id") Long employeeId,
            @RequestParam(name = "fromDate") LocalDate fromDate,
            @RequestParam(name = "toDate") LocalDate toDate)
    {
        List<EmployeeDataResponseDto> employeeDataResponseDtos = employeeService.getEmployeeData(employeeId,fromDate,toDate);
        return ResponseEntity.ok(employeeDataResponseDtos);
    }
}
