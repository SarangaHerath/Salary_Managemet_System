package com.example.prabodha_rice_salary_manegement_system.service.IMPL;

import com.example.prabodha_rice_salary_manegement_system.dto.SalaryDto;
import com.example.prabodha_rice_salary_manegement_system.entity.Salary;
import com.example.prabodha_rice_salary_manegement_system.repository.SalaryRepo;
import com.example.prabodha_rice_salary_manegement_system.service.EmployeeService;
import com.example.prabodha_rice_salary_manegement_system.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    private EmployeeService employeeService;
    @Override
    public Salary saveSalary(SalaryDto salaryDto) {
        Salary salary = new Salary(
                salaryDto.getId(),
                salaryDto.getDate(),
                salaryDto.getAmount(),
                salaryDto.getDescription(),
                employeeService.getEmployeeById(salaryDto.getEmployee_id())
        );
        salaryRepo.save(salary);

        return salary;
    }
}
