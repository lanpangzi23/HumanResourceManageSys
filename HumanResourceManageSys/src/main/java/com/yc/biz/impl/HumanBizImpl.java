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
	/*//二级机构查寻
	List<ConfigFileSecondKind> getAllConfigFileSecondKinds();
	
	List<ConfigFileThirdKind> getAllConfigFileThirdKinds();
	
	List<ConfigMajorKind> getAllConfigMajorKinds();
	//职位名称查寻
	List<ConfigMajor> getAllConfigMajors();
	//职称查寻

	List<ConfigPublicChar> getAllTechnicalTitles();
	//国籍查寻
	List<ConfigPublicChar> getAllNationalitys();
	//民族查寻
	List<ConfigPublicChar> getAllNations();
	//宗教信仰查寻
	List<ConfigPublicChar> getAllReligiousBeliefs();
	//政治面貌查寻
	List<ConfigPublicChar> getAllPoliticalStatus();
	//学历查寻
	List<ConfigPublicChar> getAllSchooling();
	//学历专业查寻
	List<ConfigPublicChar> getAllEducations();
	//薪酬标准查寻
	List<ConfigPublicChar> getAllSalarys();
	//特长查寻
	List<ConfigPublicChar> getAllStrongPoints();
	//爱好查寻
	List<ConfigPublicChar> getAllHobbys();
	
	//人力资源档案登记
	*/
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
	//职位分类查寻
	@Override
	public List<ConfigMajorKind> getAllConfigMajorKinds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigMajor> getAllConfigMajors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllTechnicalTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllNationalitys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllNations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllReligiousBeliefs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllPoliticalStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllSchooling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllEducations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllSalarys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllStrongPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigPublicChar> getAllHobbys() {
		// TODO Auto-generated method stub
		return null;
	}


}
