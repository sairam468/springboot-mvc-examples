package com.sit.entity;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Table(name="boot_emp")
@Entity
@Data
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='INACTIVE' WHERE EMPNO=?")
@SQLRestriction("STATUS <> 'deleted'")
public class Employee {

    @Id
    @SequenceGenerator(name="gen1", sequenceName="emp_eno_seq", initialValue=2000, allocationSize=1)
    @GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
    private Integer empno;

    @Column(length=40)
    @NotNull(message = "Employee name cannot be null")
    private String ename;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 1, message = "Salary must be greater than 0")
    private Double sal;

    @Column(length=40)
    @NotNull(message = "Job cannot be null")
    private String job;

    @NotNull(message = "Department number cannot be null")
    private Integer deptno;
    
    private String status="active";
}
