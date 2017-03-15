package com.yc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.HumanFile;
import com.yc.biz.PersonnelTransferBiz;

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
		PersonnelTransferBiz pt=ac.getBean("personnelTransferBizImpl",PersonnelTransferBiz.class);
		HumanFile hf=new HumanFile();
		hf.setHuman_name("lisi");
		hf.setHuman_id_card("2");
		hf=pt.insert(hf);
		System.out.println(hf);
	}

}
