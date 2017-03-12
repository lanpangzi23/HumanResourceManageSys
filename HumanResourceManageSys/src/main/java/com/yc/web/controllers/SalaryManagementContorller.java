package com.yc.web.controllers;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.bean.SalaryStandard;
/*
 * 薪酬管理  控制器
 */
@Controller
public class SalaryManagementContorller {
	@RequestMapping(value="admin/addSalaryStandard")
	public void addSalaryStandard(SalaryStandard ss,HttpServletResponse resp){//查看薪酬项目名称
		
	}
}
