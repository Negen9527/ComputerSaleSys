package com.scs.service;

import java.util.List;

import com.scs.entity.Sales;

import net.sf.json.JSONArray;

public interface SalesService {
	//添加销售记录
	int addSaveSales(Sales sales);
	
	//所有销售记录
	JSONArray selectAllSoldNote();
	
	//删除销售记录
	int deleteSold(Integer id);
	
}
