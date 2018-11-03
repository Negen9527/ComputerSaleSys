package com.scs.daoImp;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.UserDao;
import com.scs.entity.User;
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public int saveUser(User user) {
//		getHibernateTemplate().execute(new HibernateCallback<Object>() {
//
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		getHibernateTemplate().save(user);
		return 0;
	}

	@Override
	public List<User> selectAllUsers() {
		String queryString = "FROM User";
		List<User> users = (List<User>) getHibernateTemplate().find(queryString);
		for (User user : users) {
			System.out.println(user);
		}
		return null;
	}

}
