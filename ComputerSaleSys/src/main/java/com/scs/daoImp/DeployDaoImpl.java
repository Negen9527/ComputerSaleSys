package com.scs.daoImp;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.scs.dao.DeployDao;
import com.scs.entity.Deploy;

public class DeployDaoImpl extends HibernateDaoSupport implements DeployDao{

	/**
	 * 保存配置
	 */
	@Override
	public int saveDeploy(Deploy deploy) {
		try {
			getHibernateTemplate().save(deploy);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	
	/**
	 * 修改配置
	 */
	@Override
	public Deploy selectDeployByProductId(final Integer productId) {
		return getHibernateTemplate().execute(new HibernateCallback<Deploy>() {
			
			@Override
			public Deploy doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "from Deploy where productId=?";
					Query query = session.createQuery(hqlStr);
					query.setInteger(0, productId);
					return (Deploy) query.list().get(0);
				} catch (Exception e) {
					return null;
				}
			}
		});
		
	}


	@Override
	public int updateDeploy(final Deploy deploy) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					String hqlStr = "update deploy set screenSize=?,"
							+ "weight=?,"
							+ "cpu=?,"
							+ "videoCard=?,"
							+ "ram=?,"
							+ "hardPan=? where productId=?";	
					Query query = session.createQuery(hqlStr);
					query.setString(0, deploy.getScreenSize());
					query.setDouble(1, deploy.getWeight());
					query.setString(2, deploy.getCpu());
					query.setString(3, deploy.getVideoCard());
					query.setString(4, deploy.getRam());
					query.setString(5, deploy.getHardPan());
					query.setInteger(6, deploy.getProductId());
					return query.executeUpdate();
				} catch (Exception e) {
					return 0;
				}
				
			}
		});
	}

}
