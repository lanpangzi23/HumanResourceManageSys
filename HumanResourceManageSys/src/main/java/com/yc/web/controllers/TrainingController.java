package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yc.bean.Bonus;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.Training;
import com.yc.biz.impl.TrainingBizImpl;
import com.yc.web.utils.ResponseData;

@Controller
public class TrainingController {
	private TrainingBizImpl trainingBizImpl;
	@Resource
	public void setTrainingBizImpl(TrainingBizImpl trainingBizImpl) {
		this.trainingBizImpl = trainingBizImpl;
	}
	 @RequestMapping(value="additem/{item}/{time}/{hour}")
	    public String additem(@PathVariable String item,@PathVariable String time,@PathVariable String hour) throws UnsupportedEncodingException{
			String items=new String(item.getBytes("iso-8859-1"),"UTF-8");
		 	ConfigPublicChar configPublicChar1=new ConfigPublicChar();
	    	configPublicChar1.setAttribute_kind("培训项目");
	    	List<ConfigPublicChar> list=trainingBizImpl.findItem(configPublicChar1);
	    	for(int i=0;i<list.size();i++){	
	    	if(items.equals(list.get(i).getAttribute_name())){
	        return "error";
	        	}
	    	}
	    	  ConfigPublicChar configPublicChar=new ConfigPublicChar();
	      	  if(item!=null&&item!=""){
	      		  configPublicChar.setAttribute_kind("培训项目");
	      		  configPublicChar.setAttribute_name(items);
	      		  trainingBizImpl.addItem(configPublicChar);
	      	  }	
	      	 ConfigPublicChar configPublicChar2=new ConfigPublicChar();	
	      	  	configPublicChar2.setAttribute_kind(items);
	      	  	configPublicChar2.setAttribute_name(time);
	      	  	trainingBizImpl.addTime(configPublicChar2);
	      	  	String itemss=items+'s';
	      	  ConfigPublicChar configPublicChar3=new ConfigPublicChar();
		      	configPublicChar3.setAttribute_kind(itemss);
	      	  	configPublicChar3.setAttribute_name(hour);
	      	  	trainingBizImpl.addHour(configPublicChar3);
	    	return "success";
	    }
	 @RequestMapping(value="adddegree/{degree}")
	    public String adddegree(@PathVariable String degree){
	    	System.out.println();
		 	ConfigPublicChar configPublicChar1=new ConfigPublicChar();
	    	configPublicChar1.setAttribute_kind("成绩等级");
	    	List<ConfigPublicChar> list=trainingBizImpl.findItem(configPublicChar1);
	    	for(int i=0;i<list.size();i++){	
	    	if(degree.equals(list.get(i).getAttribute_name())){
	        return "error";
	        	}
	    	}
	    	  ConfigPublicChar configPublicChar=new ConfigPublicChar();
	      	  if(degree!=null&&degree!=""){
	      		  configPublicChar.setAttribute_kind("成绩等级");
	      		  configPublicChar.setAttribute_name(degree);
	      		  trainingBizImpl.addDegree(configPublicChar);
	      	  }	
	    	return "success";
	    }
	 
