package com.example.prabodha_rice_salary_manegement_system.controller;

import com.example.prabodha_rice_salary_manegement_system.dto.SalaryDto;
import com.example.prabodha_rice_salary_manegement_system.entity.Salary;
import com.example.prabodha_rice_salary_manegement_system.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @PostMapping("/save")
    public Salary addSalary(@RequestBody SalaryDto salaryDto){

        Salary salary = salaryService.saveSalary(salaryDto);
        return salary;
    }
}
