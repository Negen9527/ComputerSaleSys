package com.scs.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	//保存
	void save(T entity);
	//更新对象
	void update(T entity);
	//更新对象属性
	void partUpdate(int id, String[] names,Object values);
	//删除对象
	void delete(Serializable id);
	//根据id查找一个对象
	T findById(Serializable id);
	//根据hql返回对象list
	List<T> findByHQL(String hql,Object... params);
	//分页查询
	List<T> queryPage(String hql,int pageNo, int pageSize);
}
