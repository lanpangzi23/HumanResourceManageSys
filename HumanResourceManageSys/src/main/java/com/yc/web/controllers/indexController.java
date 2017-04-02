package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.bean.SalaryStandard;
import com.yc.biz.RecruitmentManagementBiz;

@Controller
public class indexController {
	private RecruitmentManagementBiz rBiz;
	@Resource(name="recruitmentManagementBizImpl")
	public void setrBiz(RecruitmentManagementBiz rBiz) {
		this.rBiz = rBiz;
	}
	@RequestMapping(value="/findMaior")//人力资源档案登记 ss
	public @ResponseBody void toitemBankManagementSetting(HttpServletResponse response,Model model) throws IOException{
		response.setCharacterEncoding("utf-8");
		List<EngageMajorRelease> engageMajorRelease=this.rBiz.findEngageMajor(null, null, null);
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(engageMajorRelease)); 
	}
}
