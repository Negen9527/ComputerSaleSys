package com.scs.dao;


public interface SalaryDao {
	//查询某月份的所有薪资
	Object selectAllByMonth(String yearAndMonth);

	//查询某人某月的薪资情况
	Object selectOneByMonth(Integer userId,String yearAndMonth);
	
}
