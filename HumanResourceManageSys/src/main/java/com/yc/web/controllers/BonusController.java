package com.yc.web.controllers;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.yc.bean.Bonus;
import com.yc.bean.ConfigMajor;
import com.yc.bean.ConfigMajorKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.MajorChange;
import com.yc.biz.impl.BonusBizImpl;
import com.yc.web.utils.ResponseData;

@Controller
public class BonusController {
	private  BonusBizImpl bonusBizImpl;
	@Resource
	public void setBonusBizImpl(BonusBizImpl bonusBizImpl) {
		this.bonusBizImpl = bonusBizImpl;
	}
	
    @RequestMapping(value="findrate/{rate}/{worth}")
    public String findrate(@PathVariable String rate,@PathVariable String worth){
    	ConfigPublicChar configPublicChar1=new ConfigPublicChar();
    	configPublicChar1.setAttribute_kind("奖励等级");
    	List<ConfigPublicChar> list=bonusBizImpl.findBonusType(configPublicChar1);
    	for(int i=0;i<list.size();i++){	
    	if(rate.equals(list.get(i).getAttribute_name())){
        return "error";
        	}
    	}
    	  ConfigPublicChar configPublicChar=new ConfigPublicChar();
      	  System.out.println("*****"+rate);
      	  if(rate!=null&&rate!=""){
      		  configPublicChar.setAttribute_kind("奖励等级");
      		  configPublicChar.setAttribute_name(rate);
      		  bonusBizImpl.addBonusRate(configPublicChar);
      	  }	
      	 ConfigPublicChar configPublicChar2=new ConfigPublicChar();	
      	  	configPublicChar2.setAttribute_kind(rate);
      	  	configPublicChar2.setAttribute_name(worth);
      	  	bonusBizImpl.addBonusWorth(configPublicChar2);
    	return "success";
    }
    
    @RequestMapping(value="findtype/{type}")
    public String findtype(@PathVariable String type) throws UnsupportedEncodingException{
    	ConfigPublicChar configPublicChar1=new ConfigPublicChar();
    	configPublicChar1.setAttribute_kind("奖励项目");
    	List<ConfigPublicChar> list=bonusBizImpl.findBonusType(configPublicChar1);
    	for(int i=0;i<list.size();i++){
    		 if(type.equals(list.get(i).getAttribute_name())){
    		        return "error";
    		        }
    	}
    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
	  	  System.out.println(type+"*****");
	  	  if(type!=null&&type!=""){
	  		configPublicChar.setAttribute_kind("奖励项目");
			String types=new String(type.getBytes("iso-8859-1"),"UTF-8"); 
	  		configPublicChar.setAttribute_name(types);
	  		bonusBizImpl.addBonusType(configPublicChar);
	  	  }
    return "error";
    }

