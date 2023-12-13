package com.example.prabodha_rice_salary_manegement_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PrabodhaRiceSalaryManegementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrabodhaRiceSalaryManegementSystemApplication.class, args);
    }

}
