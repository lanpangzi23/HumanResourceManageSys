package com.yc.web.controllers;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.SalaryAdministrationBiz;
/*
 * 薪酬管理  控制器
 */
@Controller
public class SalaryManagementContorller {
	private SalaryAdministrationBiz salaryAdministrationBizImpl;
	@Resource
	public void setSalaryAdministrationBizImpl(SalaryAdministrationBiz salaryAdministrationBizImpl) {
		this.salaryAdministrationBizImpl = salaryAdministrationBizImpl;
	}
	@RequestMapping(value="admin/addSalaryStandard")
	public String addSalaryStandard(SalaryStandard ss, SalaryStandardDetails ssd){//查看薪酬项目名称
		salaryAdministrationBizImpl.addSalaryStandard(ss, ssd);
		return "index";
	}
}