	@RequestMapping(value="findPages")
	public @ResponseBody void findPersons(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HumanFile hf=new HumanFile();
		hf.setMinPage(rows*(page-1));
		hf.setMaxPage(rows);
		List<HumanFile> list=bonusBizImpl.findAll(hf);
		hf.setMinPage(0);
		hf.setMaxPage(10000);
		int size=bonusBizImpl.findAll(hf).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="tofindPages")
	public @ResponseBody void findPerson(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,@RequestParam String human_name) throws IOException{//查看公司人力资源
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HumanFile hf=new HumanFile();
		hf.setMinPage(rows*(page-1));
		hf.setMaxPage(rows);
		hf.setHuman_name(human_name);
		List<HumanFile> list=bonusBizImpl.findAll(hf);
		System.out.println(list);
		hf.setMinPage(0);
		hf.setMaxPage(10000);
		int size=bonusBizImpl.findAll(hf).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	
	@RequestMapping(value="tobonus/{id}")
	public ModelAndView tobonus(@PathVariable String id){//查看待复核人详情
		ModelAndView mv=new ModelAndView("bonus");
		List<HumanFile> list=bonusBizImpl.findPersonDetails(id);
		mv.addObject("humanfile", list.get(0));
		return mv;
	}
	
	   //获取职位分类
    @RequestMapping(value="tofindtype")
    @ResponseBody
    public Map<String, Object> tofindtype(HttpServletRequest request,HttpServletResponse response,ModelMap map){
    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
    	configPublicChar.setAttribute_kind("奖励项目");
    	List<ConfigPublicChar> list=bonusBizImpl.findBonusType(configPublicChar);
        Map<String, Object> modelMap = new HashMap<String, Object>();  
        modelMap.put("data", list);  
        return modelMap;
    }
    
    
    @RequestMapping(value="tofindrate")
    @ResponseBody
    public Map<String, Object> tofindrate(HttpServletRequest request,HttpServletResponse response,ModelMap map){
    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
    	configPublicChar.setAttribute_kind("奖励等级");
    	List<ConfigPublicChar> list=bonusBizImpl.findBonusType(configPublicChar);
        Map<String, Object> modelMap = new HashMap<String, Object>();  
        modelMap.put("data", list);  
        return modelMap;
    }
    @RequestMapping(value="tofindworth")
    @ResponseBody
    public Map<String, Object> tofindrate(HttpServletRequest request,HttpServletResponse response,ModelMap map,String attribute_name){
    	ConfigPublicChar configPublicChar=new ConfigPublicChar();
    	System.out.println(attribute_name);
    	configPublicChar.setAttribute_kind(attribute_name);
    	List<ConfigPublicChar> list=bonusBizImpl.findBonusWorth(configPublicChar);
    	//System.out.println(list.get(0).getAttribute_name());
        Map<String, Object> modelMap = new HashMap<String, Object>();  
        modelMap.put("data", list);  
        return modelMap;
    }
    
//  //获取提交上来的数据 并传递至数据库
//    @RequestMapping(value="successs")
//	public  String audits(@ModelAttribute Bonus bonus){//查看待复核人详情
//    	Bonus bonus1=new Bonus();
//    	List<Bonus> list=bonusBizImpl.findAll(bonus1);
//    	for(int i=0;i<list.size();i++){
//    		if(bonus.getHuman_id().equals(list.get(i).getHuman_id())){
//    			return "error";
//    		}
//    	}
//    	bonusBizImpl.audit(bonus);
//		return "successs";
//	}  
    
    
    
    
    
    @RequestMapping(value="successs")
	public @ResponseBody void tobonus(HttpServletResponse response,HttpServletRequest request,Bonus bonus) throws IOException{
		response.setCharacterEncoding("utf-8");
		System.out.println("**************************");
		try {
			int a=0;
			PrintWriter out = response.getWriter();
			Bonus bonus1=new Bonus();
	    	List<Bonus> list=bonusBizImpl.findAlls(bonus1);
	    	for(int i=0;i<list.size();i++){
	    		if(bonus.getHuman_id().equals(list.get(i).getHuman_id())){
	    			a=1;
	    		}
	    	}
	    	if(a==1){
	    		out.print(2);
	    	}else{
		    	this.bonusBizImpl.audit(bonus);
				out.print(1);
	    	}

		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
	}
    
    
    
    
    
    
    
    
    @RequestMapping(value="findBonus")
	public @ResponseBody void findBonus(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{//查看公司人力资源
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Bonus bs=new Bonus();
		bs.setMinPage(rows*(page-1));
		bs.setMaxPage(rows);
		List<Bonus> list=bonusBizImpl.findAlls(bs);
		bs.setMinPage(0);
		bs.setMaxPage(10000);
		int size=bonusBizImpl.findAlls(bs).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
    

	@RequestMapping(value="toBonusDetails/{id}")
	public ModelAndView toBonusDetails(@PathVariable String id){//查看待复核人详情
		ModelAndView mv=new ModelAndView("bonusAudit");
		System.out.println(id);
		Bonus bonus =new Bonus();
		bonus.setHuman_id(id);
		List<Bonus> list=bonusBizImpl.findBonusDetails(bonus);
		System.out.println(list.get(0).getHuman_id());
		mv.addObject("bonus", list.get(0));
		return mv;
	}
	@RequestMapping(value="bonus/{id}/{checker}/{check_time}")
	public String toUpdate(@PathVariable String id,@PathVariable String checker,@PathVariable String check_time) throws UnsupportedEncodingException{//查看待复核人详情
		Bonus bonus=new Bonus();
		String checks=new String(checker.getBytes("iso-8859-1"),"UTF-8"); 
		System.out.println(checks);
		bonus.setHuman_id(id);
		bonus.setChecker(checks);
		bonus.setCheck_time(check_time);
		this.bonusBizImpl.bonusThey(bonus);
		System.out.println("*****************");
		return "successs";
	}
	
	
	
	}
