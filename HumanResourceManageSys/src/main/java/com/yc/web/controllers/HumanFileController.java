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
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;
import com.yc.biz.OrganizationBiz;
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
	@RequestMapping(value="/findSecondKindByFirstKindId")
	public @ResponseBody String findSecondByFirst(@RequestParam String  first_kind_id){
		List<ConfigFileSecondKind> list=this.organizationBiz.getAllConfigFileSecondKindsByFirst(first_kind_id);
		Gson gson=new Gson();
		return gson.toJson(list);
	}
	// 机构级联1
		@RequestMapping(value = "/findFirstKind")
		public @ResponseBody void findFirstKind(HttpServletResponse response) throws Exception {
			response.setCharacterEncoding("utf-8");
			List<ConfigFileFirstKind> configFileFirstKinds=this.organizationBiz.getAllConfigFileFirstKinds();
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(configFileFirstKinds));
		}
		@RequestMapping(value="/deleteFirstKind")
		public @ResponseBody void deleteFirstKind(HttpServletResponse response,@RequestParam String  first_kind_id) throws IOException{
			System.out.println("``````````"+first_kind_id);
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFirst_kind_id(first_kind_id);
			List<ConfigFileFirstKind> list=(List<ConfigFileFirstKind>) this.organizationBiz.deleteConfigFileFirstKind(configFileFirstKind);
			PrintWriter out = response.getWriter();
			Gson gson=new Gson();
			out.print( gson.toJson(list));
		}

	
	

}
