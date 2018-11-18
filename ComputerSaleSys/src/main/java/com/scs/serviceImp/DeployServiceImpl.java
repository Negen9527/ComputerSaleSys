package com.scs.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.DeployDao;
import com.scs.entity.Deploy;
import com.scs.service.DeployService;
@Service("deployService")
public class DeployServiceImpl implements DeployService{
	@Resource(name = "deployDao")
	private DeployDao deployDao;
	
	public void setDeployDao(DeployDao deployDao) {
		this.deployDao = deployDao;
	}


	@Override
	public int addDeploy(Deploy deploy) {
		if(null != deploy)
			return deployDao.saveDeploy(deploy);
		else
			return 0;
	}


	/**
	 * 	删除配置
	 */
	@Override
	public int deleteDeploy(Integer productId) {
		if(productId > 0) 
			return deployDao.deleteDeployByProductId(productId);
		else
			return 0;
	}
	
}
