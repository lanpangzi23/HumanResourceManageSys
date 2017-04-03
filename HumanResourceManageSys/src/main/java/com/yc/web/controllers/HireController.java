package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.EngageInterview;
import com.yc.bean.HumanFile;
import com.yc.biz.HireBiz;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.web.utils.ResponseData;

@Controller
public class HireController {
	private HireBiz hireBiz;
	@Resource(name="hireBizImpl")
	public void setHireBiz(HireBiz hireBiz) {
		this.hireBiz = hireBiz;
	}
	@RequestMapping(value="/ShowEngage")
	public @ResponseBody void ShowEngage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		EngageInterview engageInterview=new EngageInterview();
		engageInterview.setResult("建议录用");
		engageInterview.setMinPage(rows*(page-1));
		engageInterview.setMaxPage(rows);
		PrintWriter out=response.getWriter();
		List<EngageInterview> list=this.hireBiz.selectEngageInterviewByResult(engageInterview);
		engageInterview.setMinPage(0);
		engageInterview.setMaxPage(100000);
		int size=this.hireBiz.selectEngageInterviewByResult(engageInterview).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	//
	@RequestMapping(value="/EmploymentApplication")
	public @ResponseBody void EmploymentApplication(HttpServletResponse response,@RequestParam String id,@RequestParam String proposal) throws IOException{
		
	}
	
}
