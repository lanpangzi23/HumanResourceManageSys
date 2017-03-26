package com.yc.biz.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.HumanFile;
import com.yc.bean.SalaryGrant;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.SalaryAdministrationBiz;
import com.yc.dao.BaseDao;
@Repository
@Transactional(readOnly=false)
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
		salaryS.setCheck_status(0);
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
	public List<SalaryStandard> findSalaryStandard(int minPage,int maxPage) {//分页
		SalaryStandard ss=new SalaryStandard();
		ss.setCheck_status(0);
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
		salaryStandard.get(0).setCheck_time(new Date());
		salaryStandard.get(0).setChecker("admin");
		List<SalaryStandardDetails> salaryStandardDetails=baseDaoMybatisImpl.findAll(ssds, "selectSalaryStandardDetails");
		list.add(salaryStandard.get(0));
		list.add(salaryStandardDetails);
		return list;
	}
	public void reviewSalaryStandard(String standard_id, String check_commnt) {
		SalaryStandard ss=new SalaryStandard();
		ss.setStandard_id(standard_id);
		ss.setCheck_comment(check_commnt);
		baseDaoMybatisImpl.update(ss, "updateSalaryStandard");
	}
	public List<SalaryStandard> fuzzyQuery(SalaryStandard ss){//根据条件查询支持模糊查询
		//关键字查询条件将在薪酬标准名称、制定人、变更人和复核人字段进行匹配
		List<SalaryStandard> list=baseDaoMybatisImpl.findAll(ss, "selectSalaryStandard1");
		return list;
	}
	//查找待发放的薪资列表
	public List<HumanFile> findPayoff(int page,int rows){
		HumanFile hf=new HumanFile();
		hf.setMinPage(page);
		hf.setMaxPage(rows);
		List<HumanFile> list=baseDaoMybatisImpl.findAll(hf, "selectHumanFile");
		return list;
	}
	public void updateHumanFile() {//每月的22号提醒老板发工资给员工
		baseDaoMybatisImpl.update(new HumanFile(), "updateHumanFile");
	}
	public List<SalaryGrant> findSalaryGrant() {
		return baseDaoMybatisImpl.findAll(new SalaryGrant(), "selectSalaryGrant");
	}
	public HumanFile findSalaryGrantDetail(String name,int page,int rows) {//查看具体员工的工资详情
		HumanFile hf=new HumanFile();
		hf.setHuman_name(name);
		hf.setMinPage(page);
		hf.setMaxPage(rows);
		List<HumanFile> list=baseDaoMybatisImpl.findAll(hf, "selectSalaryStandardDetails1");
		return list.get(0);
	}
	public List<HumanFile> findHumanName(String firstname, String secondname) {//根据一二机构查询员工信息
		HumanFile hf=new HumanFile();
		hf.setFirst_kind_name(firstname);
		hf.setSecond_kind_name(secondname);
		List<HumanFile> list=baseDaoMybatisImpl.findAll(hf, "selectHumanName");
		return list;
	}
	public List<SalaryStandardDetails> findBySalarySN(String name) {//根据薪酬标准id查找薪酬项目详情
		SalaryStandardDetails ssd=new SalaryStandardDetails();
		ssd.setStandard_id(name);;
		return baseDaoMybatisImpl.findAll(ssd, "selectSalaryStandardDetails");
	}
}
