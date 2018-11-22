package com.scs.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.service.SalaryService;

import net.sf.json.JSONArray;

@ParentPackage("json-default")
@Namespace("/")
public class SalaryAction extends ActionSupport{
	private JSONArray jsonArrData = new JSONArray();
	@Resource(name = "salaryService")
	private SalaryService salaryService;

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	
	
	
	
	public JSONArray getJsonArrData() {
		return jsonArrData;
	}




	public void setJsonArrData(JSONArray jsonArrData) {
		this.jsonArrData = jsonArrData;
	}



	/**
	 * 	某月份所有员工的工资
	 * @return
	 */
	@Action(value = "allSalaryByMonth",
			results = {
					@Result(type="json",params= {"root","jsonArrData"})
			})
	public String allSalaryByMonth() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String yearAndMonth = request.getParameter("yearAndMonth");
		this.setJsonArrData(salaryService.selectAllSalaryByMonth(yearAndMonth));;
		return SUCCESS;
	}
	
	
}
