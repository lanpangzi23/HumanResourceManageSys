package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.SalaryStandard;
import com.yc.biz.HumanBiz;
import com.yc.biz.OrganizationBiz;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
import com.yc.web.utils.UUIDUtil;
import com.yc.web.utils.UploadFileUtil;
import com.yc.web.utils.UploadFileUtil.UploadFile;

@Controller
public class HumanFileController {
	private HumanBiz humanBiz;
	private OrganizationBiz organizationBiz;
	@Resource(name="organizationBizImpl")
	public void setOrganizationBiz(OrganizationBiz organizationBiz) {
		this.organizationBiz = organizationBiz;
	}
	
	@Resource(name="humanBizImpl")
	public void setHumanBiz(HumanBiz humanBiz) {
		this.humanBiz = humanBiz;
	}
	//人力资源档案登记 
	@RequestMapping(value="/humanResourceRegistration")
	public @ResponseBody void saveHumanFile(HttpServletResponse response,HttpServletRequest request,HumanFile humanFile) throws IOException{
		response.setCharacterEncoding("utf-8");
		UUIDUtil u=new UUIDUtil();
		String human_picture="";
		//上传
		Map<String,UploadFile> map=UploadFileUtil.uploadFile(request, humanFile.getPicUrl(), "HumanFilePicture");
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			human_picture+=  uploadFile.getNewFileUrl();
		}
		SalaryStandard salaryStandard=new SalaryStandard();
		salaryStandard.setStandard_id(humanFile.getSalary_standard_id());
		List<SalaryStandard> ss=humanBiz.selectSalaryStandardById(salaryStandard);
		humanFile.setSalary_standard_name(ss.get(0).getStandard_name());
		humanFile.setSalary_sum(ss.get(0).getSalary_sum());
		
