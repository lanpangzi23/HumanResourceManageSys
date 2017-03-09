package com.yc.biz.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.SalaryAdministrationBiz;
import com.yc.dao.BaseDao;
@Repository
public class SalaryAdministrationBizImpl implements SalaryAdministrationBiz{
	private BaseDao baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	public void addSalaryStandard(String sqlId, SalaryStandard salaryS) {
	}
	public void addSalaryStandardDetails(String sqlId, SalaryStandardDetails salarySD){//薪酬标准登记
		baseDaoMybatisImpl.add( salarySD,sqlId);
	}
	public List<ConfigPublicChar> findSalaryProjectName(String sqlId, ConfigPublicChar cpc) {
		return null;
	}
}
