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
import com.yc.bean.SalaryStandard;
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

	@Override
	public List<HumanFile> findtHumanFileByCheck(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileByCheck");
		return list;
	}

	@Override
	public List<HumanFile> selectHumanFileById(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileById");
		return list;
	}

	@Override
	public List<ConfigMajorKind> selectConfigMajorKindById(ConfigMajorKind configMajorKind) {
		List<ConfigMajorKind> list=this.baseDao.findAll(configMajorKind, "selectAllConfigMajorKindBy");
		return list;
	}

	@Override
	public List<ConfigMajor> selectConfigMajorById(ConfigMajor configMajor) {
		List<ConfigMajor> list=this.baseDao.findAll(configMajor, "selectAllConfigMajorBy");
		return list;
	}

	@Override
	public List<ConfigMajor> selectConfigMajorByKind(ConfigMajor configMajor) {
		List<ConfigMajor> list=this.baseDao.findAll(configMajor, "selectAllConfigMajorBy");
		return list;
	}

	@Override
	public List<SalaryStandard> getAllSalaryStandard() {
		List<SalaryStandard> list=this.baseDao.findAll(new SalaryStandard(), "selectSalaryStandard");
		return list;
	}

	@Override
	public List<SalaryStandard> selectSalaryStandardById(SalaryStandard salaryStandard) {
		List<SalaryStandard> list=this.baseDao.findAll(salaryStandard, "selectSalaryStandard");
		return list;
	}

	@Override
	public HumanFile updateHumanFileById(HumanFile humanFile) {
		this.baseDao.add(humanFile, "updateHumanFileById");
		return humanFile;
	}

	@Override
	public HumanFile updateHumanFilePictureById(HumanFile humanFile) {
		this.baseDao.add(humanFile, "updateHumanFilePictureById");
		return humanFile;
	}

	@Override
	public List<HumanFile> selectHumanFileBy(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileBy");
		return list;
	}

	@Override
	public HumanFile changeHumanFileById(HumanFile humanFile) {
		this.baseDao.add(humanFile, "changeHumanFileById");
		return humanFile;
	}

	@Override
	public HumanFile changeHumanFileStatus(HumanFile humanFile) {
		this.baseDao.add(humanFile, "changeHumanFileStatus");
		return humanFile;
	}

	@Override
	public HumanFile deleteHumanFile(HumanFile humanFile) {
		this.baseDao.add(humanFile, "deleteHumanFile");
		return humanFile;
	}

	@Override
	public HumanFile recoveryHumanFile(HumanFile humanFile) {
		this.baseDao.add(humanFile, "recoveryHumanFile");
		return humanFile;
	}

}
