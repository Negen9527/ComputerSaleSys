package com.scs.serviceImp;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.scs.utils.DateUtil;

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
		Map<Integer, Object[]> salaryMap = new HashMap<Integer, Object[]>();
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
				Object[] item = {reward,count};
				salaryMap.put(userId, item);
			}
		}
		
		Set<Integer> basicKeys = basicSalaryMap.keySet();
		for (Integer basicKey : basicKeys) {
			Integer userId = basicSalaryMap.get(basicKey).getId();
			String name = basicSalaryMap.get(basicKey).getUsername();
			Double basicSalary = basicSalaryMap.get(basicKey).getBasicSalary();
			Date inTime = basicSalaryMap.get(basicKey).getInTime();
			String inTimeStr = DateUtil.date2str(inTime).replaceAll("-", "").substring(0, 6);
			if(Integer.parseInt(inTimeStr) < Integer.parseInt(month)) {
				JSONObject temp = new JSONObject();
				temp.put("userId", userId);
				temp.put("name", name);
				temp.put("basicSalary", basicSalary);
				temp.put("salary", basicSalary);
				temp.put("soldCount","0");
				Object[] objects = salaryMap.get(basicKey);
				DecimalFormat dFormat = new DecimalFormat(".00");
				if(null != objects) {
					temp.put("salary",dFormat.format(objects[0]));
					temp.put("soldCount", objects[1]);
				}
				resltArr.add(temp);
			}

		}
		return resltArr;
	}



	/**
	 * 	查询个人薪资单
	 */
	@Override
	public JSONObject selectOneByMonth(Integer userId, String month) {
		JSONObject resultJSON = null;
		List<Object[]> rList = (List<Object[]>)salaryDao.selectOneByMonth(userId, month);
		if(null != rList.get(0)[0]) {
			Object[] object = rList.get(0);
			Integer userID = (Integer)object[0];
			String userName = (String)object[1];
			Double basicSalary = (Double)object[2];
			Date inTime = (Date)object[3];
			Double total = (Double)object[4];
			BigInteger count = (BigInteger)object[5];
			
			resultJSON = new JSONObject();
			String inTimeStr = DateUtil.date2str(inTime).replaceAll("-", "").substring(0, 6);
			System.out.println(Integer.parseInt(inTimeStr));
			System.out.println(Integer.parseInt(month));
			if(Integer.parseInt(inTimeStr) > Integer.parseInt(month)) {
				//未入职
			}else {
				//入职后
				resultJSON.put("userName", userName);
				resultJSON.put("basicSalary", basicSalary);
				resultJSON.put("count", count);
				resultJSON.put("total", total*0.3 + basicSalary);
			}
			
		}
		return resultJSON;
	}

}
