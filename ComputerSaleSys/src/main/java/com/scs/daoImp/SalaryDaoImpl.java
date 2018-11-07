package com.scs.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.scs.dao.SalaryDao;
import com.scs.entity.Salary;

public class SalaryDaoImpl extends HibernateDaoSupport implements SalaryDao{
	private String hqlStr = "from Salary";
	
	/**
	 * 新增薪资
	 */
	@Override
	public int saveSalary(Salary salary) {
		try {
			getHibernateTemplate().save(salary);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	/**
	 * 取出所有薪资
	 */
	@Override
	public List<Salary> selectAllSalary() {
		List<Salary> salaries = (List<Salary>) getHibernateTemplate().find(hqlStr);
		return salaries;
	}

	
	/**
	 * 通过id 取出某个用户的薪资单
	 */
	@Override
	public Salary findSalaryById(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<Salary>() {
			@Override
			public Salary doInHibernate(Session session) throws HibernateException {
				hqlStr = "from Salary where id=?";
				Salary salary = null;
				Query query = session.createQuery(hqlStr);
				query.setInteger(0, id);
				List temp = query.list();
				if(temp != null) {
					salary = (Salary)temp.get(0);
				}
				return salary;
			}
		});
		
	}

}
