package com.scs.serviceImp;

import java.math.BigInteger;
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
		Map<Integer, User> basicSalaryMap = new HashMap<Integer, User>();
		Map<Integer, Double> salaryMap = new HashMap<Integer, Double>();
		if(null != users) {
			for (User user : users) {
				basicSalaryMap.put(user.getId(), user);
			}
			
		}
		
		List<Object[]> rList = (List<Object[]>)salaryDao.selectAllByMonth(month);
		if(null != rList) {
			for (Object[] row : rList) {
				Integer userId = (Integer)row[0];
				String username = (String)row[1];
				Double total = (Double)row[2];
				BigInteger count = (BigInteger)row[3];
				User tUser = basicSalaryMap.get(userId);
				Double reward = tUser.getBasicSalary() + 0.3*total;
				salaryMap.put(userId, reward);
			}
		}
		
		Set<Integer> basicKeys = basicSalaryMap.keySet();
		for (Integer basicKey : basicKeys) {
			String name = basicSalaryMap.get(basicKey).getUsername();
			Double basicSalary = basicSalaryMap.get(basicKey).getBasicSalary();
			JSONObject temp = new JSONObject();
			temp.put("name", name);
			temp.put("basicSalary", basicSalary);
			temp.put("salary", basicSalary);
			Double t = salaryMap.get(basicKey);
			if(null != t) {
				temp.put("salary", t);
			}
			resltArr.add(temp);
		}
		return resltArr;
	}

}
