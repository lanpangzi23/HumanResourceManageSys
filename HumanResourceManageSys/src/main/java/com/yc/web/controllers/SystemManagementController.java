package com.yc.web.controllers;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.biz.SystemManagementBiz;
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
	public String deleteSalaryProjectName(@PathVariable int id){
		systemManagementBizImpl.deleteSalaryProjectName(id);
		return "redirect:salaryManagementSetting";
	}
	@RequestMapping("/addSalaryProjectName/{attribute_name}")
	public @ResponseBody String addSalaryProjectName(@PathVariable String attribute_name){
		if(systemManagementBizImpl.addSalaryProjectName(attribute_name)){
			return "success";
		}
		return "error";
	}
}
