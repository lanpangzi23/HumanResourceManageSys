package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;
import com.yc.dao.BaseDao;
@Service
public class HumanBizImpl implements HumanBiz {
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	//人力资源档案登记
	@Override
	public HumanFile save(HumanFile humanFile) {
		this.baseDao.add(humanFile, "saveHumanFile");
		return humanFile;
	}

	//一级机构查寻
	@Override
	public List<ConfigFileFirstKind> getAllConfigFileFirstKinds() {
		List<ConfigFileFirstKind> list=this.baseDao.findAll(new ConfigFileFirstKind(), "selectAllFirstKinds");
		return list;
	}


}
