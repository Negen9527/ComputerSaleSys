package com.scs.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.ProductDao;
import com.scs.entity.Product;
@Repository("productDao")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{

	/**
	 * 新增电脑
	 */
	@Override
	public int savaProduct(Product product) {
		try {
			getHibernateTemplate().save(product);
			return product.getId();
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
	 * 更新电脑信息
	 */
	@Override
	public int update(final Product product) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

				@Override
				public Integer doInHibernate(Session session) throws HibernateException {
					Product cProduct = session.get(Product.class, product.getId());		
					cProduct.setName(product.getName());
					cProduct.setTypeId(product.getTypeId());
					cProduct.setAmount(product.getAmount());
					cProduct.setInPrice(product.getInPrice());
					cProduct.setInTime(product.getInTime());
					cProduct.setSupplier(product.getSupplier());
					session.update(cProduct);
					session.flush();
					return 1;
				}
			});
			
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


	/**
	 * 	修改产品数量
	 */
	@Override
	public int modifyAmount(final Integer id,final Integer amount) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "update Product set amount=? where id=?";
					Query query = session.createQuery(hqlStr);
					query.setInteger(0, amount);
					query.setInteger(1, id);
					return query.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
		});
		
	}


	/**
	 * 	退货增加数量
	 * 
	 */
	@Override
	public int addAmount(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					Product cProduct = session.get(Product.class, id);
					cProduct.setAmount(cProduct.getAmount() + 1);
					session.update(cProduct);
					session.flush();
					return 1;
				} catch (Exception e) {
					return 0;
				}
			}
		});
		
	}

}
