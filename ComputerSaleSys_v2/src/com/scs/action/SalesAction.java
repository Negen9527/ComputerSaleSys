package com.scs.action;


import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.entity.Sales;
import com.scs.service.ProductService;
import com.scs.service.SalesService;
import com.scs.utils.DateUtil;

import freemarker.core.ReturnInstruction.Return;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@ParentPackage("json-default")
@Namespace(value = "/")
public class SalesAction extends ActionSupport{
	private JSONObject jsonData = new JSONObject();
	private JSONArray jsonArrData = new JSONArray();
	@Resource(name = "salesService")
	private SalesService salesService;
	
	@Resource(name = "productService")
	private ProductService productService;
	
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}


	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}



	public JSONObject getJsonData() {
		return jsonData;
	}



	public JSONArray getJsonArrData() {
		return jsonArrData;
	}



	public void setJsonArrData(JSONArray jsonArrData) {
		this.jsonArrData = jsonArrData;
	}



	/**
	 * 	添加销售记录
	 * @return
	 */
	@Action(value="/addSales",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String addSales() {
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject jsonResult = new JSONObject();
		try {
			Integer saleManId = Integer.parseInt(request.getParameter("salesManId"));
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			Double outPrice = Double.parseDouble(request.getParameter("outPrice"));
			Date saleTime = DateUtil.str2date(request.getParameter("salesTime"));
			String buyerName = request.getParameter("buyerName");
			String buyTel = request.getParameter("buyerTel");
			String productName = request.getParameter("productName");
			//------------------------分割线
			Integer amount = Integer.parseInt(request.getParameter("amount"));
			Sales sales = new Sales();
			sales.setSalesManId(saleManId);
			sales.setProductId(productId);
			sales.setOutPrice(outPrice);
			sales.setSalesTime(saleTime);
			sales.setBuyerName(buyerName);
			sales.setBuyTel(buyTel);
			sales.setProductName(productName);
			//修改数量
			productService.updateAmount(productId, amount - 1);
			
			jsonResult.put("result", salesService.addSaveSales(sales) == 0?false:true);
			
			
		} catch (ParseException e) {
			jsonResult.put("result", false);
			e.printStackTrace();
			
		}
		this.setJsonData(jsonResult);
		System.out.println(jsonData.toString());
		return SUCCESS;
	}
	
	
	/**
	 * 	所有销售记录
	 * @return
	 */
	@Action(value = "allSold",
			results = {
					@Result(type = "json", params = {"root", "jsonArrData"})
			})
	public String allSold() {
		this.setJsonArrData(salesService.selectAllSoldNote());
		return SUCCESS;
	}
	
	
	
	/**
	 * 	删除销售记录
	 */
	@Action(value="/deleteSold",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String deleteSold() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer soldId = Integer.parseInt(request.getParameter("soldId"));
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		//增加产品数量
		productService.addAmount(productId);
		//删除销售记录
		JSONObject tempJSON = new JSONObject();
		tempJSON.put("result", salesService.deleteSold(soldId) == 0?false:true);
		this.setJsonData(tempJSON);
		return SUCCESS;
	}
	
	
	
	
	
	
	
}