		@RequestMapping(value="findPeople")
		public @ResponseBody void findPersons(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			HumanFile hf=new HumanFile();
			hf.setMinPage(rows*(page-1));
			hf.setMaxPage(rows);
			List<HumanFile> list=trainingBizImpl.findAll(hf);
			hf.setMinPage(0);
			hf.setMaxPage(10000);
			int size=trainingBizImpl.findAll(hf).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(list);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
		@RequestMapping(value="findPeoples")
		public @ResponseBody void findPerson(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,@RequestParam String human_name) throws IOException{//查看公司人力资源
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			HumanFile hf=new HumanFile();
			hf.setMinPage(rows*(page-1));
			hf.setMaxPage(rows);
			hf.setHuman_name(human_name);
			List<HumanFile> list=trainingBizImpl.findAll(hf);
			System.out.println(list);
			hf.setMinPage(0);
			hf.setMaxPage(10000);
			int size=trainingBizImpl.findAll(hf).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(list);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
		
		   @RequestMapping(value="tofinditem")
		    @ResponseBody
		    public Map<String, Object> tofinditem(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
		    	configPublicChar.setAttribute_kind("培训项目");
		    	List<ConfigPublicChar> list=trainingBizImpl.findItem(configPublicChar);
		        Map<String, Object> modelMap = new HashMap<String, Object>();  
		        modelMap.put("data", list);  
		        return modelMap;
		    }
		    @RequestMapping(value="tofindtime")
		    @ResponseBody
		    public Map<String, Object> tofindtime(HttpServletRequest request,HttpServletResponse response,ModelMap map,String attribute_name) throws UnsupportedEncodingException{
		    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
				String name=new String(attribute_name.getBytes("iso-8859-1"),"UTF-8"); 
		    	configPublicChar.setAttribute_kind(name);
		    	List<ConfigPublicChar> list=trainingBizImpl.findTime(configPublicChar);
		    	System.out.println(name+"*****"+list.get(0).getAttribute_name());
		        Map<String, Object> modelMap = new HashMap<String, Object>();  
		        modelMap.put("data", list);  
		        return modelMap;
		    }
		    @RequestMapping(value="tofindhour")
		    @ResponseBody
		    public Map<String, Object> tofindhour(HttpServletRequest request,HttpServletResponse response,ModelMap map,String attribute_name) throws UnsupportedEncodingException{
		    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
				String name=new String(attribute_name.getBytes("iso-8859-1"),"UTF-8");
		    	configPublicChar.setAttribute_kind(name);
		    	List<ConfigPublicChar> list=trainingBizImpl.findHour(configPublicChar);
		    	System.out.println(name+"*****"+list.get(0).getAttribute_name());
		        Map<String, Object> modelMap = new HashMap<String, Object>();  
		        modelMap.put("data", list);  
		        return modelMap;
		    }
		    
		    @RequestMapping(value="toTraining/{id}")
			public ModelAndView tobonus(@PathVariable String id){//查看待复核人详情
				ModelAndView mv=new ModelAndView("Training");
				List<HumanFile> list=trainingBizImpl.findPersonDetails(id);
				mv.addObject("humanfile", list.get(0));
				return mv;
			}
			@RequestMapping(value="findTrainingPages")
			public @ResponseBody void findTrainingPages(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				Training tra=new Training();
				tra.setMinPage(rows*(page-1));
				tra.setMaxPage(rows);
				List<Training> list=trainingBizImpl.findTraing(tra);
				tra.setMinPage(0);
				tra.setMaxPage(10000);
				int size=trainingBizImpl.findTraing(tra).size();
				Gson gson=new Gson();
				ResponseData rd=new ResponseData();
				rd.setRows(list);
				rd.setTotal(""+size);
				out.print(gson.toJson(rd)); 
			}
			@RequestMapping(value="tofindTrainingPages")
			public @ResponseBody void tofindTrainingPages(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,@RequestParam String human_name) throws IOException{//查看公司人力资源
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				Training tra=new Training();
				tra.setMinPage(rows*(page-1));
				tra.setMaxPage(rows);
				tra.setHuman_name(human_name);
				List<Training> list=trainingBizImpl.findTraing(tra);
				System.out.println(list);
				tra.setMinPage(0);
				tra.setMaxPage(10000);
				int size=trainingBizImpl.findTraing(tra).size();
				Gson gson=new Gson();
				ResponseData rd=new ResponseData();
				rd.setRows(list);
				rd.setTotal(""+size);
				out.print(gson.toJson(rd)); 
			}
			
			@RequestMapping(value="toTrainingPass/{id}")
			public ModelAndView toTrainingPass(@PathVariable String id){//查看待复核人详情
				ModelAndView mv=new ModelAndView("TrainingAudit");
				List<Training> list=trainingBizImpl.findTrainingDetails(id);
				mv.addObject("training", list.get(0));
				return mv;
			}
			
			
		    @RequestMapping(value="finddegree")
		    @ResponseBody
		    public Map<String, Object> finddegree(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
		    	configPublicChar.setAttribute_kind("成绩等级");
		    	List<ConfigPublicChar> list=trainingBizImpl.findDegree(configPublicChar);
		        Map<String, Object> modelMap = new HashMap<String, Object>();  
		        modelMap.put("data", list);  
		        return modelMap;
		    }
		    
			@RequestMapping(value="training/{id}/{checker}/{check_time}/{degree}")
			public String training(@PathVariable String id,@PathVariable String checker,@PathVariable String check_time,@PathVariable String degree) throws UnsupportedEncodingException{//查看待复核人详情
				Training training=new Training();
				String checks=new String(checker.getBytes("iso-8859-1"),"UTF-8"); 
				System.out.println(checks);
				training.setHuman_id(id);
				training.setChecker(checks);
				training.setCheck_time(check_time);
				training.setTraining_degree(degree);
				this.trainingBizImpl.trainingPass(training);
				System.out.println("*****************");
				return "successs";
			}
			//提交审核
		    @RequestMapping(value="trainingAudit")
			public @ResponseBody void trainingAudit(HttpServletResponse response,HttpServletRequest request,Training training) throws IOException{
				response.setCharacterEncoding("utf-8");
				System.out.println("**************************");
				try {
					int a=0;
					PrintWriter out = response.getWriter();
					Training trainings=new Training();
			    	List<Training> list=trainingBizImpl.findTraing(trainings);
			    	for(int i=0;i<list.size();i++){
			    		if(training.getHuman_id().equals(list.get(i).getHuman_id())){
			    			a=1;
			    		}
			    	}
			    	if(a==1){
			    		out.print(2);
			    	}else{
				    	this.trainingBizImpl.trainingCommit(training);
						out.print(1);
			    	}

				} catch (Exception e) {
					PrintWriter out = response.getWriter();
					out.print(0);
				}
			}
		    
}
