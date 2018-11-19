package com.scs.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.JSONResult;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.service.DeployService;

import net.sf.json.JSONObject;

@ParentPackage("json-default")
@Namespace(value = "/")
public class DeployAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonData = new JSONObject();
	
	
	
	@Resource(name="deployService")
	private DeployService deployService;

	public void setDeployService(DeployService deployService) {
		this.deployService = deployService;
	}
	



	public JSONObject getJsonData() {
		return jsonData;
	}




	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}




	@Action(value="/detailDeploy",
			results = {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String detailDeploy() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		JSONObject tempJSON = deployService.selectDeployByProductId(productId);
		System.out.println(tempJSON);
		this.setJsonData(tempJSON);
		return SUCCESS;
	}
	
	
	
}
