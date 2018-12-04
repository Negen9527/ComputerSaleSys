package com.scs.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.LoginDao;
import com.scs.entity.Admin;
@Repository("loginDao")
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao{

	@Override
	public Integer logon(final Admin admin) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hqlStr = "from Admin a where a.username=? and a.password=?";
				Query query = session.createQuery(hqlStr);
				query.setString(0, admin.getUsername());
				query.setString(1, admin.getPassword());		
				List result = query.list();
				return result.size();
			}
		});
		
	}

}
