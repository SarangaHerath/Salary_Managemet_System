package com.example.prabodha_rice_salary_manegement_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String role;
}
