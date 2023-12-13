package com.example.prabodha_rice_salary_manegement_system.service;

import com.example.prabodha_rice_salary_manegement_system.dto.SalaryDto;
import com.example.prabodha_rice_salary_manegement_system.entity.Salary;

public interface SalaryService {
    Salary saveSalary(SalaryDto salaryDto);
}
