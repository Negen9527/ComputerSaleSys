package com.scs.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.DeployDao;
import com.scs.entity.Deploy;
import com.scs.service.DeployService;

import net.sf.json.JSONObject;
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


	/**
	 * 	通过productId查询deploy
	 * 
	 */
	@Override
	public JSONObject selectDeployByProductId(Integer productId) {
		Deploy deploy =  deployDao.selectDeployByProductId(productId);
		JSONObject jsonObject = null;
		if(null != deploy) {
			jsonObject = new JSONObject();
			jsonObject.put("screenSize", deploy.getScreenSize());
			jsonObject.put("weight", deploy.getWeight());
			jsonObject.put("cpu", deploy.getCpu());
			jsonObject.put("videoCard", deploy.getVideoCard());
			jsonObject.put("ram", deploy.getRam());
			jsonObject.put("hardPan", deploy.getHardPan());
		}
		return jsonObject;
			
	}
	
}
