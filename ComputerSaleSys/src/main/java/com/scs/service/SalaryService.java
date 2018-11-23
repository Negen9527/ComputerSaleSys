package com.scs.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface SalaryService {
	//某月所有人的工资
	JSONArray selectAllSalaryByMonth(String Month);
	
	//查询某人某月的工资
	JSONObject selectOneByMonth(Integer userId, String month);
	
	
	
}