		humanFile.setHuman_picture(human_picture);
		humanFile.setHuman_id(u.getUuidUtil());
		humanFile.setHuman_file_status(false);
		humanFile.setCheck_status(0);
		try {
			this.humanBiz.save(humanFile);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
	}
	//人力资源档案查寻（复核状态）
	@RequestMapping(value="/findtHumanFileByCheck")
	public @ResponseBody void findtHumanFileByCheck(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		HumanFile humanfile=new HumanFile();
		humanfile.setMinPage(rows*(page-1));
		humanfile.setMaxPage(rows);
		humanfile.setCheck_status(0);
		List<HumanFile> humanFile=this.humanBiz.findtHumanFileByCheck(humanfile);
		PrintWriter out = response.getWriter();
		humanfile.setMinPage(0);
		humanfile.setMaxPage(1000000);
		int size=humanBiz.findtHumanFileByCheck(humanfile).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(humanFile);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="tohumanResourceFileRegistrationReviewEnd/{id}")
	public ModelAndView tohumanResourceFileRegistrationReviewEnd(@PathVariable String id,Model model){//查看待复核人详情
		ModelAndView mv=new ModelAndView("humanResourceFileRegistrationReviewEnd");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(id);
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		List<ConfigPublicChar> schooling=this.humanBiz.getAllSchooling();
		List<ConfigPublicChar> educations=this.humanBiz.getAllEducations();
		List<ConfigPublicChar> strongPoints=this.humanBiz.getAllStrongPoints();
		List<ConfigPublicChar> hobbys=this.humanBiz.getAllHobbys();
		List<ConfigPublicChar> educationsYears=this.humanBiz.getAllEducationsYears();
		List<SalaryStandard> salaryStandard=this.humanBiz.getAllSalaryStandard();
		List<ConfigPublicChar> technicalTitles=this.humanBiz.getAllTechnicalTitles();
		List<ConfigPublicChar> nationalitys=this.humanBiz.getAllNationalitys();
		List<ConfigPublicChar> nations=this.humanBiz.getAllNations();
		List<ConfigPublicChar> religiousBeliefs=this.humanBiz.getAllReligiousBeliefs();
		List<ConfigPublicChar> politicalStatus=this.humanBiz.getAllPoliticalStatus();
		
		mv.addObject("humanFileCheck", list.get(0));
		mv.addObject("salaryStandard", salaryStandard);
		mv.addObject("educationsYears", educationsYears);
		mv.addObject("hobbys", hobbys);
		mv.addObject("strongPoints", strongPoints);
		mv.addObject("educations", educations);
		mv.addObject("schooling", schooling);
		mv.addObject("technicalTitles",technicalTitles);
		mv.addObject("nationalitys", nationalitys);
		mv.addObject("nations", nations);
		mv.addObject("religiousBeliefs", religiousBeliefs);
		mv.addObject("politicalStatus",politicalStatus);
		return mv;
	}
	@RequestMapping(value="/selectConfigMajorByKind")
	public @ResponseBody void selectConfigMajorByKind(HttpServletResponse response,@RequestParam String  major_kind_id) throws IOException{
		response.setCharacterEncoding("utf-8");
		ConfigMajor configMajor=new ConfigMajor();
		configMajor.setMajor_kind_id(major_kind_id);
		List<ConfigMajor> list=this.humanBiz.selectConfigMajorByKind(configMajor);
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		out.print( gson.toJson(list));
	}
	@RequestMapping(value="/findAllConfigMajorKind")
	public @ResponseBody void findAllConfigMajorKind(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		List<ConfigMajorKind> list=this.humanBiz.getAllConfigMajorKinds();
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		out.print( gson.toJson(list));
	}
	@RequestMapping(value="tohumanResourceFileRegistrationReview")
	public ModelAndView tohumanResourceFileRegistrationReview(){//
		ModelAndView mv=new ModelAndView("humanResourceFileRegistrationReview");
		HumanFile humanFile1=new HumanFile();
		humanFile1.setCheck_status(0);
		humanFile1.setMinPage(0);
		humanFile1.setMaxPage(100000);
		List<HumanFile> humanFile=this.humanBiz.findtHumanFileByCheck(humanFile1);
		mv.addObject("humanFileSize",humanFile.size());
		return mv;
	}
	//人力资源档案复核 
	@RequestMapping(value="/checkHumanFile")
	public @ResponseBody void checkHumanFile(HttpServletResponse response,HttpServletRequest request,HumanFile humanFile) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		SalaryStandard salaryStandard=new SalaryStandard();
		salaryStandard.setStandard_id(humanFile.getSalary_standard_id());
		List<SalaryStandard> ss=humanBiz.selectSalaryStandardById(salaryStandard);
		humanFile.setSalary_standard_name(ss.get(0).getStandard_name());
		humanFile.setSalary_sum(ss.get(0).getSalary_sum());
		
