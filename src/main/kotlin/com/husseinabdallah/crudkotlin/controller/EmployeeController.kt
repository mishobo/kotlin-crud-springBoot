package com.husseinabdallah.crudkotlin.controller

import com.husseinabdallah.crudkotlin.model.Employee
import com.husseinabdallah.crudkotlin.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @RequestMapping("/hello")
    fun helloWorld(): String{
        return "Hello Mother Fucker"
    }

    @PostMapping("/employees")
    fun createEmployee(@RequestBody payload: Employee): Employee = employeeService.createEmployee(payload)

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): Employee =
        employeeService.getEmployeesById(employeeId)

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeService.getAllEmployees()

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @RequestBody payload: Employee): Employee =
        employeeService.updateEmployeeById(employeeId, payload)

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): Unit =
        employeeService.deleteEmployeesById(employeeId)


}