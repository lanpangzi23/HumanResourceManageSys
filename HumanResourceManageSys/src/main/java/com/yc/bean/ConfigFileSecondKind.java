package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "config_file_second_kind"。                                                            */
/* "config_file_second_kind" : 二级机构设置                                                         */
/* 	"fsk_id" : 主键，自动增长列                                                                       */
/* 	"first_kind_id" : 一级机构编号                                                                  */
/* 	"first_kind_name" : 一级机构名称                                                                */
/* 	"second_kind_id" : 二级机构编号                                                                 */
/* 	"second_kind_name" : 二级机构名称                                                               */
/* 	"second_salary_id" : 二级机构薪酬发放责任人编号                                                        */
/* 	"second_sale_id" : 二级机构销售责任人编号                                                            */  
public class ConfigFileSecondKind implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5723635721181684913L;
	private int fsk_id;
	private String first_kind_id;
	private String first_kind_name;
	private String second_kind_id;
	private String second_kind_name;
	private String second_salary_id;
	private String second_sale_id;
	public int getFsk_id() {
		return fsk_id;
	}
	public void setFsk_id(int fsk_id) {
		this.fsk_id = fsk_id;
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	public String getSecond_salary_id() {
		return second_salary_id;
	}
	public void setSecond_salary_id(String second_salary_id) {
		this.second_salary_id = second_salary_id;
	}
	public String getSecond_sale_id() {
		return second_sale_id;
	}
	public void setSecond_sale_id(String second_sale_id) {
		this.second_sale_id = second_sale_id;
	}
}
