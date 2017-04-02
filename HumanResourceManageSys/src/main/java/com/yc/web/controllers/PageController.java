package com.yc.web.controllers;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;

import com.yc.bean.SalaryGrant;

import com.yc.bean.HumanFile;
import com.yc.bean.SalaryStandard;
import com.yc.biz.HumanBiz;
import com.yc.biz.OrganizationBiz;
import com.yc.biz.SalaryAdministrationBiz;
import com.yc.biz.SystemManagementBiz;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
@Controller
public class PageController {
	private SystemManagementBiz systemManagementBizImpl;
	private HumanBiz humanBiz;
	private OrganizationBiz organizationBiz;
	private SalaryAdministrationBiz salaryAdministrationBizImpl;
	@Resource
	public void setSalaryAdministrationBizImpl(SalaryAdministrationBiz salaryAdministrationBizImpl) {
		this.salaryAdministrationBizImpl = salaryAdministrationBizImpl;
	}
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
	@RequestMapping(value="/admin/itemBankManagementSetting")//去题库管理设置界面
	public String toHumanResourceRegistrationPage(Model model){
		return "itemBankManagementSetting";
	}
	@RequestMapping(value="/admin/humanResourceRegistration")//人力资源档案登记 ss
	public String toitemBankManagementSetting(Model model){
		getConfigPublicCharInfo(model);
		List<SalaryStandard> salaryStandard=this.humanBiz.getAllSalaryStandard();
		model.addAttribute("salaryStandard",salaryStandard);
		return "humanResourceRegistration";
	}
	private void getConfigPublicCharInfo(Model model){
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
	}
	@RequestMapping(value="/admin/humanResourceFileRegistrationReview")
	public String tohumanResourceFileRegistrationReviewPage(Model model){
		HumanFile humanfile=new HumanFile();
		humanfile.setMinPage(0);
		humanfile.setMaxPage(100000000);
		humanfile.setCheck_status(0);
		List<HumanFile> humanFile=this.humanBiz.findtHumanFileByCheck(humanfile);
		model.addAttribute("humanFileSize",humanFile.size());
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
	@RequestMapping(value="/admin/toItemBankManagement")//转到题库管理系统
	public String toItemBankManagement(){
		return "itemBankManagement";
	}
	
	@RequestMapping(value="/admin/salarySandardQuery")
	public String tosalarySandardQueryPage(){
		return "salarySandardQuery";
	}
	@RequestMapping(value="/admin/paymentRegistrationReview")//跳转到待发放的薪酬界面
	public String topaymentRegistrationReviewPage(Model model){
		List<SalaryGrant> list=salaryAdministrationBizImpl.findSalaryGrant();
		ResponseData rd=new ResponseData();
		if(list.size()>0){
			rd.setTotalCount(list.size()+1);
			rd.setDate(list.get(list.size()-1).getRegist_time());
		}
		rd.setSalaryGrantId(RandomNumberUtil.getSalaryGrantId());
		model.addAttribute("salaryGrant", rd);
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
		List<ConfigPublicChar> configPublicChar=this.organizationBiz.findAlllConfigPublicChars();
		model.addAttribute("configPublicChar",configPublicChar);
		return "Organization";
	}
	@RequestMapping(value="/admin/toPostRegistration")
	public String toPostRegistration(Model model){//转到机构设置区
		return "postRegistration";
	}
	@RequestMapping(value="admin/toInterviewManagement")
	public String toInterviewManagement(Model model){//转到面试管理界面
		return "InterviewManagement";
	}
	@RequestMapping(value="/admin/toResumeManagement")
	public String toResumeManagement(Model model){//转到简历管理界面
		getConfigPublicCharInfo(model);
		return "ResumeManagement";
	}
	@RequestMapping(value="/admin/humanFileChangeReview")
	public String tohumanFileChangeReview(Model model){//转到人力资源变更复核
		HumanFile humanfile=new HumanFile();
		humanfile.setCheck_status(2);
		humanfile.setMinPage(0);
		humanfile.setMaxPage(100000);
		List<HumanFile> list=this.humanBiz.findtHumanFileByCheck(humanfile);
		model.addAttribute("size",list.size());
		return "humanFileChangeReview";
	}
	@RequestMapping(value="admin/addAdmin")
	public String toaddAdmin(){//转到后台管理员
		return "addAdmin";
	}
	@RequestMapping(value="admin/adminUserUpdate")
	public String toadminUserUpdate(){
		return "adminUpdate";
	}
	@RequestMapping(value="admin/toExaminationManagement")//到考试管理系统
	public String toExaminationManagement(){
		return "ExaminationManagement";
	}
	@RequestMapping(value="admin/adminLogin")
	public String toadminLogin(){
		return "adminLogin";
	}
}
