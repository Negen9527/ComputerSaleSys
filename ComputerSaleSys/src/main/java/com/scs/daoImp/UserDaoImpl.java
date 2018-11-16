package com.scs.daoImp;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.scs.dao.UserDao;
import com.scs.entity.User;
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	private String hqlStr = "";
	
	
	/**
	 * 添加用户成功  （成功：1    失败：0）
	 */
	@Override
	public int saveUser(User user) {
		Integer intResult = 1;
		try {
			getHibernateTemplate().save(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			intResult = 0;
		}
		return intResult;
	}

	/**
	 * 取出所有的用户
	 * return:users
	 */
	@Override
	public List<User> selectAllUsers() {
		String queryString = "FROM User";
		List<User> users = (List<User>) getHibernateTemplate().find(queryString);
		return users;
	}

	/**
	 * 通过id修改用户信息（成功：1    失败：0）
	 */
	@Override
	public int updateUser(final User user) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					//成功
					System.out.println(user.getId());
					User cUser = session.get(User.class, user.getId());
					
					cUser.setUsername(user.getUsername());
					cUser.setSex(user.getSex());
					cUser.setBirth(user.getBirth());
					cUser.setInTime(user.getInTime());
					cUser.setAddr(user.getAddr());
					cUser.setBasicSalary(user.getBasicSalary());
					cUser.setTel(user.getTel());
					System.out.println(cUser.toString());
					session.update(cUser);
					session.flush();
					return 1;
				} catch (Exception e) {
					//失败
					e.printStackTrace();
					return 0;
				}
				
			}
		});
		
	}

	
	/**
	 * 通过id删除用户（修改用户的isDelete做逻辑删除）  （成功：1    失败：0）
	 */
	@Override
	public int deleteUser(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				try {
					hqlStr = "delete from User where id=?";
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
	 * 通过用户id查找  返回user
	 */
	@Override
	public User findUserById(Integer id) {
		
		return null;
	}

}