		humanFile.setCheck_status(1);
		humanFile.setLastly_change_time(new Date());
		try {
			this.humanBiz.updateHumanFileById(humanFile);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
	}
	//更改用户照片
	@RequestMapping(value="toChangePhoto/{id}")
	public ModelAndView toChangePhoto(@PathVariable String id){//查看待复核人详情
		ModelAndView mv=new ModelAndView("changePhoto");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(id);
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		mv.addObject("humanFileCheck", list.get(0));
		return mv;
	}
	//changePicture
	@RequestMapping(value="changePicture")
	public @ResponseBody void changePicture(HttpServletResponse response,HttpServletRequest request,HumanFile humanFile) throws IOException{//查看待复核人详情
		String human_picture="";
		//上传
		Map<String,UploadFile> map=UploadFileUtil.uploadFile(request, humanFile.getPicUrl(), "HumanFilePicture");
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			human_picture+=  uploadFile.getNewFileUrl();
		}
		humanFile.setHuman_picture(human_picture);
		try {
			this.humanBiz.updateHumanFilePictureById(humanFile);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
		
	}
	//查寻操作
	@RequestMapping(value="/selectHumanFileBy")
	public ModelAndView selectHumanFileBy(@RequestParam String mindate,String maxdate,String firstKindId,String secondKindId,String thirdKindId,String human_major_kind_id,String human_major_id) throws IOException, ParseException{
		ModelAndView mv=new ModelAndView("humanResourceFileQueryEnd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		HumanFile humanFile=new HumanFile();
		if(!firstKindId.equals("")){
			humanFile.setFirst_kind_id(firstKindId);
			mv.addObject("firstKindId",firstKindId);
		}
		if(!secondKindId.equals("")){
			humanFile.setSecond_kind_id(secondKindId);
			mv.addObject("secondKindId", secondKindId);
		}
		if(!thirdKindId.equals("")){
			humanFile.setThird_kind_id(thirdKindId);
			mv.addObject("thirdKindId",thirdKindId);
		}
		if(!human_major_kind_id.equals("")){
			humanFile.setHuman_major_kind_id(human_major_kind_id);
			mv.addObject("human_major_kind_id", human_major_kind_id);
		}
		if(!human_major_id.equals("")){
			humanFile.setHuman_major_id(human_major_id);
			mv.addObject("human_major_id",human_major_id);
		}
		if(!mindate.equals("")){
			Date minDate=dateFormat.parse(mindate);
			humanFile.setMinDate(minDate);
			mv.addObject("mindate", mindate);
			if(!maxdate.equals("")){
				Date maxDate=dateFormat.parse(maxdate);
				humanFile.setMaxDate(maxDate);
				mv.addObject("maxdate",maxdate);
			}else{
				humanFile.setMaxDate(new Date());
				mv.addObject("maxdate",dateFormat.format(new Date()));
			}
		}
		List<HumanFile> list=humanBiz.selectHumanFileBy(humanFile);
		mv.addObject("size",list.size());
		return mv;
	}
	
	//
	@RequestMapping(value="/findtHumanFileBy")
	public @ResponseBody void findtHumanFileBy(HttpServletResponse response,@RequestParam String mindate,String maxdate,String firstKindId,String secondKindId,String thirdKindId,String human_major_kind_id,String human_major_id,int page,int rows) throws IOException, ParseException{
		response.setCharacterEncoding("utf-8");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		HumanFile humanFile=new HumanFile();
		if(!firstKindId.equals("")){
			humanFile.setFirst_kind_id(firstKindId);
		}
		if(!secondKindId.equals("")){
			humanFile.setSecond_kind_id(secondKindId);
		}
		if(!thirdKindId.equals("")){
			humanFile.setThird_kind_id(thirdKindId);
		}
		if(!human_major_kind_id.equals("")){
			humanFile.setHuman_major_kind_id(human_major_kind_id);
		}
		if(!human_major_id.equals("")){
			humanFile.setHuman_major_id(human_major_id);
		}
		if(!mindate.equals("")){
			Date minDate=dateFormat.parse(mindate);
			humanFile.setMinDate(minDate);
			System.out.println("-----------"+maxdate.getClass().getName());
			if(!maxdate.equals("")){
				
				Date maxDate=dateFormat.parse(maxdate);
				humanFile.setMaxDate(maxDate);
			}else{
				humanFile.setMaxDate(new Date());
			}
		}
		humanFile.setMinPage(rows*(page-1));
		humanFile.setMaxPage(rows);
		System.out.println("==="+humanFile.toString());
		List<HumanFile> list=humanBiz.selectHumanFileBy(humanFile);
		System.out.println("+++++++++++++++"+list.size());
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		humanFile.setMinPage(0);
		humanFile.setMaxPage(1000000);
		int size=humanBiz.selectHumanFileBy(humanFile).size();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd));
	}
	//
	@RequestMapping(value="tohumanFileDetails/{id}")
	public ModelAndView tohumanFileDetails(@PathVariable String id,Model model){//查看待复核人详情
		ModelAndView mv=new ModelAndView("HumanFileDetails");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(id);
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		List<ConfigPublicChar> schooling=this.humanBiz.getAllSchooling();
		List<ConfigPublicChar> educations=this.humanBiz.getAllEducations();
		List<ConfigPublicChar> strongPoints=this.humanBiz.getAllStrongPoints();
		List<ConfigPublicChar> hobbys=this.humanBiz.getAllHobbys();
		List<ConfigPublicChar> educationsYears=this.humanBiz.getAllEducationsYears();
		List<SalaryStandard> salaryStandard=this.humanBiz.getAllSalaryStandard();
		List<ConfigPublicChar> technicalTitles=this.humanBiz.getAllTechnicalTitles();
		List<ConfigPublicChar> nationalitys=this.humanBiz.getAllNationalitys();
		List<ConfigPublicChar> nations=this.humanBiz.getAllNations();
		List<ConfigPublicChar> religiousBeliefs=this.humanBiz.getAllReligiousBeliefs();
		List<ConfigPublicChar> politicalStatus=this.humanBiz.getAllPoliticalStatus();
		
		mv.addObject("humanFileCheck", list.get(0));
		mv.addObject("salaryStandard", salaryStandard);
		mv.addObject("educationsYears", educationsYears);
		mv.addObject("hobbys", hobbys);
		mv.addObject("strongPoints", strongPoints);
		mv.addObject("educations", educations);
		mv.addObject("schooling", schooling);
		mv.addObject("technicalTitles",technicalTitles);
		mv.addObject("nationalitys", nationalitys);
		mv.addObject("nations", nations);
		mv.addObject("religiousBeliefs", religiousBeliefs);
		mv.addObject("politicalStatus",politicalStatus);
		return mv;
	}
