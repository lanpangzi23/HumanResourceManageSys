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
import com.yc.bean.ConfigQuestionSecondKind;
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
	@RequestMapping("/addFirstQuestion")
	public @ResponseBody String addFirstQuestion(@RequestParam String name){
		systemManagementBizImpl.addConfigQuestionFirstKind(name);
		return "success";
	}
	@RequestMapping("/addSecondQuestion")
	public @ResponseBody String addSecondQuestion(ConfigQuestionSecondKind cqsk){
		systemManagementBizImpl.addConfigQuestionSecondKind(cqsk);
		return "success";
	}
	@RequestMapping("/deleteFirstQuestion")
	public @ResponseBody String deleteFirstQuestion(@RequestParam String id){
		systemManagementBizImpl.deleteConfigQuestionFirstKind(id);
		return "success";
	}
	@RequestMapping("/updateFirstQuestion")
	public @ResponseBody String updateFirstQuestion(@RequestParam String id,@RequestParam String name){
		systemManagementBizImpl.updateConfigQuestionFirstKind(id, name);
		return "success";
	}
	@RequestMapping("/addSalaryProjectName/{attribute_name}")
	public @ResponseBody String addSalaryProjectName(@PathVariable String attribute_name){
		if(systemManagementBizImpl.addSalaryProjectName(attribute_name)){
			return "success";
		}
		return "error";
	}
	@RequestMapping("/ConfigQuestionFirstKind")
	public @ResponseBody void ConfigQuestionFirstKind(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ConfigQuestionFirstKind> list=systemManagementBizImpl.findByPage(null, null);
		Gson gson=new Gson();
		out.print(gson.toJson(list));
	}
	@RequestMapping("/ConfigQuestionSecondKind")
	public @ResponseBody void ConfigQuestionSecondKind(HttpServletResponse response,@RequestParam String first_kind_id) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ConfigQuestionSecondKind> list=systemManagementBizImpl.findByPageSecond(null, null, first_kind_id);
		Gson gson=new Gson();
		out.print(gson.toJson(list));
	}
	@RequestMapping("/findConfigQuestionFirstKind")
	public @ResponseBody void findConfigQuestionFirstKind(@RequestParam int page,@RequestParam int rows,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ConfigQuestionFirstKind> list=systemManagementBizImpl.findByPage(rows*(page-1), rows);
		int size=systemManagementBizImpl.findByPage(null, null).size();
		ResponseData rd=new ResponseData();
		Gson gson=new Gson();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	@RequestMapping("/findConfigQuestionSecondKind")
	public @ResponseBody void findConfigQuestionSecondKind(@RequestParam int page,@RequestParam int rows,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<ConfigQuestionSecondKind> list=systemManagementBizImpl.findByPageSecond(rows*(page-1), rows,null);
		int size=systemManagementBizImpl.findByPageSecond(null, null,null).size();
		ResponseData rd=new ResponseData();
		Gson gson=new Gson();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
}
