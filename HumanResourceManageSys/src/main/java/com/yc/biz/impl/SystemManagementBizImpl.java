package com.yc.biz.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.ConfigQuestionFirstKind;
import com.yc.bean.ConfigQuestionSecondKind;
import com.yc.biz.SystemManagementBiz;
import com.yc.dao.BaseDao;
import com.yc.web.utils.UUIDUtil;
@Repository
public class SystemManagementBizImpl implements SystemManagementBiz{
	private BaseDao baseDaoMybatisImpl;
	ConfigPublicChar cpc=new ConfigPublicChar();
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	public List<ConfigPublicChar> findSalaryProjectName() {
		cpc.setAttribute_kind("薪酬設置");
		return baseDaoMybatisImpl.findAll(cpc, "selectConfigPublicChar");
	}
	public boolean updateSalaryProjectName(int pbc_id,String attribute_name) {
		cpc.setPbc_id(pbc_id);
		cpc.setAttribute_name(attribute_name);
		try{
			baseDaoMybatisImpl.update(cpc, "updateConfigPublicChar");
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		return true;
	}
	public void deleteSalaryProjectName(int pbc_id) {
		cpc.setPbc_id(pbc_id);
		baseDaoMybatisImpl.delete(cpc, "deleteConfigPublicChar");
	}
	public boolean addSalaryProjectName(String attribute_name) {
		cpc.setAttribute_kind("薪酬設置");
		cpc.setAttribute_name(attribute_name);
		try{
			baseDaoMybatisImpl.add(cpc, "addConfigPublicChar");
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		return true;
	}
	public List<ConfigQuestionFirstKind> findByPage(Integer page, Integer size) {
		ConfigQuestionFirstKind cqfk=new ConfigQuestionFirstKind();
		cqfk.setPage(page);
		cqfk.setSize(size);
		List<ConfigQuestionFirstKind> list=baseDaoMybatisImpl.findAll(cqfk, "selectConfigQuestionFirstKind");
		return list;
	}
	public void addConfigQuestionFirstKind(String name) {
		ConfigQuestionFirstKind cqfk=new ConfigQuestionFirstKind();
		cqfk.setFirst_kind_id(UUIDUtil.getASIC());
		cqfk.setFirst_kind_name(name);
		baseDaoMybatisImpl.add(cqfk, "addConfigQuestionFirstKind");
	}
	public void deleteConfigQuestionFirstKind(String id) {
		ConfigQuestionFirstKind cqfk=new ConfigQuestionFirstKind();
		cqfk.setFirst_kind_id(id);
		baseDaoMybatisImpl.delete(cqfk, "deleteConfigQuestionFirstKind");
	}
	public void updateConfigQuestionFirstKind(String id, String name) {
		ConfigQuestionFirstKind cqfk=new ConfigQuestionFirstKind();
		cqfk.setFirst_kind_id(id);
		cqfk.setFirst_kind_name(name);
		baseDaoMybatisImpl.update(cqfk, "updateConfigQuestionFirstKind");
	}
	public List<ConfigQuestionSecondKind> findByPageSecond(Integer page, Integer size,String id) {
		ConfigQuestionSecondKind cqfk=new ConfigQuestionSecondKind();
		cqfk.setPage(page);
		cqfk.setSize(size);
		cqfk.setFirst_kind_id(id);
		List<ConfigQuestionSecondKind> list=baseDaoMybatisImpl.findAll(cqfk, "selectConfigQuestionSecondKind");
		return list;
	}
	public void addConfigQuestionSecondKind(ConfigQuestionSecondKind cqfk) {
		cqfk.setSecond_kind_id(UUIDUtil.getASIC());
		baseDaoMybatisImpl.add(cqfk, "addConfigQuestionSecondKind");
	}
	public void deleteConfigQuestionSecondKind(String id) {
	}
	public void updateConfigQuestionSecondKind(String id, String name) {
	}
}
