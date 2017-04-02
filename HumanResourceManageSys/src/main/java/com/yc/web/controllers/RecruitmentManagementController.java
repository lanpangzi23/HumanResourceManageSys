package com.yc.web.controllers;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.google.gson.Gson;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.EngageInterview;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.bean.EngageSubjects;
import com.yc.biz.HumanBiz;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
import com.yc.web.utils.UploadFileUtil;
import com.yc.web.utils.UploadFileUtil.UploadFile;
@Controller
public class RecruitmentManagementController {
	private RecruitmentManagementBiz recruitmentManagementBizImpl;
	private HumanBiz humanBiz;
	@Resource(name="humanBizImpl")
	public void setHumanBiz(HumanBiz humanBiz) {
		this.humanBiz = humanBiz;
	}
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
	@RequestMapping(value="addEngageInterview")//面试登记
	public @ResponseBody void addEngageInterview(HttpServletResponse response,EngageInterview ei) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		ei.setInterview_amount(ei.getInterview_amount()+1);
		try{
			recruitmentManagementBizImpl.addEngageInterview(ei);
			recruitmentManagementBizImpl.updateEngageResume1(ei.getResume_id());
			out.print("登记成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			out.print(e.getMessage());
		}
	}
	@RequestMapping(value="addEngageResume")//简历登记
	public @ResponseBody void addEngageResume(HttpServletResponse response,EngageResume er,HttpServletRequest request) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String human_picture="";
		//上传
		Map<String,UploadFile> map=UploadFileUtil.uploadFile(request, er.getPicUrl(), "HumanFilePicture");
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			human_picture+=  uploadFile.getNewFileUrl();
		}
		er.setHuman_picture(human_picture);
		er.setCheck_status(0);;
		try{
			recruitmentManagementBizImpl.addEngageResume(er);
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
	@RequestMapping(value="updateEngageInterview")//面试修改
	public @ResponseBody void updateEngageInterview(HttpServletResponse response,EngageInterview ei) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			recruitmentManagementBizImpl.updateEngageInterview(ei);
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
	@RequestMapping(value="toFindEngageResume")
	public String toFindEngageResume(@RequestParam String minDate,@RequestParam String maxDate,@RequestParam String keyword,@RequestParam String id,Model model){
		EngageResume er=new EngageResume();
		er.setKeyword(keyword);
		er.setHuman_major_kind_id(id);
		model.addAttribute("engageResume",er);
		model.addAttribute("minDate", minDate);
		model.addAttribute("maxDate", maxDate);
		return "engageResumeInfo";
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
	@RequestMapping(value="findEngageResumeByPage")
	public @ResponseBody void findEngageResumeByPage(@RequestParam String minDate,@RequestParam String maxDate,@RequestParam String keyword,@RequestParam String id,HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<EngageResume> list=recruitmentManagementBizImpl.findEngageResume(null,rows*(page-1), rows, id, keyword, minDate, maxDate,null);
		int size=recruitmentManagementBizImpl.findEngageResume(null,null, null, id, keyword, minDate, maxDate,null).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="findEngageInterviewByPage")
	public @ResponseBody void findEngageInterviewByPage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<EngageInterview> list=recruitmentManagementBizImpl.findEngageInterview(null,rows*(page-1), rows);
		int size=recruitmentManagementBizImpl.findEngageInterview(null, null, null).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="findEngageResumeByPageUseful")//findEngageResumeByPageUseful查询有效的建立
	public @ResponseBody void findEngageResumeByPageUserful(@RequestParam String op,HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<EngageResume> list=recruitmentManagementBizImpl.findEngageResume(null,rows*(page-1), rows, null, null, null, null,op);
		int size=recruitmentManagementBizImpl.findEngageResume(null,null, null, null, null, null, null,op).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="findEngageSubjectsByPage")//
	public @ResponseBody void findEngageSubjectsByPage(@RequestParam String fid,HttpServletResponse response,@RequestParam int page,
			@RequestParam int rows,@RequestParam String sid,@RequestParam String keyword,@RequestParam String minDate,
			@RequestParam String maxDate) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<EngageSubjects> list=recruitmentManagementBizImpl.findByChoose(fid, sid, keyword, minDate, maxDate, (page-1)*rows, rows);
		int size=recruitmentManagementBizImpl.findByChoose(fid, sid, keyword, minDate, maxDate, null, null).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		System.out.println(list);
		rd.setRows(list);
		rd.setTotal(size+"");
		out.print(gson.toJson(rd));
	}
	@RequestMapping(value="findEngageResumeById/{id}")
	public String findEngageResumeById(@PathVariable Integer id,Model model){
		List<ConfigPublicChar> technicalTitles=this.humanBiz.getAllTechnicalTitles();
		model.addAttribute("technicalTitles",technicalTitles);
		List<ConfigPublicChar> nationalitys=this.humanBiz.getAllNationalitys();
		model.addAttribute("nationalitys",nationalitys);
		List<ConfigPublicChar> nations=this.humanBiz.getAllNations();
		model.addAttribute("nations",nations);
		List<ConfigPublicChar> religiousBeliefs=this.humanBiz.getAllReligiousBeliefs();
		model.addAttribute("religiousBeliefs",religiousBeliefs);
		List<ConfigPublicChar> politicalStatus=this.humanBiz.getAllPoliticalStatus();
		model.addAttribute("politicalStatus",politicalStatus);
		List<ConfigPublicChar> schooling=this.humanBiz.getAllSchooling();
		model.addAttribute("schooling",schooling);
		List<ConfigPublicChar> educations=this.humanBiz.getAllEducations();
		model.addAttribute("educations",educations);
		List<ConfigPublicChar> strongPoints=this.humanBiz.getAllStrongPoints();
		model.addAttribute("strongPoints",strongPoints);
		List<ConfigPublicChar> hobbys=this.humanBiz.getAllHobbys();
		model.addAttribute("hobbys",hobbys);
		List<ConfigPublicChar> educationsYears=this.humanBiz.getAllEducationsYears();
		model.addAttribute("educationsYears",educationsYears);
		List<EngageResume> list=recruitmentManagementBizImpl.findEngageResume(id, null, null, null, null, null, null,null);
		model.addAttribute("engageResume", list.get(0));
		return "updateEngageResumeInfo";
	}
	@RequestMapping(value="toInterviewRegistration/{id}")//面试登记
	public String toInterviewRegistration(@PathVariable Integer id,Model model){
		List<EngageResume> list=recruitmentManagementBizImpl.findEngageResume(id, null, null, null, null, null, null,null);
		List<EngageInterview> eiList=recruitmentManagementBizImpl.findEngageInterview(id,null,null);
		if(eiList!=null&&eiList.size()>0){
			model.addAttribute("count", eiList.get(0).getInterview_amount());
		}else{
			model.addAttribute("count", 0);
		}
		model.addAttribute("engageResume", list.get(0));
		return "InterviewRegistration";
	}
	@RequestMapping(value="toInterviewScreening/{id}")//面试筛选
	public String toInterviewScreening(@PathVariable Integer id,Model model){
		List<EngageResume> list=recruitmentManagementBizImpl.findEngageResume(id, null, null, null, null, null, null,null);
		model.addAttribute("engageResume", list.get(0));
		return "interviewScreening";
	}
	@RequestMapping(value="updateEngageResume")//修改简历
	public @ResponseBody void updateEngageResume(EngageResume er,HttpServletResponse response,HttpServletRequest request) throws IOException{
		if(er.getPicUrl()!=null){
			String human_picture="";
			//上传
			Map<String,UploadFile> map=UploadFileUtil.uploadFile(request, er.getPicUrl(), "HumanFilePicture");
			for(Entry<String,UploadFile> entry:map.entrySet()){
				UploadFile uploadFile=entry.getValue();
				human_picture+=  uploadFile.getNewFileUrl();
			}
			er.setHuman_picture(human_picture);
		}
		if(er.getRecomandation().equals("")){
			er.setRecomandation(null);
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			recruitmentManagementBizImpl.updateEngageResume(er);
			out.print("修改成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			out.print(e.getMessage());
		}
	}
	@RequestMapping(value="addEngageSubjects")
	public @ResponseBody void addEngageSubjects(EngageSubjects es){
		recruitmentManagementBizImpl.addEngageSubjects(es);
	}
	@RequestMapping(value="toFindByChoose")
	public String toFindByChoose(@RequestParam String minDate,@RequestParam String maxDate,@RequestParam String keyword,@RequestParam
			String fid,@RequestParam String sid,Model model){
		model.addAttribute("minDate", minDate);
		model.addAttribute("maxDate", maxDate);
		model.addAttribute("keyword", keyword);
		model.addAttribute("fid", fid);
		model.addAttribute("sid", sid);
		return "findEngageSubjectsByPage";
	}
}
