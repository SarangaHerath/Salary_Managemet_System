package com.example.prabodha_rice_salary_manegement_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDataRequestDto {
    private Long employee_id;
    private LocalDate fromDate;
    private LocalDate toDate;
}
