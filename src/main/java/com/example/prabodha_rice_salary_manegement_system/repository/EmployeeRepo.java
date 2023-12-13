package com.example.prabodha_rice_salary_manegement_system.repository;

import com.example.prabodha_rice_salary_manegement_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
