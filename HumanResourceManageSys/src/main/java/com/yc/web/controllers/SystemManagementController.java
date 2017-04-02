package com.yc.web.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.ConfigQuestionFirstKind;
import com.yc.biz.SystemManagementBiz;
import com.yc.web.utils.ResponseData;
@Controller
public class SystemManagementController {
	private SystemManagementBiz systemManagementBizImpl;
	@Resource
	public void setSystemManagementBizImpl(SystemManagementBiz systemManagementBizImpl) {
		this.systemManagementBizImpl = systemManagementBizImpl;
	}
	@RequestMapping("/updateSalaryProjectName/{id}/{name}")
	public @ResponseBody String updateSalaryProjectName(@PathVariable int id,@PathVariable String name){
		if(systemManagementBizImpl.updateSalaryProjectName(id, name)){
			return "success";
		}
		return "error";
	}
	@RequestMapping("/deleteSalaryProjectName/{id}")
	public @ResponseBody String deleteSalaryProjectName(@PathVariable int id){
		systemManagementBizImpl.deleteSalaryProjectName(id);
		return "success";
	}
	@RequestMapping("/addSalaryProjectName/{attribute_name}")
	public @ResponseBody String addSalaryProjectName(@PathVariable String attribute_name){
		if(systemManagementBizImpl.addSalaryProjectName(attribute_name)){
			return "success";
		}
		return "error";
	}
	@RequestMapping("/findConfigQuestionFirstKind")
	public @ResponseBody void findConfigQuestionFirstKind(@RequestParam int page,@RequestParam int rows,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ConfigQuestionFirstKind> list=systemManagementBizImpl.findByPage(page, rows);
		int size=systemManagementBizImpl.findByPage(null, null).size();
		ResponseData rd=new ResponseData();
		Gson gson=new Gson();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
}
