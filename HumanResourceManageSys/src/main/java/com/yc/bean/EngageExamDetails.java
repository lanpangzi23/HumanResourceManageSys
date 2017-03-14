package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "engage_exam_details"。                                                                */
/* "engage_exam_details" : 试卷详细信息                                                             */
/* 	"exd_id" : 主键，自动增长列                                                                       */
/* 	"exam_number" : 试卷编号                                                                      */
/* 	"first_kind_id" : 试题一级分类编号                                                                */
/* 	"first_kind_name" : 试题一级分类名称                                                              */
/* 	"second_kind_id" : 试题二级分类编号                                                               */
/* 	"second_kind_name" : 试题二级分类名称                                                             */
/* 	"question_amount" : 出题数量                                                                  */  
public class EngageExamDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4606622302614229067L;
	private Integer exd_id;
	private String exam_number;
	private String first_kind_id;
	private String first_kind_name;
	private String second_kind_id;
	private String second_kind_name; 
	private Integer question_amount;
	public Integer getExd_id() {
		return exd_id;
	}
	public void setExd_id(Integer exd_id) {
		this.exd_id = exd_id;
	}
	public String getExam_number() {
		return exam_number;
	}
	public void setExam_number(String exam_number) {
		this.exam_number = exam_number;
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
	public Integer getQuestion_amount() {
		return question_amount;
	}
	public void setQuestion_amount(Integer question_amount) {
		this.question_amount = question_amount;
	}
}
