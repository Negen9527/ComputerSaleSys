package com.scs.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.SalesDao;
import com.scs.entity.Sales;
@Repository("salesDao")
public class SalesDaoImpl extends HibernateDaoSupport implements SalesDao{
	private String hqlStr = ""; 
	/**
	 * 保存销售记录
	 */
	@Override
	public int saveSales(Sales sales) {
		try {
			getHibernateTemplate().save(sales);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	
	/**
	 * 删除销售记录
	 */
	@Override
	public int deleteSales(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					hqlStr = "delete from Sales where id=?";
					Query query = session.createQuery(hqlStr);
					query.setInteger(0, id);
					return query.executeUpdate();
				} catch (Exception e) {
					return 0;
				}
				
			}
			
		});
		
	}

	
	/**
	 * 查看销售记录
	 */
	@Override
	public List<Sales> selectAllSales() {
		hqlStr = "from Sales";
		@SuppressWarnings("unchecked")
		List<Sales> saless = (List<Sales>) getHibernateTemplate().find(hqlStr);
		return saless;
	}

}
