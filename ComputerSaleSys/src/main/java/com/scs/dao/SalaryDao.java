package com.scs.dao;

import java.util.List;

import com.scs.entity.Salary;

public interface SalaryDao {
	//新增工资记录
	int saveSalary(Salary salary);
	//查看所有薪资
	List<Salary> selectAllSalary();
	//查询薪资根据id
	Salary findSalaryById(Integer id);
}
