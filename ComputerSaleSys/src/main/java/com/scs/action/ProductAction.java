package com.scs.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.dao.DeployDao;
import com.scs.entity.Deploy;
import com.scs.entity.Product;
import com.scs.service.DeployService;
import com.scs.service.ProductService;
import com.scs.utils.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@ParentPackage("json-default")
@Namespace(value = "/")
public class ProductAction extends ActionSupport{
    private Integer id;
    private String name;
    private String typeId;
    private Integer amount;
    private Double inPrice;
    private Double outPrice;
    private Date inTime;
	private String supplier;
    
	private HttpServletRequest request = ServletActionContext.getRequest();
	private JSONArray jsonArrayData = new JSONArray();
	private JSONObject jsonData = new JSONObject();
	
	@Resource(name = "deployService")
	private DeployService deployService;
	

	public void setDeployService(DeployService deployService) {
		this.deployService = deployService;
	}

	@Resource(name = "productService")
	private ProductService productService;
	
	
	public JSONObject getJsonData() {
		return jsonData;
	}


	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	

	public JSONArray getJsonArrayData() {
		return jsonArrayData;
	}


	public void setJsonArrayData(JSONArray jsonArrayData) {
		this.jsonArrayData = jsonArrayData;
	}

	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	/**
	 *	 添加电脑
	 * @param request
	 */
	@Action(value="/addProduct",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String saveProduct() {
		Product product = getProductData(request);
		JSONObject jsonResult = new JSONObject();
		this.setJsonData(jsonResult);
		Integer intId = productService.addProduct(product);
		String screenSize = request.getParameter("screenSize");
		String weight = request.getParameter("weight");
		String cpu = request.getParameter("cpu");
		String videoCard = request.getParameter("videoCard");
		String ram = request.getParameter("ram");
		String hardPan = request.getParameter("hardPan");
		Deploy deploy = new Deploy();
		deploy.setProductId(intId);
		deploy.setScreenSize(screenSize);
		deploy.setWeight(Double.parseDouble(weight));
		deploy.setCpu(cpu);
		deploy.setVideoCard(videoCard);
		deploy.setRam(ram);
		deploy.setHardPan(hardPan);
		Integer intResult = deployService.addDeploy(deploy);
		jsonResult.put("addResult", intResult == 0?false:true);
		this.setJsonData(jsonResult);
		return SUCCESS;
	}
	
	
	/**
	 *	修改电脑信息
	 * @return
	 */
	@Action(value="/modifyProduct",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String modifyProduct() {
		Product product = getProductData(request);
		
		
		return SUCCESS;

	}
	
	
	/**
	 * 	删除电脑信息
	 * @return
	 */
	@Action(value="deleteProduct",
			results= {
					@Result(type="json", params={"root", "jsonData"})
			})
	public String deleteProduct() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer intResult = productService.deleteProductById(id);
		JSONObject temp = new JSONObject();
		this.setJsonData(temp);
		temp.put("deleteResult", intResult == 0?false:true);
		this.setJsonData(temp);
		return SUCCESS;
	}
	
	
	/**
	 * 	列出所有的电脑
	 * @return
	 */
	@Action(value="listProduct",
			results= {
					@Result(type="json", params={"root", "jsonArrayData"})
			})
	public String listAllProduct() {
		this.setJsonArrayData(productService.listAllProduct());
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	/**
	 * 	获取前台传来的参数
	 * @param request
	 * @return
	 */
	private Product getProductData(HttpServletRequest request) {
		Product product = null;
		try {
			product = new Product();
//			product.setId(Integer.parseInt(request.getParameter("id")));
			product.setName(request.getParameter("name"));
			product.setTypeId(request.getParameter("typeId"));
			product.setAmount(Integer.parseInt(request.getParameter("amount")));
			product.setInPrice(Double.parseDouble(request.getParameter("inPrice")));
//			product.setOutPrice(Double.parseDouble(request.getParameter("outPrice")));
			product.setInTime(DateUtil.str2date(request.getParameter("inTime")));
			product.setSupplier(request.getParameter("supplier"));
		} catch (Exception e) {
		}
		return product;
	}
	
	
	
	
}
