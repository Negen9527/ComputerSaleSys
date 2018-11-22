package com.scs.service;
import com.scs.entity.Product;
import net.sf.json.JSONArray;

public interface ProductService {
	//新增电脑
	int addProduct(Product product);
	//所有电脑
	JSONArray listAllProduct();
	//修改电脑信息
	int modifyProductInfo(Product product);
	//删除电脑
	int deleteProductById(Integer id);
	//修改数量
	int updateAmount(Integer id, Integer amount);
	//退货添加数量
	void addAmount(Integer productId);
}
