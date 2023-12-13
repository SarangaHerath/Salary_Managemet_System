package com.example.prabodha_rice_salary_manegement_system.service.IMPL;

import com.example.prabodha_rice_salary_manegement_system.dto.AdvancePaymentDto;
import com.example.prabodha_rice_salary_manegement_system.entity.AdvancePayment;
import com.example.prabodha_rice_salary_manegement_system.entity.Employee;
import com.example.prabodha_rice_salary_manegement_system.repository.AdvancePaymentRepo;
import com.example.prabodha_rice_salary_manegement_system.service.AdvancePaymentService;
import com.example.prabodha_rice_salary_manegement_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvancePaymentServiceImpl implements AdvancePaymentService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AdvancePaymentRepo advancePaymentRepo;

    @Override
    public AdvancePayment saveAdvancePayment(AdvancePaymentDto advancePaymentDto) {
        Long employeeId = advancePaymentDto.getEmployee_id();

        // Check if the employeeId is null before trying to fetch the employee
        if (employeeId == null) {
            throw new IllegalArgumentException("Employee ID cannot be null");
        }

        Employee employee = employeeService.getEmployeeById(employeeId);

        AdvancePayment advancePayment = new AdvancePayment(
                advancePaymentDto.getId(),
                advancePaymentDto.getDate(),
                advancePaymentDto.getAmount(),
                advancePaymentDto.getDescription(),
                employee
        );

        advancePaymentRepo.save(advancePayment);
        return advancePayment;
    }

}
