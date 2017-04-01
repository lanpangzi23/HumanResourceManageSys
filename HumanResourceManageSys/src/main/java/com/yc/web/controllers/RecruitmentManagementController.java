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
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.web.utils.ResponseData;
@Controller
public class RecruitmentManagementController {
	private RecruitmentManagementBiz recruitmentManagementBizImpl;
	@Resource
	public void setRecruitmentManagementBizImpl(RecruitmentManagementBiz recruitmentManagementBizImpl) {
		this.recruitmentManagementBizImpl = recruitmentManagementBizImpl;
	}
	@RequestMapping(value="addEngageMajor")
	public @ResponseBody void addEngageMajor(HttpServletResponse response,EngageMajorRelease emr) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			recruitmentManagementBizImpl.addEngageMajor(emr);
			out.print("登记成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			out.print(e.getMessage());
		}
	}
	@RequestMapping(value="updateEngageMajor")
	public @ResponseBody void updateEngageMajor(HttpServletResponse response,EngageMajorRelease emr) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			recruitmentManagementBizImpl.updateEngageMajor(emr);
			out.print("变更成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			out.print(e.getMessage());
		}
	}
	@RequestMapping(value="findEngageMajor")
	public @ResponseBody void findEngageMajor(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<EngageMajorRelease> list=recruitmentManagementBizImpl.findEngageMajor((rows*(page-1)),rows,null);
		int size=recruitmentManagementBizImpl.findEngageMajor(null,null,null).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="findEngageMajorDetails/{id}")
	public String findEngageMajorDetails(@PathVariable int name,Model model){
		List<EngageMajorRelease> list=recruitmentManagementBizImpl.findEngageMajor(null, null, name);
		model.addAttribute("engageMajor", list.get(0));
		return "jobPostingChange";
	}
	@RequestMapping(value="deleteEngageMajor/{id}")
	public @ResponseBody void deleteEngageMajor(HttpServletResponse response,@PathVariable int id) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			recruitmentManagementBizImpl.deleteEngageMajor(id);
			out.print("删除成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			out.print(e.getMessage());
		}
	}
}