//
	@RequestMapping(value="tohumanResourceFileQueryEnd")
	public ModelAndView tohumanResourceFileQueryEnd(){//查看待复核人详情
		ModelAndView mv=new ModelAndView("humanResourceFileQueryEnd");
		return mv;
	}
	//变更
	@RequestMapping(value="tohumanResourceFileUpdate/{id}")
	public ModelAndView tohumanResourceFileUpdate(@PathVariable String id,Model model){//查看待复核人详情
		ModelAndView mv=new ModelAndView("humanResourceFileUpdate");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(id);
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		List<ConfigPublicChar> schooling=this.humanBiz.getAllSchooling();
		List<ConfigPublicChar> educations=this.humanBiz.getAllEducations();
		List<ConfigPublicChar> strongPoints=this.humanBiz.getAllStrongPoints();
		List<ConfigPublicChar> hobbys=this.humanBiz.getAllHobbys();
		List<ConfigPublicChar> educationsYears=this.humanBiz.getAllEducationsYears();
		List<SalaryStandard> salaryStandard=this.humanBiz.getAllSalaryStandard();
		List<ConfigPublicChar> technicalTitles=this.humanBiz.getAllTechnicalTitles();
		List<ConfigPublicChar> nationalitys=this.humanBiz.getAllNationalitys();
		List<ConfigPublicChar> nations=this.humanBiz.getAllNations();
		List<ConfigPublicChar> religiousBeliefs=this.humanBiz.getAllReligiousBeliefs();
		List<ConfigPublicChar> politicalStatus=this.humanBiz.getAllPoliticalStatus();
		
		mv.addObject("humanFileCheck", list.get(0));
		mv.addObject("salaryStandard", salaryStandard);
		mv.addObject("educationsYears", educationsYears);
		mv.addObject("hobbys", hobbys);
		mv.addObject("strongPoints", strongPoints);
		mv.addObject("educations", educations);
		mv.addObject("schooling", schooling);
		mv.addObject("technicalTitles",technicalTitles);
		mv.addObject("nationalitys", nationalitys);
		mv.addObject("nations", nations);
		mv.addObject("religiousBeliefs", religiousBeliefs);
		mv.addObject("politicalStatus",politicalStatus);
		return mv;
	}
	//人力资源档案更改
		@RequestMapping(value="/updateHumanFile")
		public @ResponseBody void updateHumanFile(HttpServletResponse response,HttpServletRequest request,HumanFile humanFile) throws IOException{
			response.setCharacterEncoding("utf-8");
			SalaryStandard salaryStandard=new SalaryStandard();
			salaryStandard.setStandard_id(humanFile.getSalary_standard_id());
			List<SalaryStandard> ss=humanBiz.selectSalaryStandardById(salaryStandard);
			humanFile.setSalary_standard_name(ss.get(0).getStandard_name());
			humanFile.setSalary_sum(ss.get(0).getSalary_sum());
			
			humanFile.setCheck_status(2);//更改待复核 
			humanFile.setLastly_change_time(new Date());
			try {
				this.humanBiz.changeHumanFileById(humanFile);
				PrintWriter out = response.getWriter();
				out.print(1);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.print(0);
			}
		}
	
}
