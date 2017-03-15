package com.yc.biz.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.SalaryAdministrationBiz;
import com.yc.dao.BaseDao;
@Repository
@Transactional(readOnly=true)
public class SalaryAdministrationBizImpl implements SalaryAdministrationBiz{
	private BaseDao baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	/*propagation它们规定了事务方法和事务方法发生嵌套调用时事务如何进行传播
	 * PROPAGATION_REQUIRES_NEW 新建事务，如果当前存在事务，把当前事务挂起。*/
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void addSalaryStandard(SalaryStandard salaryS,SalaryStandardDetails ssd) {
		ssd.setStandard_id(salaryS.getStandard_id());
		ssd.setStandard_name(salaryS.getStandard_name());
		for(int i=0;i<ssd.getItem_idList().size();i++){
			ssd.setItem_id(ssd.getItem_idList().get(i));
			ssd.setItem_name(ssd.getItem_nameList().get(i));
			ssd.setSalary(ssd.getSalaryList().get(i));
			baseDaoMybatisImpl.add(ssd, "insertSalaryStandardDetails");
		}
		baseDaoMybatisImpl.add(salaryS, "insertSalaryStandard");
	}
	public List<SalaryStandard> findSalaryStandard(int minPage,int maxPage) {
		SalaryStandard ss=new SalaryStandard();
		ss.setChange_status(0);
		ss.setMinPage(minPage);
		ss.setMaxPage(maxPage);
		List<SalaryStandard> list=baseDaoMybatisImpl.findAll(ss, "selectSalaryStandard");
		return list;
	}
	public List<Object> findSalaryStandardDetails(String id){
		SalaryStandard ss=new SalaryStandard();
		SalaryStandardDetails ssds=new SalaryStandardDetails();
		List<Object> list=new ArrayList<>();
		ss.setStandard_id(id);
		ssds.setStandard_id(id);
		List<SalaryStandard> salaryStandard=baseDaoMybatisImpl.findAll(ss, "selectSalaryStandard");
		List<SalaryStandardDetails> salaryStandardDetails=baseDaoMybatisImpl.findAll(ssds, "selectSalaryStandardDetails");
		list.add(salaryStandard.get(0));
		list.add(salaryStandardDetails);
		return list;
	}
}
