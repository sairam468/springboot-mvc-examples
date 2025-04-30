package com.sit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="emp")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="emp_eno_seq",initialValue=2000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length=40)
	@NonNull
	private String ename;
	@NonNull
	private Double sal;
	@Column(length=40)
	@NonNull
	private String job;
	@NonNull
	private Integer deptno=10;
	
	
}
