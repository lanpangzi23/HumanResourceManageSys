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
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.yc.bean.HumanFile;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.biz.SalaryAdministrationBiz;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
/*
 * 薪酬管理  控制器
 */
@Controller
public class SalaryManagementContorller {
	private SalaryAdministrationBiz salaryAdministrationBizImpl;
	@Resource
	public void setSalaryAdministrationBizImpl(SalaryAdministrationBiz salaryAdministrationBizImpl) {
		this.salaryAdministrationBizImpl = salaryAdministrationBizImpl;
	}
	@RequestMapping(value="admin/addSalaryStandard")
	public String addSalaryStandard(SalaryStandard ss, SalaryStandardDetails ssd){//查看薪酬项目名称
		salaryAdministrationBizImpl.addSalaryStandard(ss, ssd);
		return "index";
	}
	@RequestMapping(value="findByPage")
	public @ResponseBody void addSalaryStandard(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看薪酬项目名称
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<SalaryStandard> list=salaryAdministrationBizImpl.findSalaryStandard(rows*(page-1), rows);
		int size=salaryAdministrationBizImpl.findSalaryStandard(0, 10000).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="toCompensationStandardRegistrationReview/{id}")
	public ModelAndView addSalaryStandard(@PathVariable String id){//查看待复核人详情
		id=RandomNumberUtil.getTrueNumber(id);
		ModelAndView mv=new ModelAndView("CompensationStandardRegistrationReview");
		List<Object> list=salaryAdministrationBizImpl.findSalaryStandardDetails(id);
		mv.addObject("salaryStandard", list.get(0));
		mv.addObject("salaryStandardDetails", list.get(1));
		return mv;
	}
	@RequestMapping(value="updateSalaryStandard/{id}/{comment}")
	public @ResponseBody String updateSalaryStandard(@PathVariable String id,@PathVariable String comment){//查看待复核人详情
		salaryAdministrationBizImpl.reviewSalaryStandard(id, comment);
		return "success";
	}
	@RequestMapping(value="findByFuzzy")
	public @ResponseBody void findByFuzzy(@RequestParam String standard_id,@RequestParam String keyword,@RequestParam String minDate,@RequestParam String maxDate,HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看待复核人详情
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		SalaryStandard ss=new SalaryStandard();
		if(!standard_id.equals("")){
			ss.setStandard_id("%"+standard_id+"%");
		}
		if(!keyword.equals("")){
			ss.setKeyword("%"+keyword+"%");
		}
		ss.setMinDate(RandomNumberUtil.toDate(minDate));
		ss.setMaxDate(RandomNumberUtil.toDate(maxDate));
		ss.setMinPage(rows*(page-1));
		ss.setMaxPage(rows);
		List<SalaryStandard> list=salaryAdministrationBizImpl.fuzzyQuery(ss);
		ss.setMinPage(0);
		ss.setMaxPage(10000);
		int size=salaryAdministrationBizImpl.fuzzyQuery(ss).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="toFindByFuzzy")
	public String toFindByFuzzy(@RequestParam String standard_id,@RequestParam String keyword,@RequestParam String minDate,@RequestParam String maxDate,Model model){//查看待复核人详情
		SalaryStandard ss=new SalaryStandard();
		ss.setStandard_id(standard_id);
		ss.setKeyword(keyword);
		System.out.println(minDate+"---"+maxDate);
		ss.setMinDate(RandomNumberUtil.toDate(minDate));
		ss.setMaxDate(RandomNumberUtil.toDate(maxDate));
		model.addAttribute("ss", ss);
		return "findByFuzzy";
	}
	@RequestMapping(value="findPayoff")
	public @ResponseBody void findPayoff(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<HumanFile> list=salaryAdministrationBizImpl.findPayoff(rows*(page-1),rows);
		int size=salaryAdministrationBizImpl.findPayoff(0,1000000).size();
		ResponseData rd=new ResponseData();
		Gson gson=new Gson();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
}
