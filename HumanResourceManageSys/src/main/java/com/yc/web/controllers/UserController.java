package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Users;
import com.yc.biz.UserBiz;

@Controller
public class UserController {
	private UserBiz userBiz;
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
}
