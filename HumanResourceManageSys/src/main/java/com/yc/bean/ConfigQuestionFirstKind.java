package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "config_question_first_kind"。                                                         */
/* "config_question_first_kind" : 试题一级分类设置                                                    */
/* 	"qfk_id" : 主键，自动增长列                                                                       */
/* 	"first_kind_id" : 试题一级分类编号                                                                */
/* 	"first_kind_name" : 试题一级分类名称                                                              */  
public class ConfigQuestionFirstKind implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer qfk_id;
	private String first_kind_id;
	private String first_kind_name;
	public Integer getQfk_id() {
		return qfk_id;
	}
	public void setQfk_id(Integer qfk_id) {
		this.qfk_id = qfk_id;
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
}
