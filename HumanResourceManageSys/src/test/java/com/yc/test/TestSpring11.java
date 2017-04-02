package com.yc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.EngageResume;
import com.yc.bean.EngageSubjects;
import com.yc.bean.HumanFile;
import com.yc.biz.PersonnelTransferBiz;
import com.yc.biz.RecruitmentManagementBiz;

import junit.framework.TestCase;

public class TestSpring11 extends TestCase {
	@Test
	public void test(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		PersonnelTransferBiz pt=ac.getBean("personnelTransferBizImpl",PersonnelTransferBiz.class);
		HumanFile humanfile =new HumanFile();
		List<HumanFile> list= pt.findPersonnel(humanfile);
		System.out.println(list);
	}
	@Test
	public void test2(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		RecruitmentManagementBiz rmbiz=(RecruitmentManagementBiz) ac.getBean("recruitmentManagementBizImpl");
		EngageSubjects es=new EngageSubjects();
		es.setFirst_kind_id("gr");
		es.setPage(0);
		es.setSize(10);
		System.out.println(rmbiz.findByChoose("gr", "", "","" , "", 0, 10));;
	}
}
