package com.scs.service;

import com.scs.entity.Deploy;
import com.scs.entity.Product;

public interface DeployService {
	
	//新增配置
	int addDeploy(Deploy deploy);
	
	//删除配置
	int deleteDeploy(Integer productId);
	
}
