package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.SalaryStandard;
public interface OrganizationBiz {
	//一级机构添加
	ConfigFileFirstKind save(ConfigFileFirstKind configFileFirstKind);
	//一级机构删除
	ConfigFileFirstKind deleteConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);
	//一级机构修改
	ConfigFileFirstKind update(ConfigFileFirstKind configFileFirstKind);
	//一级机构查寻
	List<ConfigFileFirstKind> getAllConfigFileFirstKinds();
	//分页
	public List<ConfigFileFirstKind> findConfigFileFirstKindByPage(int minPage,int maxPage);
	public List<ConfigFileSecondKind> findConfigFileSecondKindByPage(int minPage,int maxPage);
	public List<ConfigFileThirdKind> findConfigFileThirdKindByPage(int minPage,int maxPage);
	
	
	public List<ConfigFileFirstKind> findConfigFileFirstKindByName(ConfigFileFirstKind configFileFirstKind);
		//二级机构查寻
	List<ConfigFileSecondKind> getAllConfigFileSecondKinds();
		//根据一级机构查寻二级机构
	List<ConfigFileSecondKind> getAllConfigFileSecondKindsByFirst(String id);
	//根据二级机构查寻三级机构
	List<ConfigFileThirdKind> getAllConfigFileThirdKindsBySecond(String id);
		//三级机构查寻
	List<ConfigFileThirdKind> getAllConfigFileThirdKinds();
	
	
	
	//二级机构添加
	ConfigFileSecondKind saveConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
		//二级机构删除
	ConfigFileSecondKind deleteConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
		//二级机构修改
	ConfigFileSecondKind updateConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind);
		//三级机构添加
	ConfigFileThirdKind saveConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind);
		//三级机构删除
	ConfigFileThirdKind deleteConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind);
		//三级机构修改
	ConfigFileThirdKind updateConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind);

}
