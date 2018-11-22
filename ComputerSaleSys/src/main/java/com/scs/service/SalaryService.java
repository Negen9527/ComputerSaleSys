package com.scs.service;

import net.sf.json.JSONArray;

public interface SalaryService {
	//某月所有人的工资
	JSONArray selectAllSalaryByMonth(String Month);
}
