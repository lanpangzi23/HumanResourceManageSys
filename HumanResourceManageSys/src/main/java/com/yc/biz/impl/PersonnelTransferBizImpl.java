package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.HumanFile;
import com.yc.bean.MajorChange;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.PersonnelTransferBiz;
import com.yc.dao.BaseDao;
import com.yc.dao.impl.BaseDaoMybatisImpl;
@Repository
public class PersonnelTransferBizImpl implements PersonnelTransferBiz {
	private BaseDao baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDaoMybatisImpl baseDao) {
		this.baseDaoMybatisImpl =baseDao ;
	}
	@Override//根据机构，姓名等查找需要调动的人的信息
	public List<HumanFile> findPersonnel(HumanFile humanfile) {
		
		List <HumanFile> list=this.baseDaoMybatisImpl.findAll(humanfile,  "selectPersonInfo");
		return list;
	}
	//一级机构查寻
	@Override
	public List<ConfigFileFirstKind> getAllConfigFileFirstKinds() {
		ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
		List<ConfigFileFirstKind> list=this.baseDaoMybatisImpl.findAll(configFileFirstKind, "selectAllFirstKinds");
		return list;
	}
	//根据一级机构的编号查询二级机构
	@Override
	public List<ConfigFileSecondKind> getAllConfigFileSecondKinds(ConfigFileSecondKind configFileSecondKind) {
		List<ConfigFileSecondKind> list=this.baseDaoMybatisImpl.findAll(configFileSecondKind, "selectAllSecondKindsByFirst");
		return list;
	}
	//根据二级编号查询三级机构
	@Override
	public List<ConfigFileThirdKind> getAllConfigFileThirdKinds(ConfigFileThirdKind configFileThirdKind) {
		List<ConfigFileThirdKind> list=this.baseDaoMybatisImpl.findAll(configFileThirdKind, "selectAllThirdKindsBySecond");
		return list;
	}
	//根据三级机构编号查询职位分类
	@Override
	public List<ConfigMajorKind> getAllConfigMajorKinds() {
		ConfigMajorKind configMajorKind=new ConfigMajorKind();
		List <ConfigMajorKind> list=this.baseDaoMybatisImpl.findAll(configMajorKind, "selectAllConfigMajorKinds");
		return list;
	}
	//根据职位分类编号查询职位名称
	@Override
	public List<ConfigMajor> getAllConfigMajors(ConfigMajor configMajor) {
		List<ConfigMajor> list=this.baseDaoMybatisImpl.findAll(configMajor, "selectAllConfigMajorsById");
		return list;
	}
	//简答的人力资源查询
	@Override
	public List<HumanFile> findAll(HumanFile humanfile) {
		// TODO Auto-generated method stub

		List<HumanFile> list=baseDaoMybatisImpl.findAll(humanfile, "selectAllPerson");
		return list;
		
	}
	//根据id查找详情
		public List<HumanFile> findPersonDetails(String id){
			HumanFile hf=new HumanFile();
			List<HumanFile> list=new ArrayList<>();
			hf.setHuman_id(id);
			List<HumanFile> salaryStandard=baseDaoMybatisImpl.findAll(hf, "selectTransferDetails");
			list.add(salaryStandard.get(0));
			return list;
		}
		@Override
		public boolean toCommit(MajorChange majorChange) {
			
				this.baseDaoMybatisImpl.add(majorChange, "commit");
			
			return true;
		}
		@Override
		public List<SalaryStandard> getAllSalaryStandard() {
			SalaryStandard salaryStandard=new SalaryStandard();
			List <SalaryStandard> list=this.baseDaoMybatisImpl.findAll(salaryStandard, "selectSalaryStandard");
			return list;
		}
		@Override
		public List<MajorChange> findAudit(MajorChange majorChange) {
			List<MajorChange> list=this.baseDaoMybatisImpl.findAll(majorChange, "selectAll");
			return list;
		}
		@Override
		public List<MajorChange> findAuditDetails(String id) {
			MajorChange majorChange=new MajorChange();
			majorChange.setHuman_id(id);
			List<MajorChange> list=this.baseDaoMybatisImpl.findAll(majorChange, "selectChangeDetails");
			return list;
		}
		@Override
		public boolean updateStatus(MajorChange majorChange) {
			this.baseDaoMybatisImpl.update(majorChange, "auditsuccess");
			return true;
		}
		@Override
		public boolean updateMajorStatus(MajorChange majorChange) {
			this.baseDaoMybatisImpl.update(majorChange, "auditStatusChange");		
			return true;
		}
		@Override
		public List<MajorChange> selectAgain(MajorChange majorChange) {
			List<MajorChange> list=this.baseDaoMybatisImpl.findAll(majorChange, "selectAgain");
			return list;
		}
		@Override
		public boolean updateFail(MajorChange majorChange) {
			this.baseDaoMybatisImpl.update(majorChange, "auditFail");
			return true;
		}
	


}
