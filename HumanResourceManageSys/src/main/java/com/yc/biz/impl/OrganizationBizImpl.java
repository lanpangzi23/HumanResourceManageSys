package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.biz.OrganizationBiz;
import com.yc.dao.BaseDao;
@Service
public class OrganizationBizImpl implements OrganizationBiz {
	private BaseDao baseDao;

	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public ConfigFileFirstKind save(ConfigFileFirstKind configFileFirstKind) {
		this.baseDao.add(configFileFirstKind, "addFirstKind");
		return configFileFirstKind;
	}


	@Override
	public ConfigFileFirstKind update(ConfigFileFirstKind configFileFirstKind) {
		this.baseDao.update(configFileFirstKind, "updateFirstKind");
		return configFileFirstKind;
	}

	//一级机构查寻
	@Override
	public List<ConfigFileFirstKind> getAllConfigFileFirstKinds() {
		List<ConfigFileFirstKind> list=this.baseDao.findAll(new ConfigFileFirstKind(), "selectAllFirstKinds");
		return list;
	}
	
	//二级机构查寻
	@Override
	public List<ConfigFileSecondKind> getAllConfigFileSecondKinds() {
		List<ConfigFileSecondKind> list=this.baseDao.findAll(new ConfigFileSecondKind(), "selectAllSecondKinds");
		return list;
	}
	//三级机构查寻
	@Override
	public List<ConfigFileThirdKind> getAllConfigFileThirdKinds() {
		List<ConfigFileThirdKind> list=this.baseDao.findAll(new ConfigFileThirdKind(), "selectAllThirdKinds");
		return list;
	}
	@Override
	public List<ConfigFileSecondKind> getAllConfigFileSecondKindsByFirst(String id) {
		List<ConfigFileSecondKind> list=this.baseDao.findAll(new ConfigFileSecondKind(), "selectAllSecondKindsByFirst");
		return list;
	}

	@Override
	public ConfigFileFirstKind deleteConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind) {
		this.baseDao.delete(configFileFirstKind, "deleteFirstKind");
		return configFileFirstKind;
	}

}
