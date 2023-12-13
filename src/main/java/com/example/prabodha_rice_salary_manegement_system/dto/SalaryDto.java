package com.example.prabodha_rice_salary_manegement_system.dto;

import com.example.prabodha_rice_salary_manegement_system.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryDto {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String description;
    private Long employee_id;

}
