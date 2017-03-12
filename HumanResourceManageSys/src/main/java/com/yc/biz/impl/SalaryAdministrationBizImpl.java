package com.yc.biz.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
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
	public void addSalaryStandard(SalaryStandard salaryS) {
		baseDaoMybatisImpl.add(salaryS, "insertSalaryStandard");
	}
	public void addSalaryStandardDetails(String sqlId, SalaryStandardDetails salarySD){//薪酬标准登记
		baseDaoMybatisImpl.add( salarySD,sqlId);
	}
}
