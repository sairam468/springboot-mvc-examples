package com.sit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sit.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE " +
		       "(:ename IS NULL OR e.ename LIKE %:ename%) AND " +
		       "(:job IS NULL OR e.job LIKE %:job%) AND " +
		       "(:deptno IS NULL OR e.deptno = :deptno)")
		List<Employee> searchEmployees(@Param("ename") String ename, @Param("job") String job, @Param("deptno") Integer deptno);

}
