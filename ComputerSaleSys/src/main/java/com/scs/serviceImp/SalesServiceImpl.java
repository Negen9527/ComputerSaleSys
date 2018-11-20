package com.scs.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.SalesDao;
import com.scs.entity.Sales;
import com.scs.service.SalesService;
@Service("salesService")
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

}
