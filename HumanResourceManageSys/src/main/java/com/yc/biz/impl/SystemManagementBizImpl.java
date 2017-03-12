package com.yc.biz.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.yc.bean.ConfigPublicChar;
import com.yc.biz.SystemManagementBiz;
import com.yc.dao.BaseDao;
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
}
