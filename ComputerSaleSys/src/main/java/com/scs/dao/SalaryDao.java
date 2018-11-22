package com.scs.dao;


public interface SalaryDao {
	//查询某月份的所有薪资
	Object selectAllByMonth(String yearAndMonth);

	
	
}
