package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

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
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;
import com.yc.biz.OrganizationBiz;
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
	// 一级机构分页查寻
		@RequestMapping(value = "/findFirstKindByPage")
		public @ResponseBody void findFirstKind(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws Exception {
			
			response.setCharacterEncoding("utf-8");
			List<ConfigFileFirstKind> configFileFirstKinds=this.organizationBiz.findConfigFileFirstKindByPage(rows*(page-1), rows);
			PrintWriter out = response.getWriter();
			int size=organizationBiz.findConfigFileFirstKindByPage(0, 10000).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(configFileFirstKinds);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
		// 二级机构分页查寻
				@RequestMapping(value = "/findSecondKindByPage")
				public @ResponseBody void findSecondKindByPage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws Exception {
					response.setCharacterEncoding("utf-8");
					List<ConfigFileSecondKind> configFileSecondKinds=this.organizationBiz.findConfigFileSecondKindByPage(rows*(page-1), rows);
					PrintWriter out = response.getWriter();
					int size=organizationBiz.findConfigFileFirstKindByPage(0, 10000).size();
					Gson gson=new Gson();
					ResponseData rd=new ResponseData();
					rd.setRows(configFileSecondKinds);
					rd.setTotal(""+size);
					out.print(gson.toJson(rd)); 
				}
				// 三级机构分页查寻
				@RequestMapping(value = "/findThirdKindByPage")
				public @ResponseBody void findThirdKindByPage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws Exception {
					response.setCharacterEncoding("utf-8");
					List<ConfigFileThirdKind> configFileThirdKinds=this.organizationBiz.findConfigFileThirdKindByPage(rows*(page-1), rows);
					PrintWriter out = response.getWriter();
					int size=organizationBiz.findConfigFileFirstKindByPage(0, 10000).size();
					Gson gson=new Gson();
					ResponseData rd=new ResponseData();
					rd.setRows(configFileThirdKinds);
					rd.setTotal(""+size);
					out.print(gson.toJson(rd)); 
				}
		//一级机构删除
		@RequestMapping(value="/deleteFirstKind")
		public @ResponseBody void deleteFirstKind(HttpServletResponse response,@RequestParam String  ffk_id) throws IOException{
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFfk_id(Integer.parseInt(ffk_id));
			try {
				List<ConfigFileFirstKind> list=(List<ConfigFileFirstKind>) this.organizationBiz.deleteConfigFileFirstKind(configFileFirstKind);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			PrintWriter out = response.getWriter();
			Gson gson=new Gson();
			out.print( 1 );
		}
		//一级机构添加
		@RequestMapping(value="/addFirstKind")
		public @ResponseBody void addFirstKind(HttpServletResponse response,@RequestParam String  firstKindName,String firstKindSalaryId,String firstKindSaleId) throws IOException{
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFirst_kind_id(UUIDUtil.getASIC());
			configFileFirstKind.setFirst_kind_name(firstKindName);
			configFileFirstKind.setFirst_kind_salary_id(firstKindSalaryId);
			configFileFirstKind.setFirst_kind_sale_id(firstKindSaleId);
			List<ConfigFileFirstKind> list1=this.organizationBiz.findConfigFileFirstKindByName(configFileFirstKind);
			if(list1.size()>0){
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 2 );
			}else{
			try {
				List<ConfigFileFirstKind> list=(List<ConfigFileFirstKind>) this.organizationBiz.save(configFileFirstKind);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			PrintWriter out = response.getWriter();
			Gson gson=new Gson();
			out.print( 1 );
		}}
		@RequestMapping(value="/findFirstKindByName")
		public @ResponseBody void findFirstKindByName(HttpServletResponse response,@RequestParam String  first_kind_name) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFirst_kind_name(first_kind_name);
			List<ConfigFileFirstKind> list1=this.organizationBiz.findConfigFileFirstKindByName(configFileFirstKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				System.out.println(list1.get(0).getFirst_kind_name());
				out.print(gson.toJson(list1) );
		}
		//修改                                                                                                                               
		@RequestMapping(value="/updateFirstKind")
		public @ResponseBody void updateFirstKind(HttpServletResponse response,@RequestParam String  firstKindName,@RequestParam String  firstKindSalaryId,@RequestParam String  fkkid,@RequestParam String  firstKindSaleId) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFfk_id(Integer.parseInt(fkkid));
			configFileFirstKind.setFirst_kind_name(firstKindName);
			configFileFirstKind.setFirst_kind_salary_id(firstKindSalaryId);
			configFileFirstKind.setFirst_kind_sale_id(firstKindSaleId);
			try {
				ConfigFileFirstKind list1=this.organizationBiz.update(configFileFirstKind);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(0);
			}
			
		}
				


}
