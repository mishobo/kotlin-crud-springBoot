package com.husseinabdallah.crudkotlin.repository

import com.husseinabdallah.crudkotlin.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {


}