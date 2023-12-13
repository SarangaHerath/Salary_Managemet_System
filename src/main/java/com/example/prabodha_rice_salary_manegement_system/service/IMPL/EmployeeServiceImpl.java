package com.example.prabodha_rice_salary_manegement_system.service.IMPL;

import com.example.prabodha_rice_salary_manegement_system.dto.EmployeeDto;
import com.example.prabodha_rice_salary_manegement_system.dto.request.EmployeeDataRequestDto;
import com.example.prabodha_rice_salary_manegement_system.dto.response.EmployeeDataResponseDto;
import com.example.prabodha_rice_salary_manegement_system.entity.AdvancePayment;
import com.example.prabodha_rice_salary_manegement_system.entity.Employee;
import com.example.prabodha_rice_salary_manegement_system.entity.Salary;
import com.example.prabodha_rice_salary_manegement_system.repository.AdvancePaymentRepo;
import com.example.prabodha_rice_salary_manegement_system.repository.EmployeeRepo;
import com.example.prabodha_rice_salary_manegement_system.repository.SalaryRepo;
import com.example.prabodha_rice_salary_manegement_system.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AdvancePaymentRepo advancePaymentRepo;

    @Autowired
    private SalaryRepo salaryRepo;

   @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
         try {
            Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getAddress(),
                employeeDto.getRole()
        );
        return employeeRepo.save(employee);

             } catch (Exception e) {
                   // Log the exception or handle it based on your application's requirements.
                   e.printStackTrace();
                   throw new RuntimeException("Error saving employee", e);
    }
}

    @Override
    public List<Employee> getAllEmployee() {
        try {
            List<Employee> employeeList = employeeRepo.findAll();
            return employeeList;
        } catch (Exception e) {
            // Log the exception or handle it based on your application's requirements.
            e.printStackTrace();
            throw new RuntimeException("Error getting all employees", e);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try {
            return employeeRepo.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        } catch (Exception e) {
            // Log the exception or handle it based on your application's requirements.
            e.printStackTrace();
            throw new RuntimeException("Error getting employee by id", e);
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        try {
            employeeRepo.deleteById(id);
            return "Employee id " + id + " deleted successfully!";
        } catch (EmptyResultDataAccessException e) {
            // This exception is thrown when the employee with the given id is not found.
            throw new EntityNotFoundException("Employee not found with id: " + id);
        } catch (DataIntegrityViolationException e) {
            // This exception is thrown when there is a foreign key constraint violation.
            // Handle it by providing a meaningful response to the user.
            throw new IllegalStateException("Cannot delete employee with id " + id +
                    " as there are dependent records in other tables.");
        } catch (Exception e) {
            // Log the exception or handle it based on your application's requirements.
            e.printStackTrace();
            throw new RuntimeException("Error deleting employee", e);
        }

    }

    @Override
    public Employee updateUser(EmployeeDto employeeDto, Long id) {
        try {
            Optional<Employee> optionalEmployee = employeeRepo.findById(id);

            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.setName(employeeDto.getName());
                employee.setEmail(employeeDto.getEmail());
                employee.setAddress(employeeDto.getAddress());
                employee.setRole(employeeDto.getRole());

                return employeeRepo.save(employee);
            } else {
                throw new EntityNotFoundException("Employee not found with id: " + id);
            }
        } catch (Exception e) {
            // Log the exception or handle it based on your application's requirements.
            e.printStackTrace();
            throw new RuntimeException("Error updating employee", e);
        }
    }

    @Override
    public List<EmployeeDataResponseDto> getEmployeeData(Long employeeId, LocalDate fromDate,LocalDate toDate) {

       List<EmployeeDataResponseDto> result = new ArrayList<>();

       List<LocalDate> dateRange = fromDate
               .datesUntil(toDate.plusDays(1))
               .collect(Collectors.toList());
       double runningBalance =0.0;

       for(LocalDate date : dateRange){
           double salary = getSalaryForDate(employeeId,date);
           double advance = getAdvanceForDate(employeeId,date);
           double balance = runningBalance + salary - advance;

           EmployeeDataResponseDto employeeDataResponseDto = new EmployeeDataResponseDto(
                 date,salary,advance,balance
           );
           result.add(employeeDataResponseDto);
           runningBalance=balance;
       }
       return result;
    }
    private double getSalaryForDate(Long employeeId,LocalDate date){
       List<Salary> salaries = salaryRepo.findByEmployeeIdAndDate(employeeId,date);
       return salaries.stream().mapToDouble(Salary::getAmount).sum();
    }
    private double getAdvanceForDate(Long employeeId,LocalDate date){
        List<AdvancePayment> salaries = advancePaymentRepo.findByEmployeeIdAndDate(employeeId,date);
        return salaries.stream().mapToDouble(AdvancePayment::getAmount).sum();
    }

}
