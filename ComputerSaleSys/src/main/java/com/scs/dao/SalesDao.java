package com.scs.dao;

import java.util.List;

import com.scs.entity.Sales;

public interface SalesDao {

	//保存
	int saveSales(Sales sales);
	//删除
	int deleteSales(Integer id);
	//取出所有
	List<Sales> selectAllSales();
	
}
