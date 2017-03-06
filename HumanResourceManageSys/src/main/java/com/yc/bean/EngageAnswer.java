package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

/* 创建新表 "engage_answer"。                                                                      */
/* "engage_answer" : 考试答题登记表                                                                  */
/* 	"ans_id" : 主键，自动增长列                                                                       */
/* 	"answer_number" : 答案编号                                                                    */
/* 	"exam_number" : 试卷编号                                                                      */
/* 	"resume_id" : 简历编号                                                                      */
/* 	"interview_id" : 面试编号                                                                      */
/* 	"human_name" : 姓名                                                                         */
/* 	"human_idcard" : 身份证号                                                                     */
/* 	"major_kind_id" : 职位分类编号                                                                  */
/* 	"major_kind_name" : major_kind_name 属于 engage_answer                                      */
/* 	"major_id" : major_id 属于 engage_answer                                                    */
/* 	"major_name" : major_name 属于 engage_answer                                                */
/* 	"test_time" : 测试时间                                                                        */
/* 	"use_time" : use_time 属于 engage_answer                                                    */
/* 	"total_point" : 总分  */
public class EngageAnswer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1622766876884468261L;
	private int ans_id;
	private String answer_number;
	private String exam_number;
	private int resume_id;
	private int interview_id;
	private String human_name;
	private String  human_idcard;
	private String major_kind_id;
	private String major_kind_name;
	private String major_id;
	private String major_name;
	private Date test_time;
	private String use_time;
	private double total_point;
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public String getAnswer_number() {
		return answer_number;
	}
	public void setAnswer_number(String answer_number) {
		this.answer_number = answer_number;
	}
	public String getExam_number() {
		return exam_number;
	}
	public void setExam_number(String exam_number) {
		this.exam_number = exam_number;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	public int getInterview_id() {
		return interview_id;
	}
	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public String getHuman_idcard() {
		return human_idcard;
	}
	public void setHuman_idcard(String human_idcard) {
		this.human_idcard = human_idcard;
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
	public Date getTest_time() {
		return test_time;
	}
	public void setTest_time(Date test_time) {
		this.test_time = test_time;
	}
	public String getUse_time() {
		return use_time;
	}
	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}
	public double getTotal_point() {
		return total_point;
	}
	public void setTotal_point(double total_point) {
		this.total_point = total_point;
	}
}
