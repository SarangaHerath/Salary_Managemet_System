package com.example.prabodha_rice_salary_manegement_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvancePaymentDto {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String description;
    private Long employee_id;
}
