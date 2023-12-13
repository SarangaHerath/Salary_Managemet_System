package com.example.prabodha_rice_salary_manegement_system.controller;

import com.example.prabodha_rice_salary_manegement_system.dto.AdvancePaymentDto;
import com.example.prabodha_rice_salary_manegement_system.entity.AdvancePayment;
import com.example.prabodha_rice_salary_manegement_system.service.AdvancePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/advance")
public class AdvancePaymentController {

    @Autowired
    private AdvancePaymentService advancePaymentService;

    @PostMapping("/save")
    public AdvancePayment saveAdvancePayment(@RequestBody AdvancePaymentDto advancePaymentDto){
        AdvancePayment advancePayment =advancePaymentService.saveAdvancePayment(advancePaymentDto);
        return advancePayment;
    }
}
