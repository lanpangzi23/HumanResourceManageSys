package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.SalaryStandard;
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
		ConfigFileSecondKind configFileSecondKind=new ConfigFileSecondKind();
		configFileSecondKind.setFirst_kind_id(id);
		List<ConfigFileSecondKind> list=this.baseDao.findAll(configFileSecondKind, "selectAllSecondKindsByFirst");
		return list;
	}

	@Override
	public ConfigFileFirstKind deleteConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind) {
		this.baseDao.delete(configFileFirstKind, "deleteFirstKind");
		return configFileFirstKind;
	}

	@Override
	public List<ConfigFileFirstKind> findConfigFileFirstKindByPage(int minPage, int maxPage) {
		ConfigFileFirstKind ss=new ConfigFileFirstKind();
		ss.setMaxPage(maxPage);
		ss.setMinPage(minPage);
		List<ConfigFileFirstKind> list=this.baseDao.findAll(ss, "selectAllFirstKinds");
		return list;
	}

	@Override
	public List<ConfigFileFirstKind> findConfigFileFirstKindByName(ConfigFileFirstKind configFileFirstKind) {
		List<ConfigFileFirstKind> list=this.baseDao.findAll(configFileFirstKind, "selectFirstKindByName");
		return list;
	}

	@Override
	public List<ConfigFileThirdKind> getAllConfigFileThirdKindsBySecond(String id) {
		ConfigFileThirdKind ss=new ConfigFileThirdKind();
		ss.setSecond_kind_id(id);
		List<ConfigFileThirdKind> list=this.baseDao.findAll(ss, "selectThirdKindBySecond");
		return list;
	}

	@Override
	public ConfigFileSecondKind saveConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind) {
		this.baseDao.add(configFileSecondKind, "addSecondKind");
		return configFileSecondKind;
	}


	@Override
	public List<ConfigFileSecondKind> findConfigFileSecondKindByPage(int minPage, int maxPage) {
		ConfigFileSecondKind ss=new ConfigFileSecondKind();
		ss.setMaxPage(maxPage);
		ss.setMinPage(minPage);
		List<ConfigFileSecondKind> list=this.baseDao.findAll(ss, "selectAllSecondKinds");
		return list;
	}

	@Override
	public List<ConfigFileThirdKind> findConfigFileThirdKindByPage(int minPage, int maxPage) {
		ConfigFileThirdKind ss=new ConfigFileThirdKind();
		ss.setMaxPage(maxPage);
		ss.setMinPage(minPage);
		List<ConfigFileThirdKind> list=this.baseDao.findAll(ss, "selectAllThirdKinds");
		return list;
	}

	@Override
	public ConfigFileSecondKind deleteConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind) {
		this.baseDao.delete(configFileSecondKind, "deleteSecondKind");
		return configFileSecondKind;
	}

	@Override
	public ConfigFileSecondKind updateConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind) {
		this.baseDao.update(configFileSecondKind, "updateSecondKind");
		return configFileSecondKind;
	}

	@Override
	public ConfigFileThirdKind saveConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind) {
		this.baseDao.add(configFileThirdKind, "addThirdKind");
		return configFileThirdKind;
	}

	@Override
	public ConfigFileThirdKind deleteConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind) {
		this.baseDao.delete(configFileThirdKind, "deleteThirdKind");
		return configFileThirdKind;
	}

	@Override
	public ConfigFileThirdKind updateConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind) {
		this.baseDao.update(configFileThirdKind, "updateThirdKind");
		return configFileThirdKind;
	}

	@Override
	public List<ConfigFileSecondKind> findConfigFileSecondKindByName(ConfigFileSecondKind configFileSecondKind) {
		List<ConfigFileSecondKind> list=this.baseDao.findAll(configFileSecondKind, "selectSecondKindByName");
		return list;
	}

	@Override
	public List<ConfigFileThirdKind> findConfigFileThirdKindByName(ConfigFileThirdKind configFileThirdKind) {
		List<ConfigFileThirdKind> list=this.baseDao.findAll(configFileThirdKind, "selectThirdKindByName");
		return list;
	}


}
