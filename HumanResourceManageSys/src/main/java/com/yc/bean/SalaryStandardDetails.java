package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "salary_standard_details"。                                                            */
/* "salary_standard_details" : 薪酬标准单详细信息                                                      */
/* 	"sdt_id" : 主键，自动增长列                                                                       */
/* 	"standard_id" : 薪酬标准单编号                                                                   */
/* 	"standard_name" : 薪酬标准单名称                                                                 */
/* 	"item_id" : 薪酬项目序号                                                                        */
/* 	"item_name" : 薪酬项目名称                                                                      */
/* 	"salary" : 薪酬金额                                                                           */ 
public class SalaryStandardDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -450880293671224361L;
	private int sdt_id;
	private String standard_id;
	private String standard_name;
	private int item_id;
	private String item_name;
	private double salary;
	public int getSdt_id() {
		return sdt_id;
	}
	public void setSdt_id(int sdt_id) {
		this.sdt_id = sdt_id;
	}
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
