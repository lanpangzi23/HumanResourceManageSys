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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;
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
	public String saveHumanFile(HttpServletRequest request,HumanFile humanFile){
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
		this.humanBiz.save(humanFile);
		return "humanResourceRegistration";
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
}
