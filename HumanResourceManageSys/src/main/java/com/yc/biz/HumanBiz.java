package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.SalaryStandardDetails;

public interface HumanBiz {
	//员工档案登记
	HumanFile save(HumanFile book);
	//一级机构查寻
	List<ConfigFileFirstKind> getAllConfigFileFirstKinds();
	//二级机构查寻
	List<ConfigFileSecondKind> getAllConfigFileSecondKinds();
	//三级机构查寻
	List<ConfigFileThirdKind> getAllConfigFileThirdKinds();
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
	//薪酬标准查寻
	List<SalaryStandardDetails> getAllSalarys();
	//特长查寻
	List<ConfigPublicChar> getAllStrongPoints();
	//爱好查寻
	List<ConfigPublicChar> getAllHobbys();
	//教育年限查询
	List<ConfigPublicChar> getAllEducationsYears();
	//人力资源档案登记
	

}
