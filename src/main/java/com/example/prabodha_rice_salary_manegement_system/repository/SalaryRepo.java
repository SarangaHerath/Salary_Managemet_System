package com.example.prabodha_rice_salary_manegement_system.repository;

import com.example.prabodha_rice_salary_manegement_system.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface SalaryRepo extends JpaRepository<Salary,Long> {
    List<Salary> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
