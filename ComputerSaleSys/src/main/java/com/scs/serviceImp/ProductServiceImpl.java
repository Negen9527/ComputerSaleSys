package com.scs.serviceImp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.ProductDao;
import com.scs.entity.Product;
import com.scs.service.ProductService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Resource(name = "productDao")
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	/**
	 * 	添加电脑
	 */
	@Override
	public int addProduct(Product product) {
		if(null != product)
			return productDao.savaProduct(product);
		else
			return 0;
	}

	
	/**
	 *  所有电脑
	 */
	@Override
	public JSONArray listAllProduct() {
		List<Product> products = productDao.selectAllProduct();
		JSONArray jsonProdctArr = new JSONArray();
		if(null != products) {
			for (Product product : products) {
				JSONObject tempJSON = new JSONObject();
				tempJSON.put("id", product.getId());
				tempJSON.put("name", product.getName());
				tempJSON.put("typeId", product.getTypeId());
				tempJSON.put("amount", product.getAmount());
				tempJSON.put("inPrice", product.getInPrice());
				tempJSON.put("outPrice", product.getOutPrice());
				tempJSON.put("inTime", product.getInTime());
				tempJSON.put("supplier", product.getSupplier());
				jsonProdctArr.add(tempJSON);
			}
		}
		return jsonProdctArr;
	}

	
	/**
	 * 	修改电脑信息
	 */
	@Override
	public int modifyProductInfo(Product product) {
		if(null != product)
			return productDao.update(product);
		else
			return 0;
	}
	
	
	
	/**
	 *  删除电脑
	 */
	@Override
	public int deleteProductById(Integer id) {
		if(id >= 0)
			return productDao.delete(id);
		else
			return 0;
	}


}
