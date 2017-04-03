package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.HumanFileDig;
import com.yc.bean.SalaryStandard;
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
		this.baseDao.update(humanFile, "updateHumanFileById");
		return humanFile;
	}

	@Override
	public HumanFile updateHumanFilePictureById(HumanFile humanFile) {
		this.baseDao.update(humanFile, "updateHumanFilePictureById");
		return humanFile;
	}

	@Override
	public List<HumanFile> selectHumanFileBy(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileBy");
		return list;
	}

	@Override
	public HumanFile changeHumanFileById(HumanFile humanFile) {
		this.baseDao.update(humanFile, "changeHumanFileById");
		return humanFile;
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public HumanFile changeHumanFileStatus(HumanFile h) {
		System.out.println(h+".................");
		HumanFileDig hd=new HumanFileDig();
		hd.setAttachment_name(h.getAttachment_name());
		hd.setHuman_id(h.getHuman_id());
		hd.setFirst_kind_id(h.getFirst_kind_id());
		hd.setFirst_kind_name(h.getFirst_kind_name());
		hd.setSecond_kind_id(h.getSecond_kind_id());
		hd.setSecond_kind_name(h.getSecond_kind_name());
		hd.setThird_kind_id(h.getThird_kind_id());
		hd.setThird_kind_name(h.getThird_kind_name());
		hd.setHuman_name(h.getHuman_name());
		hd.setHuman_address(h.getHuman_address());
		hd.setHuman_postcode(h.getHuman_postcode());
		hd.setHuman_pro_designation(h.getHuman_pro_designation());
		hd.setHuman_major_id(h.getHuman_major_id());
		hd.setHunma_major_name(h.getHunma_major_name());
		hd.setHuman_major_kind_id(h.getHuman_major_kind_id());
		hd.setHuman_major_kind_name(h.getHuman_major_kind_name());
		hd.setHuman_telephone(h.getHuman_telephone());
		hd.setHuman_mobilephone(h.getHuman_mobilephone());
		hd.setHuman_bank(h.getHuman_bank());
		hd.setHuman_account(h.getHuman_account());
		hd.setHuman_qq(h.getHuman_qq());
		hd.setHuman_email(h.getHuman_email());
		hd.setHuman_hobby(h.getHuman_hobby());
		hd.setHuman_speciality(h.getHuman_speciality());
		hd.setHuman_sex(h.getHuman_sex());
		hd.setHuman_religion(h.getHuman_religion());
		hd.setHuman_party(h.getHuman_party());
		hd.setHuman_nationality(h.getHuman_nationality());
		hd.setHuman_race(h.getHuman_race());
		hd.setHuman_birthday(h.getHuman_birthday());
		hd.setHuman_birthplace(h.getHuman_birthplace());
		hd.setHuman_age(h.getHuman_age());
		hd.setHuman_educated_degree(h.getHuman_educated_degree());
		hd.setHuman_educated_years(h.getHuman_educated_years());
		hd.setHuman_educated_major(h.getHuman_educated_major());
		hd.setHuman_society_security_id(h.getHuman_society_security_id());
		hd.setHuman_id_card(h.getHuman_id_card());
		hd.setRemark(h.getRemark());
		hd.setSalary_standard_id(h.getSalary_standard_id());
		hd.setSalary_standard_name(h.getSalary_standard_name());
		hd.setPaid_salary_sum(h.getSalary_sum());
		hd.setDemand_salaray_sum(h.getDemand_salary_sum());
		hd.setPaid_salary_sum(h.getPaid_salary_sum());
		hd.setMajor_change_amount(h.getMajor_change_amount());
		hd.setBonus_amount(h.getBonus_amount());
		hd.setTraining_amount(h.getTraining_amount());
		hd.setFile_chang_amount(h.getFile_chang_amount());
		hd.setHuman_histroy_records(h.getHuman_histroy_records());
		hd.setHuman_family_membership(h.getHuman_family_membership());
		hd.setHuman_picture(h.getHuman_picture());
		hd.setAttachment_name(h.getAttachment_name());
		hd.setCheck_status(h.getCheck_status());
		hd.setRegister(h.getRegister());
		hd.setChecker(h.getChanger());
		hd.setChanger(h.getChanger());
		hd.setRegist_time(h.getRegist_time());
		hd.setRecovery_time(h.getRecovery_time());
		hd.setChange_time(h.getChange_time());
		hd.setLastly_change_time(h.getLastly_change_time());
		hd.setDelete_time(h.getDelete_time());
		hd.setHuman_file_status(h.getHuman_file_status());
		this.baseDao.add(hd, "saveHumanFileDig");
		this.baseDao.update(h, "changeHumanFileStatus");
		return h;
	}

	@Override
	public HumanFile deleteHumanFile(HumanFile humanFile) {
		this.baseDao.update(humanFile, "deleteHumanFile");
		return humanFile;
	}

	@Override
	public HumanFile recoveryHumanFile(HumanFile humanFile) {
		this.baseDao.update(humanFile, "recoveryHumanFile");
		return humanFile;
	}

	@Override
	public List<HumanFile> selectHumanFileByCard(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileByCard");
		return list;
	}

	@Override
	public List<HumanFile> selectHumanFileBydesignation(HumanFile humanFile) {
		List<HumanFile> list=this.baseDao.findAll(humanFile, "selectHumanFileBydesignation");
		return list;
	}

	@Override
	public HumanFileDig saveHumanFileDig(HumanFileDig humanFileDig) {
		this.baseDao.add(humanFileDig, "saveHumanFileDig");
		return humanFileDig;
	}

}
