package com.yc.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping(value="/admin/index")
	public String toIndexPage(){
		return "index";
	}
	@RequestMapping(value="/admin/humanResourceRegistration")
	public String toHumanResourceRegistrationPage(){
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
	public String tosalaryManagementSettingPage(){
		return "salaryManagementSetting";
	}
}
