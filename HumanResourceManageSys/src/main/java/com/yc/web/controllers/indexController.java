package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.bean.SalaryStandard;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.biz.UserBiz;

@Controller
public class indexController {
	private UserBiz userBiz;
	@Resource(name="userBizImpl")
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	@RequestMapping(value="/findMaior")//人力资源档案登记 ss
	public @ResponseBody void toitemBankManagementSetting(HttpServletResponse response,Model model) throws IOException{
		response.setCharacterEncoding("utf-8");
		List<EngageMajorRelease> engageMajorRelease=this.userBiz.selectEngageMajorReleaseByName(new EngageMajorRelease());
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(engageMajorRelease)); 
	}
	
	//模糊查寻
	@RequestMapping(value="/selectEngageMajorReleaseByName")//人力资源档案登记 ss
	public @ResponseBody void selectEngageMajorReleaseByName(HttpServletResponse response,@RequestParam String keyword) throws IOException{
		response.setCharacterEncoding("utf-8");
		EngageMajorRelease engageMajorRelease=new EngageMajorRelease();
		engageMajorRelease.setMajor_name("%"+keyword+"%");
		List<EngageMajorRelease> engageMajorRelease1=this.userBiz.selectEngageMajorReleaseByName(engageMajorRelease);
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(engageMajorRelease1)); 
	}
}
