package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.HumanFile;
import com.yc.bean.MajorChange;
import com.yc.bean.SalaryStandard;

public interface PersonnelTransferBiz {
	//根据机构等查找需要调动的人
	List<HumanFile> findPersonnel(HumanFile humanfile);
	//一级机构查寻
	List<ConfigFileFirstKind> getAllConfigFileFirstKinds();
	//根据一级机构的编号查询二级机构
	List<ConfigFileSecondKind> getAllConfigFileSecondKinds(ConfigFileSecondKind id );
	//根据二级编号查询三级机构
	List<ConfigFileThirdKind> getAllConfigFileThirdKinds(ConfigFileThirdKind id);
	//根据三级机构编号查询职位分类
	List<ConfigMajorKind> getAllConfigMajorKinds();
	//根据职位分类编号查询职位名称
	List<ConfigMajor> getAllConfigMajors(ConfigMajor configMajor);
	//查找薪酬基本标准
	List<SalaryStandard> getAllSalaryStandard();
	//简单的人力资源分页查询
	List <HumanFile> findAll(HumanFile humanfile);
	//根据id查找详情
	List<HumanFile> findPersonDetails(String id);
	//提交调动信息
	boolean toCommit(MajorChange majorChange);
	//查询调动信息
	List<MajorChange> findAudit(MajorChange majorChange);
	//根据id查找调动信息详情
	List<MajorChange> findAuditDetails(String id);
	//通过审核
	boolean updateStatus(MajorChange majorChange);
	//将majorChange里的表的状态改为1
	boolean updateMajorStatus(MajorChange majorChange);
	//防重复提交
	List<MajorChange> selectAgain(MajorChange majorChange);
	//未通过
	boolean updateFail(MajorChange majorChange);
}

