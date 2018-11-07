package com.scs.dao;

import java.util.List;

import com.scs.entity.Product;

public interface ProductDao {
	//保存电脑
	int savaProduct(Product product);
	//取出所有电脑
	List<Product> selectAllProduct();
	//修改电脑信息
	int update(Product product);
	//删除电脑信息，通过id
	int delete(Integer id);
	//统计页数
	int totalPages();
	//分页查询
	List<Product> selectProductByPageNum(Integer pageNum, Integer pageSize);
}
