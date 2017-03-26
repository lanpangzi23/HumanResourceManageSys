package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigFileThirdKind;
import com.yc.bean.ConfigPublicChar;
import com.yc.biz.OrganizationBiz;
import com.yc.web.utils.ResponseData;
import com.yc.web.utils.UUIDUtil;
@Controller
public class OrganizationController {
	private OrganizationBiz organizationBiz;
	@Resource(name="organizationBizImpl")
	public void setOrganizationBiz(OrganizationBiz organizationBiz) {
		this.organizationBiz = organizationBiz;
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
		// 一级机构分页查寻
				@RequestMapping(value = "/findAllFirstKind")
				public @ResponseBody void findAllFirstKind(HttpServletResponse response) throws Exception {
					
					response.setCharacterEncoding("utf-8");
					List<ConfigFileFirstKind> configFileFirstKinds=this.organizationBiz.getAllConfigFileFirstKinds();
					PrintWriter out = response.getWriter();
					Gson gson=new Gson();
					out.print(gson.toJson(configFileFirstKinds)); 
				}
		// 二级机构分页查寻
				@RequestMapping(value = "/findSecondKindByPage")
				public @ResponseBody void findSecondKindByPage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws Exception {
					response.setCharacterEncoding("utf-8");
					List<ConfigFileSecondKind> configFileSecondKinds=this.organizationBiz.findConfigFileSecondKindByPage(rows*(page-1), rows);
					PrintWriter out = response.getWriter();
					int size=organizationBiz.findConfigFileSecondKindByPage(0, 10000).size();
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
					int size=organizationBiz.findConfigFileThirdKindByPage(0, 10000).size();
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
				ConfigFileFirstKind list=this.organizationBiz.deleteConfigFileFirstKind(configFileFirstKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 1 );
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			
		}
		//二级机构删除
				@RequestMapping(value="/deleteSecondKind")
				public @ResponseBody void deleteSecondKind(HttpServletResponse response,@RequestParam String  fsk_id) throws IOException{
					ConfigFileSecondKind configFileSecondKind=new ConfigFileSecondKind();
					configFileSecondKind.setFsk_id(Integer.parseInt(fsk_id));
					try {
					ConfigFileSecondKind list= this.organizationBiz.deleteConfigFileSecondKind(configFileSecondKind);
						PrintWriter out = response.getWriter();
						Gson gson=new Gson();
						out.print( 1 );
					} catch (Exception e) {
						PrintWriter out = response.getWriter();
						Gson gson=new Gson();
						out.print( 0 );
					}
					
				}
				//三级机构删除
				@RequestMapping(value="/deleteThirdKind")
				public @ResponseBody void deleteThirdKind(HttpServletResponse response,@RequestParam String  ftk_id) throws IOException{
					ConfigFileThirdKind configFileThirdKind=new ConfigFileThirdKind();
					configFileThirdKind.setFtk_id(Integer.parseInt(ftk_id));
					try {
						ConfigFileThirdKind list=this.organizationBiz.deleteConfigFileThirdKind(configFileThirdKind);
						PrintWriter out = response.getWriter();
						Gson gson=new Gson();
						out.print( 1 );
					} catch (Exception e) {
						PrintWriter out = response.getWriter();
						Gson gson=new Gson();
						out.print( 0 );
					}
					
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
				ConfigFileFirstKind list=this.organizationBiz.save(configFileFirstKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 1 );
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			
		}}
		//二级机构添加
		@RequestMapping(value="/addSecondKind")
		public @ResponseBody void addSecondKind(HttpServletResponse response,@RequestParam String  firstKindName,String firstKindId,String secondKindName,String secondKindSalaryId,String secondKindSaleId) throws IOException{
			ConfigFileSecondKind configFileSecondKind=new ConfigFileSecondKind();
			configFileSecondKind.setSecond_kind_id(UUIDUtil.getASIC());
			configFileSecondKind.setFirst_kind_id(firstKindId);
			configFileSecondKind.setFirst_kind_name(firstKindName);
			configFileSecondKind.setSecond_kind_name(secondKindName);
			configFileSecondKind.setSecond_salary_id(secondKindSalaryId);
			configFileSecondKind.setSecond_sale_id(secondKindSaleId);
			List<ConfigFileSecondKind> list1=this.organizationBiz.findConfigFileSecondKindByName(configFileSecondKind);
			if(list1.size()>0){
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 2 );
			}else{
			try {
				ConfigFileSecondKind list=this.organizationBiz.saveConfigFileSecondKind(configFileSecondKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 1 );
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			
		}}
		//三及机构添加
		@RequestMapping(value="/addThirdKind")
		//thirdKindIsRetail,secondKindId,secondKindName,thirdKindName,firstKindName,firstKindId,thirdKindSalaryId
		public @ResponseBody void addThirdKind(HttpServletResponse response,@RequestParam String thirdKindIsRetail,String secondKindId,String secondKindName,String thirdKindName,String firstKindName,String firstKindId,String thirdKindSaleId) throws IOException{
			ConfigFileThirdKind configFileThirdKind=new ConfigFileThirdKind();
			configFileThirdKind.setThird_kind_id(UUIDUtil.getASIC());
			configFileThirdKind.setFirst_kind_id(firstKindId);
			configFileThirdKind.setFirst_kind_name(firstKindName);
			configFileThirdKind.setSecond_kind_id(secondKindId);
			configFileThirdKind.setSecond_kind_name(secondKindName);
			configFileThirdKind.setThird_kind_name(thirdKindName);
			configFileThirdKind.setThird_kind_is_retail(thirdKindIsRetail);
			configFileThirdKind.setThird_kind_sale_id(thirdKindSaleId);
		
			List<ConfigFileThirdKind> list1=this.organizationBiz.findConfigFileThirdKindByName(configFileThirdKind);
			if(list1.size()>0){
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 2 );
			}else{
			try {
				ConfigFileThirdKind list= this.organizationBiz.saveConfigFileThirdKind(configFileThirdKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 1 );
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
		}}
		//1.修改                                                                                                                               
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
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(1);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(0);
			}
		}
		//2.修改                                                                                                                               
		@RequestMapping(value="/updateSecondKind")
		public @ResponseBody void updateSecondKind(HttpServletResponse response,@RequestParam String  firstKindName,String firstKindId,String secondKindName,String secondKindSalaryId,String secondKindSaleId,String fskid) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileSecondKind configFileSecondKind=new ConfigFileSecondKind();
			configFileSecondKind.setFsk_id(Integer.parseInt(fskid));
			configFileSecondKind.setFirst_kind_name(firstKindName);
			configFileSecondKind.setFirst_kind_id(firstKindId);
			configFileSecondKind.setSecond_kind_name(secondKindName);
			configFileSecondKind.setSecond_salary_id(secondKindSalaryId);
			configFileSecondKind.setSecond_sale_id(secondKindSaleId);
			try {
				ConfigFileSecondKind list1=this.organizationBiz.updateConfigFileSecondKind(configFileSecondKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(1);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(0);
			}
		}
		//3.修改
		@RequestMapping(value="/updateThirdKind")
		public @ResponseBody void updateThirdKind(HttpServletResponse response,@RequestParam String  firstKindName,String firstKindId,String secondKindName,String secondKindId,String thirdKindSaleId,String thirdKindIsRetail,String ftkid,String thirdKindName) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileThirdKind configFileThirdKind=new ConfigFileThirdKind();
			configFileThirdKind.setFtk_id(Integer.parseInt(ftkid));
			configFileThirdKind.setFirst_kind_name(firstKindName);
			configFileThirdKind.setFirst_kind_id(firstKindId);
			configFileThirdKind.setSecond_kind_name(secondKindName);
			configFileThirdKind.setSecond_kind_id(secondKindId);
			configFileThirdKind.setThird_kind_name(thirdKindName);
			configFileThirdKind.setThird_kind_is_retail(thirdKindIsRetail);
			configFileThirdKind.setThird_kind_sale_id(thirdKindSaleId);
			try {
				ConfigFileThirdKind list1=this.organizationBiz.updateConfigFileThirdKind(configFileThirdKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(1);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(0);
			}
		}		
		//1.
		//修改前显示                                                                                                                              
		@RequestMapping(value="/findFirstKindByName")
		public @ResponseBody void findFirstKindByName(HttpServletResponse response,@RequestParam String  first_kind_name) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileFirstKind configFileFirstKind=new ConfigFileFirstKind();
			configFileFirstKind.setFirst_kind_name(first_kind_name);
			List<ConfigFileFirstKind> list1=this.organizationBiz.findConfigFileFirstKindByName(configFileFirstKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(gson.toJson(list1));
		}
		//2.修改前显示     
		@RequestMapping(value="/findSecondKindByName")
		public @ResponseBody void findSecondKindByName(HttpServletResponse response,@RequestParam String  fsk_id) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileSecondKind configFileSecondKind=new ConfigFileSecondKind();
			configFileSecondKind.setFsk_id(Integer.parseInt(fsk_id));
			List<ConfigFileSecondKind> list1=this.organizationBiz.findConfigFileSecondKindByName(configFileSecondKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(gson.toJson(list1));
		}
		//3.修改前显示     
		@RequestMapping(value="/alertThirdKind")
		public @ResponseBody void alertThirdKind(HttpServletResponse response,@RequestParam String  ftk_id) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigFileThirdKind configFileThirdKind=new ConfigFileThirdKind();
			configFileThirdKind.setFtk_id(Integer.parseInt(ftk_id));
			List<ConfigFileThirdKind> list1=this.organizationBiz.findConfigFileThirdKindByName(configFileThirdKind);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(gson.toJson(list1));
		}		
		//根据一级机构查寻二级机构
		@RequestMapping(value="/findSecondKindByFirst")
		public @ResponseBody void findSecondKindByFirst(HttpServletResponse response,@RequestParam String  first_kind_id) throws IOException{
			response.setCharacterEncoding("utf-8");
			List<ConfigFileSecondKind> list1=this.organizationBiz.getAllConfigFileSecondKindsByFirst(first_kind_id);
			PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(gson.toJson(list1));
		}
		//根据二级机构查寻三级机构
		@RequestMapping(value="/findThirdKindBySecondKindId")
		public @ResponseBody void findThirdKindBySecondKindId(HttpServletResponse response,@RequestParam String  second_kind_id) throws IOException{
			response.setCharacterEncoding("utf-8");
			List<ConfigFileThirdKind> list1=this.organizationBiz.getAllConfigFileThirdKindsBySecond(second_kind_id);
			PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(gson.toJson(list1));
		}
		//公共字段的添加
		@RequestMapping(value="/addConfigPublicChar")
		public @ResponseBody void addConfigPublicChar(HttpServletResponse response,@RequestParam String  attribute_kind,String attribute_name) throws IOException{
			response.setCharacterEncoding("utf-8");
			ConfigPublicChar configPublicChar=new ConfigPublicChar();
			configPublicChar.setAttribute_kind(attribute_kind);
			configPublicChar.setAttribute_name(attribute_name);
			List<ConfigPublicChar> list=this.organizationBiz.selectAllConfigPublicCharByName(configPublicChar);
			if(list.size()>0){
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(2);
			}else{
			try {
				ConfigPublicChar list1=this.organizationBiz.saveConfigPublicChar(configPublicChar);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(1);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print(0);
			}
		}
	}
		//公共字段分页查寻
		@RequestMapping(value = "/findConfigPublicCharsByPage")
		public @ResponseBody void findConfigPublicCharsByPage(HttpServletResponse response,@RequestParam int page,@RequestParam int rows) throws Exception {
			response.setCharacterEncoding("utf-8");
			ConfigPublicChar configPublicChar=new ConfigPublicChar();
			configPublicChar.setMinPage(rows*(page-1));
			configPublicChar.setMaxPage(rows);
			List<ConfigPublicChar> list=this.organizationBiz.findConfigPublicCharsByPage(configPublicChar);
			PrintWriter out = response.getWriter();
			ConfigPublicChar configPublicChar1=new ConfigPublicChar();
			configPublicChar1.setMinPage(0);
			configPublicChar1.setMaxPage(1000000);
			int size=organizationBiz.findConfigPublicCharsByPage(configPublicChar1).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(list);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
		//公共字段删除
		@RequestMapping(value="/deleteConfigPublicChar")
		public @ResponseBody void deleteConfigPublicChar(HttpServletResponse response,@RequestParam String  pbc_id) throws IOException{
			ConfigPublicChar configPublicChar=new ConfigPublicChar();
			configPublicChar.setPbc_id(Integer.parseInt(pbc_id));
			try {
				ConfigPublicChar list=this.organizationBiz.deleteConfigPublicChar(configPublicChar);
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 1 );
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				Gson gson=new Gson();
				out.print( 0 );
			}
			
		}
	//根据公共类别查寻
		@RequestMapping(value = "/findConfigPublicCharByKind")
		public @ResponseBody void findConfigPublicCharByKind(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,String attribute_kind) throws Exception {
			response.setCharacterEncoding("utf-8");
			ConfigPublicChar configPublicChar=new ConfigPublicChar();
			configPublicChar.setMinPage(rows*(page-1));
			configPublicChar.setMaxPage(rows);
			configPublicChar.setAttribute_kind(attribute_kind);
			List<ConfigPublicChar> list=this.organizationBiz.findConfigPublicCharsByPage(configPublicChar);
			PrintWriter out = response.getWriter();
			ConfigPublicChar configPublicChar1=new ConfigPublicChar();
			configPublicChar1.setMinPage(0);
			configPublicChar1.setMaxPage(1000000);
			configPublicChar.setAttribute_kind(attribute_kind);
			int size=organizationBiz.findConfigPublicCharsByPage(configPublicChar).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(list);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
	//根据名字查寻
		@RequestMapping(value = "/findConfigPublicCharByKindByName")
		public @ResponseBody void findConfigPublicCharByKindByName(HttpServletResponse response,@RequestParam int page,@RequestParam int rows,String attribute_name) throws Exception {
			response.setCharacterEncoding("utf-8");
			ConfigPublicChar configPublicChar=new ConfigPublicChar();
			configPublicChar.setMinPage(rows*(page-1));
			configPublicChar.setMaxPage(rows);
			configPublicChar.setAttribute_name(attribute_name);
			List<ConfigPublicChar> list=this.organizationBiz.findConfigPublicCharsByPage(configPublicChar);
			PrintWriter out = response.getWriter();
			ConfigPublicChar configPublicChar1=new ConfigPublicChar();
			configPublicChar1.setMinPage(0);
			configPublicChar1.setMaxPage(1000000);
			configPublicChar.setAttribute_name(attribute_name);
			int size=organizationBiz.findConfigPublicCharsByPage(configPublicChar).size();
			Gson gson=new Gson();
			ResponseData rd=new ResponseData();
			rd.setRows(list);
			rd.setTotal(""+size);
			out.print(gson.toJson(rd)); 
		}
}
