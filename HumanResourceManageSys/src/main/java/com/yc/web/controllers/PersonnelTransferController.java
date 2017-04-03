package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.HumanFile;
import com.yc.bean.MajorChange;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
import com.yc.bean.Training;
import com.yc.biz.PersonnelTransferBiz;
import com.yc.biz.impl.PersonnelTransferBizImpl;
import com.yc.biz.impl.SalaryAdministrationBizImpl;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
@Controller
public class PersonnelTransferController {
	private PersonnelTransferBiz personnelTransferBizImpl;
	@Resource
	public void setPersonnelTransferBizImpl(PersonnelTransferBiz personnelTransferBizImpl) {
		this.personnelTransferBizImpl = personnelTransferBizImpl;
	}
	
	@RequestMapping(value="admin/transferRegistration/{humanfile}")
	public String toTransferRegistration(Model model,@PathVariable HumanFile humanfile){//查看待调动人详情
		humanfile.setHuman_name("fantia");
		humanfile.setHuman_id_card("140105198307010065");
		List <HumanFile> list=personnelTransferBizImpl.findPersonnel(humanfile);
		model.addAttribute("humanfile",list.get(0));
		System.out.println("********"+list);
		return "transferRegistration";
	}
	
	@RequestMapping(value="findByPages")
	public @ResponseBody void findPersons(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HumanFile hf=new HumanFile();
		hf.setMinPage(rows*(page-1));
		hf.setMaxPage(rows);
		List<HumanFile> list=personnelTransferBizImpl.findAll(hf);
		hf.setMinPage(0);
		hf.setMaxPage(10000);
		int size=personnelTransferBizImpl.findAll(hf).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="tofindByPages")
	public @ResponseBody void findPerson(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,@RequestParam String human_name) throws IOException{//查看公司人力资源
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HumanFile hf=new HumanFile();
		hf.setMinPage(rows*(page-1));
		hf.setMaxPage(rows);
		hf.setHuman_name(human_name);
		List<HumanFile> list=personnelTransferBizImpl.findAll(hf);
		System.out.println(list);
		hf.setMinPage(0);
		hf.setMaxPage(10000);
		int size=personnelTransferBizImpl.findAll(hf).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="totransferFind/{id}")
	public ModelAndView totransferRegistration(@PathVariable String id){//查看待复核人详情
		ModelAndView mv=new ModelAndView("transferRegistration");
		List<HumanFile> list=personnelTransferBizImpl.findPersonDetails(id);
		mv.addObject("humanfile", list.get(0));
		return mv;
	}
	
	
	  //获取一级机构
	      @RequestMapping(value="findfirstKind")
	      @ResponseBody
	      public Map<String, Object> findfirstKind(HttpServletRequest request,HttpServletResponse response,ModelMap map){
	    	  List<ConfigFileFirstKind> firstlist=personnelTransferBizImpl.getAllConfigFileFirstKinds();
	          Map<String, Object> modelMap = new HashMap<String, Object>();  
	          modelMap.put("data", firstlist);  
	          return modelMap;
	      }
	     //获取二级机构
	    @RequestMapping(value="findsecondKind")
	     @ResponseBody
	     public Map<String, Object> findsecondKind(HttpServletRequest request,HttpServletResponse response,String first_kind_id){
	    	 ConfigFileSecondKind cfs=new ConfigFileSecondKind();
	    	 cfs.setFirst_kind_id(first_kind_id);
	    	List<ConfigFileSecondKind> secondList=personnelTransferBizImpl.getAllConfigFileSecondKinds(cfs);
	        Map<String, Object> modelMap = new HashMap<String, Object>();  
	        System.out.println(secondList);
	        modelMap.put("data", secondList);
	         return modelMap;
	     }
	     //获取三级机构
	     @RequestMapping(value="findthirdKind")
	     @ResponseBody
	     public Map<String, Object> findthirdKind(HttpServletRequest request,HttpServletResponse response,String second_kind_id){
	    	 ConfigFileThirdKind cft=new ConfigFileThirdKind();
	    	 System.out.println("second_kind_id:"+second_kind_id);
	    	 cft.setSecond_kind_id(second_kind_id);
	    	 List<ConfigFileThirdKind> thirdList=personnelTransferBizImpl.getAllConfigFileThirdKinds(cft);
	         System.out.println(thirdList);
	    	 Map<String, Object> modelMap = new HashMap<String, Object>();  
	         modelMap.put("data", thirdList);
	         return modelMap;
	    }
	     //获取职位分类
	      @RequestMapping(value="findMajorKind")
	      @ResponseBody
	      public Map<String, Object> findMajorKind(HttpServletRequest request,HttpServletResponse response,ModelMap map){
	    	  List<ConfigMajorKind> list=personnelTransferBizImpl.getAllConfigMajorKinds();
	          Map<String, Object> modelMap = new HashMap<String, Object>();  
	          modelMap.put("data", list);  
	          return modelMap;
	      }
	      
