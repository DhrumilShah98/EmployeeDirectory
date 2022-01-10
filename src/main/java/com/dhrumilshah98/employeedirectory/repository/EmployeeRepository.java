package com.dhrumilshah98.employeedirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhrumilshah98.employeedirectory.entity.Employee;

/**
 * {@code EmployeeRepository} class contains the necessary methods to perform the database related operations.
 * 
 * @author Dhrumil Amish Shah
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}