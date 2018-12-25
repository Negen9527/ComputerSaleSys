package com.scs.serviceImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scs.dao.SalesDao;
import com.scs.entity.Sales;
import com.scs.service.SalesService;
import com.scs.utils.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("salesService")
@Transactional
public class SalesServiceImpl implements SalesService{

	@Resource(name="salesDao")
	private SalesDao salesDao;
	
	
	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}



	@Override
	public int addSaveSales(Sales sales) {
		if(null != sales)
			return salesDao.saveSales(sales);
		else
			return 0;
	}



	@Override
	public JSONArray selectAllSoldNote() {
		List<Object[]> sList = (List<Object[]>) salesDao.selectAllSoldNote();
		JSONArray resultJSONArr = null;
		if(sList != null) {
			resultJSONArr = new JSONArray();
			for (Object[] object : sList) {
				Integer soldId = (Integer)object[0];
				String buyerName = (String)object[1];
				String buyerTel = (String)object[2];
				Double outPrice = (Double)object[3];
				Date salesTimes = (Date)object[4];
				Integer productId = (Integer)object[5];
				String productName = (String)object[6];
				String typeId = (String)object[7];
				JSONObject temp = new JSONObject();
				temp.put("soldId", soldId);
				temp.put("buyerName", buyerName);
				temp.put("buyerTel", buyerTel);
				temp.put("outPrice", outPrice + "元");
				temp.put("salesTimes", DateUtil.date2str(salesTimes));
				temp.put("productId", productId);
				temp.put("productName", productName);
				temp.put("typeId", typeId);
				resultJSONArr.add(temp);
			}
		}
		return resultJSONArr;
	}



	/**
	 * 	删除销售记录
	 * 
	 */
	@Override
	public int deleteSold(Integer id) {
		
		return salesDao.deleteSales(id);
	}


}
