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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;
import com.yc.web.utils.RandomNumberUtil;
import com.yc.web.utils.ResponseData;
import com.yc.web.utils.UUIDUtil;
import com.yc.web.utils.UploadFileUtil;
import com.yc.web.utils.UploadFileUtil.UploadFile;

@Controller
public class HumanFileController {
	private HumanBiz humanBiz;
	
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
		System.out.println("地址"+humanFile.getSecond_kind_id());
		Map<String,UploadFile> map=UploadFileUtil.uploadFile(request, humanFile.getPicUrl(), "HumanFilePicture");
		for(Entry<String,UploadFile> entry:map.entrySet()){
			UploadFile uploadFile=entry.getValue();
			human_picture+=  uploadFile.getNewFileUrl();
		}
		humanFile.setHuman_picture(human_picture);
		humanFile.setHuman_id(u.getUuidUtil());
		humanFile.setHuman_file_status(false);
		humanFile.setCheck_status(0);
		this.humanBiz.save(humanFile);
		PrintWriter out = response.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(1));
	}
	//人力资源档案查寻（复核状态）
	@RequestMapping(value="/findtHumanFileByCheck")
	public @ResponseBody void findtHumanFileByCheck(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		List<HumanFile> humanFile=this.humanBiz.findtHumanFileByCheck(rows*(page-1), rows);
		PrintWriter out = response.getWriter();
		int size=humanBiz.findtHumanFileByCheck(0, 1000000).size();
		Gson gson=new Gson();
		ResponseData rd=new ResponseData();
		rd.setRows(humanFile);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd)); 
	}
	@RequestMapping(value="tohumanResourceFileRegistrationReviewEnd/{id}")
	public ModelAndView tohumanResourceFileRegistrationReviewEnd(@PathVariable String id){//查看待复核人详情
		ModelAndView mv=new ModelAndView("humanResourceFileRegistrationReviewEnd");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(id);
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		mv.addObject("humanFileCheck", list.get(0));
		return mv;
	}
}
