package com.yc.web.controllers;
import java.util.List;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.biz.HumanBiz;
import com.yc.biz.SystemManagementBiz;
@Controller
public class PageController {
	private SystemManagementBiz systemManagementBizImpl;
	private HumanBiz humanBiz;
	@Resource(name="humanBizImpl")
	public void setHumanBiz(HumanBiz humanBiz) {
		this.humanBiz = humanBiz;
	}
	@Resource
	public void setSystemManagementBizImpl(SystemManagementBiz systemManagementBizImpl) {
		this.systemManagementBizImpl = systemManagementBizImpl;
	}
	@RequestMapping(value="/admin/index")
	public String toIndexPage(){
		return "index";
	}
	//人力资源档案登记 ss
	@RequestMapping(value="/admin/humanResourceRegistration")
	public String toHumanResourceRegistrationPage(Model model){
		List<ConfigFileFirstKind> configFileFirstKinds=this.humanBiz.getAllConfigFileFirstKinds();
		model.addAttribute("configFileFirstKinds",configFileFirstKinds);
		return "humanResourceRegistration";
	}
	@RequestMapping(value="/admin/humanResourceFileRegistrationReview")
	public String tohumanResourceFileRegistrationReviewPage(){
		return "humanResourceFileRegistrationReview";
	}
	@RequestMapping(value="/admin/humanResourceFileQuery")
	public String tohumanResourceFileQueryPage(){
		return "humanResourceFileQuery";
	}
	@RequestMapping(value="/admin/humanResourceFileUpdate")
	public String tohumanResourceFileUpdatePage(){
		return "humanResourceFileUpdate";
	}
	@RequestMapping(value="/admin/humanResourceFileDelete")
	public String tohumanResourceFileDeletePage(){
		return "humanResourceFileDelete";
	}
	@RequestMapping(value="/admin/StandardSalarySet")
	public String toStandardSalarySetPage(){
		return "StandardSalarySet";
	}
	@RequestMapping(value="/admin/CompensationStandardRegistrationReview")
	public String toCompensationStandardRegistrationReviewPage(){
		return "CompensationStandardRegistrationReview";
	}
	
	
	@RequestMapping(value="/admin/salarySandardQuery")
	public String tosalarySandardQueryPage(){
		return "salarySandardQuery";
	}
	@RequestMapping(value="/admin/paymentRegistrationReview")
	public String topaymentRegistrationReviewPage(){
		return "paymentRegistrationReview";
	}
	@RequestMapping(value="/admin/transferRegistration")
	public String totransferRegistrationPage(){
		return "transferRegistration";
	}
	@RequestMapping(value="/admin/transferAudit")
	public String totransferAuditPage(){
		return "transferAudit";
	}
	@RequestMapping(value="/admin/salaryManagementSetting")
	public ModelAndView tosalaryManagementSettingPage(){//转到薪酬管理设置界面
		ModelAndView mv=new ModelAndView("salaryManagementSetting");
		List<ConfigPublicChar> list=systemManagementBizImpl.findSalaryProjectName();
		mv.addObject("salaryName", list);
		return mv;
	}
}
