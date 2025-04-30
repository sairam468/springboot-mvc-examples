package com.sit.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.sit.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
