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
import com.scs.service.SalesService;
import com.scs.utils.DateUtil;

import freemarker.core.ReturnInstruction.Return;
import net.sf.json.JSONObject;

@ParentPackage("json-default")
@Namespace(value = "/")
public class SalesAction extends ActionSupport{
	private JSONObject jsonData = new JSONObject();
	
	@Resource(name = "salesService")
	private SalesService salesService;
	
	
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}


	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
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
			Sales sales = new Sales();
			sales.setSalesManId(saleManId);
			sales.setProductId(productId);
			sales.setOutPrice(outPrice);
			sales.setSalesTime(saleTime);
			sales.setBuyerName(buyerName);
			sales.setBuyTel(buyTel);
			sales.setProductName(productName);
			jsonResult.put("result", salesService.addSaveSales(sales) == 0?false:true);
			
			
		} catch (ParseException e) {
			jsonResult.put("result", 0);
			e.printStackTrace();
			
		}
		this.setJsonData(jsonResult);
		
		return SUCCESS;
	}
}
