package com.yc.web.controllers;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.SalaryStandard;
import com.yc.biz.HumanBiz;
import com.yc.biz.OrganizationBiz;
import com.yc.biz.SystemManagementBiz;
import com.yc.web.utils.RandomNumberUtil;
@Controller
public class PageController {
	private SystemManagementBiz systemManagementBizImpl;
	private HumanBiz humanBiz;
	private OrganizationBiz organizationBiz;
	@Resource(name="organizationBizImpl")
	public void setOrganizationBiz(OrganizationBiz organizationBiz) {
		this.organizationBiz = organizationBiz;
	}
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
//		List<ConfigFileFirstKind> configFileFirstKinds=this.humanBiz.getAllConfigFileFirstKinds();
//		model.addAttribute("configFileFirstKinds",configFileFirstKinds);
		List<ConfigMajorKind> configMajorKind=this.humanBiz.getAllConfigMajorKinds();
		model.addAttribute("configMajorKind",configMajorKind);
		List<ConfigMajor> configMajor=this.humanBiz.getAllConfigMajors();
		model.addAttribute("configMajor",configMajor);
		List<ConfigPublicChar> technicalTitles=this.humanBiz.getAllTechnicalTitles();
		model.addAttribute("technicalTitles",technicalTitles);
		List<ConfigPublicChar> nationalitys=this.humanBiz.getAllNationalitys();
		model.addAttribute("nationalitys",nationalitys);
		List<ConfigPublicChar> nations=this.humanBiz.getAllNations();
		model.addAttribute("nations",nations);
		List<ConfigPublicChar> religiousBeliefs=this.humanBiz.getAllReligiousBeliefs();
		model.addAttribute("religiousBeliefs",religiousBeliefs);
		List<ConfigPublicChar> politicalStatus=this.humanBiz.getAllPoliticalStatus();
		model.addAttribute("politicalStatus",politicalStatus);
		List<ConfigPublicChar> schooling=this.humanBiz.getAllSchooling();
		model.addAttribute("schooling",schooling);
		List<ConfigPublicChar> educations=this.humanBiz.getAllEducations();
		model.addAttribute("educations",educations);
		List<ConfigPublicChar> strongPoints=this.humanBiz.getAllStrongPoints();
		model.addAttribute("strongPoints",strongPoints);
		List<ConfigPublicChar> hobbys=this.humanBiz.getAllHobbys();
		model.addAttribute("hobbys",hobbys);
		List<ConfigPublicChar> educationsYears=this.humanBiz.getAllEducationsYears();
		model.addAttribute("educationsYears",educationsYears);
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
	@RequestMapping(value="/admin/StandardSalarySet")//薪酬标准登记sx
	public ModelAndView toStandardSalarySetPage(){
		ModelAndView mv=new ModelAndView("StandardSalarySet");
		SalaryStandard ss=new SalaryStandard();
		List<ConfigPublicChar> list=systemManagementBizImpl.findSalaryProjectName();
		ss.setRegist_time(new Date());
		ss.setRegister("admin");
		ss.setStandard_id(RandomNumberUtil.getTenByteNumber());
		mv.addObject("salaryStandard", ss);
		mv.addObject("configPublicChar", list);
		return mv;
	}
	@RequestMapping(value="/admin/CompensationStandardRegistrationReview")//转到薪酬复核界面
	public String toCompensationStandardRegistrationReviewPage(){
		return "findCheckSalaryStandard";
	}
	
	
	@RequestMapping(value="/admin/salarySandardQuery")
	public String tosalarySandardQueryPage(){
		return "salarySandardQuery";
	}
	@RequestMapping(value="/admin/paymentRegistrationReview")//跳转到待发放的薪酬界面
	public String topaymentRegistrationReviewPage(){
		return "payoffList";
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
	public ModelAndView tosalaryManagementSettingPage(){//转到薪酬管理设置界面sx
		ModelAndView mv=new ModelAndView("salaryManagementSetting");
		List<ConfigPublicChar> list=systemManagementBizImpl.findSalaryProjectName();
		mv.addObject("salaryName", list);
		return mv;
	}
	
	@RequestMapping(value="/admin/organization")
	public String toOrganization(Model model){//转到机构设置区
		List<ConfigFileFirstKind> configFileFirstKinds=this.organizationBiz.getAllConfigFileFirstKinds();
		model.addAttribute("configFileFirstKinds",configFileFirstKinds);
		return "Organization";
	}
}
