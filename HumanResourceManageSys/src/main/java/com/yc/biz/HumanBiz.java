package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.HumanFile;

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
	//职位名称查寻
	//职称查寻
	//国籍查寻
	//民族查寻
	//宗教信仰查寻
	//政治面貌查寻
	//学历查寻
	//学历专业查寻
	//薪酬标准查寻
	//特长查寻
	//爱好查寻
	
	//人力资源档案登记
	

}
