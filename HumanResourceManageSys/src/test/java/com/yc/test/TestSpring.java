package com.yc.test;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yc.bean.ConfigFileFirstKind;
import com.yc.bean.HumanFile;
import com.yc.biz.HumanBiz;

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
	//人力资源档案登记
	@Test
	public void testSpring8() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		HumanBiz bb=  ac.getBean("humanBizImpl",HumanBiz.class);
		System.out.println(bb);
		HumanFile hf=new HumanFile();
		hf.setHuman_id("110FGHJKL");
		hf.setFirst_kind_id("10");
		hf.setFirst_kind_name("思凯乐集团");
		hf.setSecond_kind_id("11");
		hf.setSecond_kind_name("衡阳分公司");
		hf.setThird_kind_id("12");
		hf.setThird_kind_name("销售部");
		hf.setHuman_name("宋元杰");
		hf.setHuman_address("湖南省湖南工学院");
		hf.setHuman_postcode("024500");
		hf.setHuman_pro_designation("销售");
		hf.setHuman_major_kind_id("01");
		hf.setHuman_major_kind_name("大数据营销");
		hf.setHuman_major_id("02");
		hf.setHuman_major_name("营销管培生");
		hf.setHuman_telephone("5436985");
		hf.setHuman_mobliephone("15367051625");
		hf.setHuman_bank("建设银行");
		hf.setHuman_account("6217002950104595085");
		hf.setHuman_qq("1975282612");
		hf.setHuman_email("1975282612@qq.com");
		hf.setHuman_hobby("睡懒觉，追剧");
		hf.setHuman_speciality("java");
		hf.setHuman_sex("女");
		hf.setHuman_religion("佛教");
		hf.setHuman_party("团员");
		hf.setHuman_nationality("中国");
		hf.setHuman_race("汉族");
		hf.setHuman_id_card("150426199507173787");
		Date data=new Date();

		hf.setHuman_birthday(data);
		hf.setHuman_birthplace("内蒙古赤峰市");
		hf.setHuman_age(22);
		hf.setHuman_educated_years(4);
		hf.setHuman_educated_major("本科网络工程");
		hf=bb.save(hf);
		System.out.println(hf);
		
	}
	//测试查寻一级机构
	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		HumanBiz bb=  ac.getBean("humanBizImpl",HumanBiz.class);
		List<ConfigFileFirstKind> list=bb.getAllConfigFileFirstKinds();
		for(ConfigFileFirstKind c:list){
			System.out.println(c);
		}
	}
}
	
	
	

