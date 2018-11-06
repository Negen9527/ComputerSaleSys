package com.scs.daoImp;

import java.io.Serializable;
import java.util.List;

import com.scs.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partUpdate(int id, String[] names, Object values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> queryPage(String hql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