	    //获取职位名称	 
		      @RequestMapping(value="findMajor")
		      @ResponseBody
		      public Map<String, Object> findMajor(HttpServletRequest request,HttpServletResponse response,String id){
		    	  ConfigMajor configMajor=new ConfigMajor();
		    	  System.out.println("id:"+id);
		    	  configMajor.setMajor_kind_id(id);
		    	  List<ConfigMajor> list=personnelTransferBizImpl.getAllConfigMajors(configMajor);
		          Map<String, Object> modelMap = new HashMap<String, Object>();  
		          modelMap.put("data", list);  
		          return modelMap;
		      }
		    //获取薪酬标准
		      @RequestMapping(value="findSalary")
		      @ResponseBody
		      public Map<String, Object> findSalary(HttpServletRequest request,HttpServletResponse response){
		    	  List<SalaryStandard> list=personnelTransferBizImpl.getAllSalaryStandard();
		          Map<String, Object> modelMap = new HashMap<String, Object>();  
		          modelMap.put("data", list);  
		          return modelMap;
		      }
	      
		      //获取提交上来的数据 并传递至数据库
		      @RequestMapping(value="success")
		  	public  String audit(@ModelAttribute MajorChange majorChange){//查看待复核人详情
		  		System.out.println(majorChange.getChange_reason());
		    	  //防止重复提交
		    	  MajorChange mj=new MajorChange();
		    	List<MajorChange> list1=personnelTransferBizImpl.selectAgain(mj);
		    	for(int i = 0;i<list1.size();i++){
		    		if(majorChange.getHuman_id().equals(list1.get(i).getHuman_id())){
		    			return "error";
		    		}
		    	}
		    	String first=majorChange.getNew_first_kind_name();
		  		String[] a=first.split("/");
		  		majorChange.setNew_first_kind_id(a[0]);
		  		majorChange.setNew_first_kind_name(a[1]);
		  		String second=majorChange.getNew_second_kind_name();
		  		a=second.split("/");
		  		majorChange.setNew_second_kind_id(a[0]);
		  		majorChange.setNew_second_kind_name(a[1]);
		  		String third=majorChange.getNew_third_kind_name();
		  		a=third.split("/");
		  		majorChange.setNew_third_kind_id(a[0]);
		  		majorChange.setNew_third_kind_name(a[1]);
		  		String major_kind=majorChange.getNew_major_kind_name();
		  		a=major_kind.split("/");
		  		majorChange.setNew_major_kind_id(a[0]);
		  		majorChange.setNew_major_kind_name(a[1]);
		  		String major=majorChange.getNew_major_name();
		  		a=major.split("/");
		  		majorChange.setNew_major_id(a[0]);
		  		majorChange.setNew_major_name(a[1]);
		  		String salary=majorChange.getNew_salary_standard_name();
		  		a=major.split("/");
		  		majorChange.setNew_salary_standard_id(a[0]);
		  		majorChange.setNew_salary_standard_name(a[1]);
		  		majorChange.setCheck_status(0);
		    	  personnelTransferBizImpl.toCommit(majorChange);
		  		return "success";
		  	}  
		      
		      
		      
