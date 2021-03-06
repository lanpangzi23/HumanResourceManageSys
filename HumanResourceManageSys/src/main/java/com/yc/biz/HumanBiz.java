package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.HumanFileDig;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;

public interface HumanBiz {
	//员工档案登记
	HumanFile save(HumanFile humanFile);
	//更改插入
	HumanFileDig saveHumanFileDig(HumanFileDig humanFileDig);
	//人力资源档案复核（修改）
	HumanFile updateHumanFileById(HumanFile humanFile);
	//人力资源档案更改
	HumanFile changeHumanFileById(HumanFile humanFile);
	//人力资源档案更改（复核）
	HumanFile changeHumanFileStatus(HumanFile humanFile);
	//人力资源档案删除
	HumanFile deleteHumanFile(HumanFile humanFile);
	//人力资源档案恢复
	HumanFile recoveryHumanFile(HumanFile humanFile);
	public List<HumanFile> selectHumanFileByCard(HumanFile humanFile);
	public List<HumanFile> selectHumanFileBydesignation(HumanFile humanFile);
	
	public List<HumanFile> selectHumanFileBy(HumanFile humanFile);
	//人力资源档案照片（修改）
	HumanFile updateHumanFilePictureById(HumanFile humanFile);
	//职位分类查寻
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
	//特长查寻
	List<ConfigPublicChar> getAllStrongPoints();
	//爱好查寻
	List<ConfigPublicChar> getAllHobbys();
	//教育年限查询
	List<ConfigPublicChar> getAllEducationsYears();
	//人力资源档案查寻（根据复核状态）
	public List<HumanFile> findtHumanFileByCheck(HumanFile humanFile);
	//人力资源档案查寻（根据ID）
	public List<HumanFile> selectHumanFileById(HumanFile humanFile);
	//职位分类名称（根据ID）
	public List<ConfigMajorKind> selectConfigMajorKindById(ConfigMajorKind configMajorKind);
	//职位名称查寻（根据ID）
	public List<ConfigMajor> selectConfigMajorById(ConfigMajor configMajor);
	//职位名称查寻（根据ID）
	public List<ConfigMajor> selectConfigMajorByKind(ConfigMajor configMajor);
	//薪酬标准查寻
	List<SalaryStandard> getAllSalaryStandard();
	//职位名称查寻（根据ID）
	public List<SalaryStandard> selectSalaryStandardById(SalaryStandard salaryStandard);
	
}
