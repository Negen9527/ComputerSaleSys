package com.scs.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.scs.dao.ProductDao;
import com.scs.entity.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{

	/**
	 * 新增电脑
	 */
	@Override
	public int savaProduct(Product product) {
		try {
			getHibernateTemplate().save(product);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	
	/**
	 * 所有电脑
	 */
	@Override
	public List<Product> selectAllProduct() {
		List<Product> products = (List<Product>) getHibernateTemplate().find("from Product");
		return products;
	}

	
	/**
	 * 更新信息
	 */
	@Override
	public int update(Product product) {
		try {
			getHibernateTemplate().update(product);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	
	/**
	 * 删除电脑信息
	 */
	@Override
	public int delete(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "delete from Product where id=?";
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
	 * 统计页数
	 */
	@Override
	public int totalPages() {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "select count(*) from product";
					Query query = session.createQuery(hqlStr);
					return (Integer)query.uniqueResult();
				} catch (Exception e) {
					return 0;
				}
			}
		});
	}
	
	
	/**
	 * 分页查询
	 */
	@Override
	public List<Product> selectProductByPageNum(final Integer pageNum, final Integer pageSize) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "from product order by id desc";
					Query query = session.createQuery(hqlStr);
					query.setFirstResult(pageNum);
					query.setMaxResults(pageSize);
					return query.list();
				} catch (Exception e) {
					return null;
				}
				
			}
		});
		
	}

}
