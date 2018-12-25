package com.scs.dao;

import com.scs.entity.Deploy;

//配置
public interface DeployDao {
	//保存
	int saveDeploy(Deploy deploy);
	//通过productId查询配置
	Deploy selectDeployByProductId(Integer productId);
	//修改配置
	int updateDeploy(Deploy deploy);
	//删除配置
	int deleteDeployByProductId(Integer productId);
}
