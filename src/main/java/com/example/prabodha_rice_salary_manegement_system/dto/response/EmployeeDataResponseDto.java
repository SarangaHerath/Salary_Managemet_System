package com.example.prabodha_rice_salary_manegement_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDataResponseDto {
    private LocalDate date;
    private double salary;
    private double advance;
    private double balance;
}
