package com.scs.serviceImp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scs.dao.SalaryDao;
import com.scs.dao.UserDao;
import com.scs.entity.User;
import com.scs.service.SalaryService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("salaryService")
@Transactional
public class SalaryServiceImpl implements SalaryService{
	@Resource(name = "salaryDao")
	private SalaryDao salaryDao;
	
	@Resource(name = "userDao")
	private UserDao userDao;
	
	
	public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}

	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	/**
	 * 	某月所有的薪资
	 * 
	 */
	@Override
	public JSONArray selectAllSalaryByMonth(String month) {
		JSONArray resltArr = new JSONArray();
		List<User> users = userDao.selectAllUsers();
		Map<Integer, User> salaryMap = new HashMap<Integer, User>();
		if(null != users) {
			for (User user : users) {
				salaryMap.put(user.getId(), user);
				
			}
			
		}
		
		List<Object[]> rList = (List<Object[]>)salaryDao.selectAllByMonth(month);
		if(null != rList) {
			for (Object[] row : rList) {
				Integer userId = (Integer)row[0];
				String username = (String)row[1];
				Double total = (Double)row[2];
				Integer count = (Integer)row[3];
				salaryMap.get(userId).setBasicSalary(salaryMap.get(userId).getBasicSalary() + total*0.3);
			}
		}
		
		Set<Integer> keys = salaryMap.keySet();
		for (Integer key : keys) {
			String name = salaryMap.get(key).getUsername();
			Double salary = salaryMap.get(key).getBasicSalary();
			JSONObject temp = new JSONObject();
			temp.put("name", name);
			temp.put("salary", salary);
			resltArr.add(temp);
		}
		System.out.println(resltArr.toString());
		return null;
	}

}
