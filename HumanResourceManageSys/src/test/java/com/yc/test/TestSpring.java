package com.yc.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import junit.framework.TestCase;

public class TestSpring extends TestCase {

	@Test
	public void testSpring2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DataSource ds=(DataSource) ac.getBean("dataSource");
		System.out.println(   ds );
	}
	
	@Test
	public void testSpring3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Object ds= ac.getBean("sqlSessionFactory");
		System.out.println(   ds );
	}
	}
	
	
	

