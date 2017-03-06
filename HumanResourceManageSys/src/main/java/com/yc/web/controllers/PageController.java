package com.yc.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping(value="/admin/index")
	public String toIndexPage(){
		return "index";
	}
	@RequestMapping(value="/admin/humanResourceRegistration")
	public String toHumanResourceRegistrationPage(){
		return "humanResourceRegistration";
	}
}
