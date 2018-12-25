package com.scs.serviceImp;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.ProductDao;
import com.scs.entity.Product;
import com.scs.service.ProductService;
import com.scs.utils.DateUtil;

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
				tempJSON.put("inTime", DateUtil.date2str(product.getInTime()));
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


	/**
	 * 	修改数量
	 */
	@Override
	public int updateAmount(Integer id, Integer amount) {
		return productDao.modifyAmount(id, amount);
	}


	/**
	 * 	退货添加数量
	 */
	@Override
	public void addAmount(Integer productId) {
		productDao.addAmount(productId);
	}


	/**
	 * 	查看电脑详情
	 */
	@Override
	public JSONObject selectOneByProductId(Integer productId) {
		JSONObject productJSON = null;
		List<Object[]> products = (List<Object[]>) productDao.selectOneByProductId(productId);
		if(null != products) {
			productJSON = new JSONObject();
			Object[] product = products.get(0);
			String name = (String)product[0];
			String typeId = (String)product[1];
			Double inPrice = (Double)product[2];
			Integer amount = (Integer)product[3];
			String inTime = DateUtil.date2str((Date)product[4]);
			String supplier = (String)product[5];
			String screenSize = (String)product[6];
			Double weight = (Double)product[7];
			String cpu = (String)product[8];
			String videCard = (String)product[9];
			String ram = (String)product[10];
			String hardPan = (String)product[11];
			
			productJSON.put("name", name);
			productJSON.put("typeId", typeId);
			productJSON.put("inPrice", inPrice);
			productJSON.put("amount", amount);
			productJSON.put("inTime", inTime);
			productJSON.put("supplier", supplier);
			productJSON.put("screenSize", screenSize);
			productJSON.put("weight", weight);
			productJSON.put("cpu", cpu);
			productJSON.put("videCard", videCard);
			productJSON.put("ram", ram);
			productJSON.put("hardPan", hardPan);
		}
		return productJSON;
	}


}
