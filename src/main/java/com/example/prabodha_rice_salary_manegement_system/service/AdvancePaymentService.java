package com.example.prabodha_rice_salary_manegement_system.service;

import com.example.prabodha_rice_salary_manegement_system.dto.AdvancePaymentDto;
import com.example.prabodha_rice_salary_manegement_system.entity.AdvancePayment;

public interface AdvancePaymentService {
    AdvancePayment saveAdvancePayment(AdvancePaymentDto advancePaymentDto);
}
