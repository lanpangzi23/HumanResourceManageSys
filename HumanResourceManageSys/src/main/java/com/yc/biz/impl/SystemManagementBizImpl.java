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
	
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	public List<ConfigPublicChar> findSalaryProjectName() {
		ConfigPublicChar cpc=new ConfigPublicChar();
		cpc.setAttribute_kind("薪酬设置");
		return baseDaoMybatisImpl.findAll(cpc, "selectConfigPublicChar");
	}
	
}
