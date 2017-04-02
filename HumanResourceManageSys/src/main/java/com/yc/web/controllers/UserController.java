package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.HumanFile;
import com.yc.bean.Users;
import com.yc.biz.HumanBiz;
import com.yc.biz.UserBiz;
import com.yc.web.utils.ResponseData;

@Controller
public class UserController {
	private UserBiz userBiz;
	private HumanBiz humanBiz;
	@Resource(name="humanBizImpl")
	public void setHumanBiz(HumanBiz humanBiz) {
		this.humanBiz = humanBiz;
	}
	@Resource(name="userBizImpl")
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	//判断有无该用户 
	@RequestMapping(value="/checkUserName")
	public @ResponseBody void checkHumanCardId(HttpServletResponse response,@RequestParam String uname) throws IOException{
		response.setCharacterEncoding("utf-8");
		Users users=new Users();
		
		users.setU_name(uname);
		List<Users> users1=this.userBiz.selectUserByName(users);
		if(users1.size()>0){
			PrintWriter out = response.getWriter();
			out.print(1); 
		}else{
			PrintWriter out = response.getWriter();
			out.print(0);
		}
	}
	//登录
	@RequestMapping(value="/UserLogin")
	public @ResponseBody void UserLogin(HttpServletResponse response,@RequestParam String uname,String upwd,HttpSession session) throws IOException{
		response.setCharacterEncoding("utf-8");
		session.removeAttribute("uname");
		Users users=new Users();
		users.setU_name(uname);
		users.setU_password(upwd);
		List<Users> users1=this.userBiz.selectUserByName(users);
		if(users1.size()>0){
			session.setAttribute("uname", uname);
			session.setAttribute("role", users1.get(0).getU_role());
			session.setAttribute("uid", users1.get(0).getU_id());
			PrintWriter out = response.getWriter();
			out.print(1); 
		}else{
			PrintWriter out = response.getWriter();
			out.print(0);
		}
	}
	//退出登录
	@RequestMapping(value="/logout")
	public String adminLogin(HttpSession session){
		session.removeAttribute("uname");
		session.removeAttribute("role");
		return "adminLogin";
	}
	//查看所有用户
	@RequestMapping(value="/findtHumanFileByMaior")
	public @ResponseBody void findtHumanFileBy(HttpServletResponse response,@RequestParam String human_pro_designation,int page,int rows) throws IOException, ParseException{
		response.setCharacterEncoding("utf-8");
		HumanFile humanFile=new HumanFile();
		
		if(!human_pro_designation.equals("")){
			humanFile.setHuman_pro_designation(human_pro_designation);
		}
		humanFile.setMinPage(rows*(page-1));
		humanFile.setMaxPage(rows);
		System.out.println(humanFile);
		List<HumanFile> list=humanBiz.selectHumanFileBydesignation(humanFile);
		Gson gson=new Gson();
		PrintWriter out = response.getWriter();
		humanFile.setMinPage(0);
		humanFile.setMaxPage(1000000);
		int size=humanBiz.selectHumanFileBydesignation(humanFile).size();
		ResponseData rd=new ResponseData();
		rd.setRows(list);
		rd.setTotal(""+size);
		out.print(gson.toJson(rd));
	}
	//后台管理员的添加
	@RequestMapping(value="/addBackAdmin")
	public @ResponseBody void addBackAdmin(HttpServletResponse response,@RequestParam String humanid) throws IOException, ParseException{
		response.setCharacterEncoding("utf-8");
		HumanFile humanFile=new HumanFile();
		humanFile.setHuman_id(humanid);
		Users users1=new Users();
		users1.setU_human_id(humanid);
		List<Users> users2=this.userBiz.selectUserByHumanId(users1);
		if(users2.size()>0){
			PrintWriter out = response.getWriter();
			out.print(2);
		}else{
		List<HumanFile> list=humanBiz.selectHumanFileById(humanFile);
		Users users=new Users();
		users.setU_human_id(humanid);
		users.setU_name(list.get(0).getHuman_name());
		users.setU_true_name(list.get(0).getHuman_name());
		String str=list.get(0).getHuman_id_card().substring(list.get(0).getHuman_id_card().length()-6,list.get(0).getHuman_id_card().length());
		users.setU_password(str);
		users.setU_role(list.get(0).getHuman_pro_designation());
		try {
			Users u=this.userBiz.save(users);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
		}
		
	}
	//
	@RequestMapping(value="/findtAdminUser")
	public @ResponseBody void findtAdminUser(HttpServletResponse response,int page,int rows) throws IOException{
		response.setCharacterEncoding("utf-8");
		Gson gson=new Gson();
		Users user=new Users();
		user.setMinPage(rows*(page-1));
		user.setMaxPage(rows);
		List<Users> users1=this.userBiz.getAllUsers(user);
		user.setMinPage(0);
		user.setMaxPage(100000);
		int size=this.userBiz.getAllUsers(user).size();
		ResponseData rd=new ResponseData();
		rd.setRows(users1);
		rd.setTotal(""+size);
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(rd));
	}
	@RequestMapping(value="/deleteAdmin")
	public @ResponseBody void deleteAdmin(HttpServletResponse response,@RequestParam int u_id) throws IOException{
		response.setCharacterEncoding("utf-8");
		Users users=new Users();
		users.setU_id(u_id);
		try {
			Users u=this.userBiz.deleteUsers(users);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
		
	}
	//
	@RequestMapping(value="/UserUpdate")
	public @ResponseBody void UserUpdates(HttpServletResponse response,@RequestParam String uname,String upwd,HttpSession session,int uid) throws IOException{
		response.setCharacterEncoding("utf-8");
		Users users=new Users();
		users.setU_name(uname);
		users.setU_password(upwd);
		users.setU_id(uid);
		try {
			Users users1=this.userBiz.updateUsers(users);
			PrintWriter out = response.getWriter();
			out.print(1);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.print(0);
		}
		
		
	}
}