		  	//提交审核
			    @RequestMapping(value="personnelTransferAudit")
				public @ResponseBody void trainingAudit(HttpServletResponse response,HttpServletRequest request,MajorChange majorChange) throws IOException{
					response.setCharacterEncoding("utf-8");
					System.out.println("**************************");
					try {
						int s=0;
						PrintWriter out = response.getWriter();
						 MajorChange mj=new MajorChange();
					    List<MajorChange> list1=personnelTransferBizImpl.selectAgain(mj);
					    for(int i = 0;i<list1.size();i++){
					    if(majorChange.getHuman_id().equals(list1.get(i).getHuman_id())){
					    			s=1;
					    		}
					    	}
				    	if(s==1){
				    		out.print(2);
				    	}else{
				    		String first=majorChange.getNew_first_kind_name();
					  		String[] a=first.split("/");
					  		majorChange.setNew_first_kind_id(a[0]);
					  		majorChange.setNew_first_kind_name(a[1]);
					  		String second=majorChange.getNew_second_kind_name();
					  		a=second.split("/");
					  		majorChange.setNew_second_kind_id(a[0]);
					  		majorChange.setNew_second_kind_name(a[1]);
					  		String third=majorChange.getNew_third_kind_name();
					  		a=third.split("/");
					  		majorChange.setNew_third_kind_id(a[0]);
					  		majorChange.setNew_third_kind_name(a[1]);
					  		String major_kind=majorChange.getNew_major_kind_name();
					  		a=major_kind.split("/");
					  		majorChange.setNew_major_kind_id(a[0]);
					  		majorChange.setNew_major_kind_name(a[1]);
					  		String major=majorChange.getNew_major_name();
					  		a=major.split("/");
					  		majorChange.setNew_major_id(a[0]);
					  		majorChange.setNew_major_name(a[1]);
					  		String salary=majorChange.getNew_salary_standard_name();
					  		a=major.split("/");
					  		majorChange.setNew_salary_standard_id(a[0]);
					  		majorChange.setNew_salary_standard_name(a[1]);
					  		majorChange.setCheck_status(0);
					    	  personnelTransferBizImpl.toCommit(majorChange);
							out.print(1);
				    	}

					} catch (Exception e) {
						PrintWriter out = response.getWriter();
						out.print(0);
					}
				}
		      
		      
		      
		      
		      @RequestMapping(value="toLogin.jsp")
			  	public  String toReturn(){//查看待复核人详情
			  		return "transferFind";
			  	}
		  	@RequestMapping(value="ChangefindByPages")
			public @ResponseBody void ChangefindByPages(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				MajorChange mc=new MajorChange();
				mc.setMinPage(rows*(page-1));
				mc.setMaxPage(rows);
				List<MajorChange> list=personnelTransferBizImpl.findAudit(mc);
				mc.setMinPage(0);
				mc.setMaxPage(10000);
				int size=personnelTransferBizImpl.findAudit(mc).size();
				Gson gson=new Gson();
				ResponseData rd=new ResponseData();
				rd.setRows(list);
				rd.setTotal(""+size);
				out.print(gson.toJson(rd)); 
			}
		  	
			@RequestMapping(value="totransferAuditFind/{id}")
			public ModelAndView totransferAuditFind(@PathVariable String id){//查看待复核人详情
				ModelAndView mv=new ModelAndView("transferAudit");
				List<MajorChange> list=personnelTransferBizImpl.findAuditDetails(id);
				mv.addObject("majorchange", list.get(0));
				return mv;
			}
			@RequestMapping(value="toUpdate/{check_reason}/{id}/{check_name}/{check_time}")
			public String toUpdate(@PathVariable String check_reason,@PathVariable String id,@PathVariable String check_name,@PathVariable String check_time) throws UnsupportedEncodingException{//查看待复核人详情
				List<MajorChange> list=personnelTransferBizImpl.findAuditDetails(id);
				String checker=new String(check_name.getBytes("iso-8859-1"),"UTF-8"); 
				list.get(0).setCheck_reason(check_reason);
				list.get(0).setCheck_time(check_time);
				list.get(0).setCheck_status(1);
				list.get(0).setChecker(checker);
				personnelTransferBizImpl.updateStatus(list.get(0));
				MajorChange mj=new MajorChange();
				mj.setHuman_id(id);
				personnelTransferBizImpl.updateMajorStatus(mj);
				System.out.println("*************************************************");
				return "success";
			}
			
			@RequestMapping(value="toUpdateFail/{check_reason}/{id}/{check_name}/{check_time}")
			public String toUpdateFail(@PathVariable String check_reason,@PathVariable String id,@PathVariable String check_name,@PathVariable String check_time) throws UnsupportedEncodingException{//查看待复核人详情
				List<MajorChange> list=personnelTransferBizImpl.findAuditDetails(id);
				String checker=new String(check_name.getBytes("iso-8859-1"),"UTF-8"); 
				list.get(0).setCheck_reason(check_reason);
				list.get(0).setCheck_time(check_time);
				list.get(0).setCheck_status(0);
				list.get(0).setChecker(checker);
				personnelTransferBizImpl.updateFail(list.get(0));
				MajorChange mj=new MajorChange();
				mj.setHuman_id(id);
				personnelTransferBizImpl.updateMajorStatus(mj);
				System.out.println("*************************************************");
				return "error";
			}
}
