package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.SalaryStandardDetails;
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

	//职位分类查寻
	@Override
	public List<ConfigMajorKind> getAllConfigMajorKinds() {
		List<ConfigMajorKind> list=this.baseDao.findAll(new ConfigMajorKind(), "selectAllConfigMajorKinds");
		return list;
	}
	//职位名称查寻
	@Override
	public List<ConfigMajor> getAllConfigMajors() {
		List<ConfigMajor> list=this.baseDao.findAll(new ConfigMajor(), "selectAllConfigMajors");
		return list;
	}
	
	//职称查寻
	@Override
	public List<ConfigPublicChar> getAllTechnicalTitles() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllTechnicalTitles");
		return list;
	}
	//国籍查寻
	@Override
	public List<ConfigPublicChar> getAllNationalitys() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllNationalitys");
		return list;
	}
	//民族查寻
	@Override
	public List<ConfigPublicChar> getAllNations() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllNations");
		return list;
	}
	//宗教信仰查寻
	@Override
	public List<ConfigPublicChar> getAllReligiousBeliefs() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllReligiousBeliefs");
		return list;
	}
	//政治面貌查寻
	@Override
	public List<ConfigPublicChar> getAllPoliticalStatus() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllPoliticalStatus");
		return list;
	}
	//学历查寻
	@Override
	public List<ConfigPublicChar> getAllSchooling() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllSchooling");
		return list;
	}
	//学历专业查寻
	@Override
	public List<ConfigPublicChar> getAllEducations() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllEducations");
		return list;
	}
	//薪酬标准查寻
	@Override
	public List<SalaryStandardDetails> getAllSalarys() {
		// TODO Auto-generated method stub
		return null;
	}
	//特长查寻
	@Override
	public List<ConfigPublicChar> getAllStrongPoints() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllStrongPoints");
		return list;
	}
	//爱好查寻
	@Override
	public List<ConfigPublicChar> getAllHobbys() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllHobbys");
		return list;
	}
	//教育年限
	@Override
	public List<ConfigPublicChar> getAllEducationsYears() {
		List<ConfigPublicChar> list=this.baseDao.findAll(new ConfigPublicChar(), "selectAllEducationsYears");
		return list;
	}




}
