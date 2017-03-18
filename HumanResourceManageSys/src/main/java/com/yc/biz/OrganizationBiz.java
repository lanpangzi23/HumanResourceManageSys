package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
public interface OrganizationBiz {
	//一级机构添加
	ConfigFileFirstKind save(ConfigFileFirstKind configFileFirstKind);
	//一级机构删除
	ConfigFileFirstKind deleteConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);
	//一级机构修改
	ConfigFileFirstKind update(ConfigFileFirstKind configFileFirstKind);
	//一级机构查寻
	List<ConfigFileFirstKind> getAllConfigFileFirstKinds();
		//二级机构查寻
	List<ConfigFileSecondKind> getAllConfigFileSecondKinds();
		//
	List<ConfigFileSecondKind> getAllConfigFileSecondKindsByFirst(String id);
		//三级机构查寻
	List<ConfigFileThirdKind> getAllConfigFileThirdKinds();

}
