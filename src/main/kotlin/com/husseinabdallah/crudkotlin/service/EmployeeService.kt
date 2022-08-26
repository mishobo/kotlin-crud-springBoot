package com.husseinabdallah.crudkotlin.service

import com.husseinabdallah.crudkotlin.exception.EmployeeNotFoundException
import com.husseinabdallah.crudkotlin.model.Employee
import com.husseinabdallah.crudkotlin.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmployeeService (private val employeeRepository: EmployeeRepository) {

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun getEmployeesById(employeeId: Long): Employee = employeeRepository.findById(employeeId)
        .orElseThrow { EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found") }

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun updateEmployeeById(employeeId: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                Employee(
                    id = employee.id,
                    userName = employee.userName,
                    firstName = employee.firstName,
                    middleName = employee.middleName,
                    lastName = employee.lastName,
                    emailId = employee.emailId,
                    dayOfBirth = employee.dayOfBirth
                )
            )
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }

}