package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "config_major"。                                                                       */
/* "config_major" : 职位设置                                                                      */
/* 	"mak_id" : 主键，自动增长列                                                                       */
/* 	"major_kind_id" : 职位分类编号                                                                  */
/* 	"major_kind_name" : 职位分类名称                                                                */
/* 	"major_id" : 职位编号                                                                         */
/* 	"major_name" : 职位名称                                                                       */ 
/* 	"test_amount" : 题套数量                                                                      */   
public class ConfigMajor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mak_id;
	private String major_kind_id;
	private String major_kind_name;
	private String major_id;
	private String major_name;
	private Integer test_amount;
	public Integer getMak_id() {
		return mak_id;
	}
	public void setMak_id(Integer mak_id) {
		this.mak_id = mak_id;
	}
	public String getMajor_kind_id() {
		return major_kind_id;
	}
	public void setMajor_kind_id(String major_kind_id) {
		this.major_kind_id = major_kind_id;
	}
	public String getMajor_kind_name() {
		return major_kind_name;
	}
	public void setMajor_kind_name(String major_kind_name) {
		this.major_kind_name = major_kind_name;
	}
	public String getMajor_id() {
		return major_id;
	}
	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public Integer getTest_amount() {
		return test_amount;
	}
	public void setTest_amount(Integer test_amount) {
		this.test_amount = test_amount;
	}
	
}
