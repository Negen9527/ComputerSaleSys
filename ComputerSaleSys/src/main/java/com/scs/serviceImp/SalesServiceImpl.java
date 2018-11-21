package com.scs.serviceImp;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scs.dao.SalesDao;
import com.scs.entity.Sales;
import com.scs.service.SalesService;
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

}
