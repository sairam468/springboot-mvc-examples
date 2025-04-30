package com.sit.repository;




import org.springframework.data.repository.PagingAndSortingRepository;

import com.sit.entity.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
