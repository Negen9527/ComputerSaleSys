package com.scs.daoImp;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.SalaryDao;
import com.scs.entity.User;
@Repository("salaryDao")
public class SalaryDaoImpl extends HibernateDaoSupport implements SalaryDao{

	@Override
	public Object selectAllByMonth(final String yearAndMonth) {
		return getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				try {
					String sqlStr = "SELECT\r\n" + 
							"user.id AS userId,user.username AS username,SUM(sales.outPrice) AS total,COUNT(sales.outPrice) AS COUNT\r\n" + 
							"FROM\r\n" + 
							"    db_computer_sale.product\r\n" + 
							"    INNER JOIN db_computer_sale.sales\r\n" + 
							"        ON (product.id = sales.productId)\r\n" + 
							"    INNER JOIN db_computer_sale.user \r\n" + 
							"        ON (user.id = sales.salesManId)\r\n" + 
							"    WHERE DATE_FORMAT(sales.salesTime, '%Y%m')='"+yearAndMonth+"' GROUP BY user.username ORDER BY total DESC ";
					Query query = session.createSQLQuery(sqlStr);
//					query.setString(0, yearAndMonth);
					return query.list();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}

	
	/**
	 * 	查询个人工资情况
	 * @param userId 用户id
	 * @param yearAndMonth 年月
	 */
	@Override
	public Object selectOneByMonth(final Integer userId, final String yearAndMonth) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException {
					String sqlStr = "SELECT\r\n" + 
							"user.id,user.username,user.basicSalary,user.inTime,SUM(sales.outPrice) AS total,COUNT(*) AS _count\r\n" + 
							"FROM\r\n" + 
							"    db_computer_sale.sales\r\n" + 
							"    INNER JOIN db_computer_sale.user \r\n" + 
							"        ON (sales.salesManId = user.id)\r\n" + 
							"        WHERE user.id=? AND DATE_FORMAT(sales.salesTime,'%Y%m')=?;";
					Query query = session.createSQLQuery(sqlStr);
					query.setInteger(0, userId);
					query.setString(1, yearAndMonth);
					return query.list();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
