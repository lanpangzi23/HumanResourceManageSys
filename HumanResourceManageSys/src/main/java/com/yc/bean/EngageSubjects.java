package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

/* 创建新表 "engage_subjects"。                                                                    */
/* "engage_subjects" : 试题题库登记表                                                                */
/* 	"sub_id" : 主键，自动增长列                                                                       */
/* 	"first_kind_id" : 试题I级分类编号                                                                */
/* 	"first_kind_name" : 试题I级分类名称                                                              */
/* 	"second_kind_id" : 试题II级分类编号                                                              */
/* 	"second_kind_name" : 试题II级分类名称                                                            */
/* 	"register" : 登记人                                                                          */
/* 	"regist_time" : 登记时间                                                                      */
/* 	"derivation" : 试题出处                                                                       */
/* 	"content" : 题干                                                                            */
/* 	"key_a" : 答案a                                                                             */
/* 	"key_b" : 答案b                                                                             */
/* 	"key_c" : 答案c                                                                             */
/* 	"key_d" : 答案d                                                                             */
/* 	"key_e" : 答案e                                                                             */
/* 	"correct_key" : 正确答案                                                                      */
/* 	"changer" : 变更人                                                                           */
/* 	"change_time" : 变更时间                                                                      */  
public class EngageSubjects implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sub_id;
	private String first_kind_id;
	private String first_kind_name;
	private String second_kind_id;
	private String second_kind_name;
	private String 	register;
	private Date regist_time;
	private String derivation;
	private String content;
	private String key_a;
	private String key_b;
	private String key_c;
	private String key_d;
	private String key_e;
	private String correct_key;
	private String changer;
	private Date change_time;
	private Date minDate;
	private Date maxDate;
	private String keyword;
	private Integer page;
	private Integer size;
	@Override
	public String toString() {
		return "EngageSubjects [sub_id=" + sub_id + ", first_kind_id=" + first_kind_id + ", first_kind_name="
				+ first_kind_name + ", second_kind_id=" + second_kind_id + ", second_kind_name=" + second_kind_name
				+ ", register=" + register + ", regist_time=" + regist_time + ", derivation=" + derivation
				+ ", content=" + content + ", key_a=" + key_a + ", key_b=" + key_b + ", key_c=" + key_c + ", key_d="
				+ key_d + ", key_e=" + key_e + ", correct_key=" + correct_key + ", changer=" + changer
				+ ", change_time=" + change_time + ", minDate=" + minDate + ", maxDate=" + maxDate + ", keyword="
				+ keyword + ", page=" + page + ", size=" + size + "]";
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getMinDate() {
		return minDate;
	}
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
	public Integer getSub_id() {
		return sub_id;
	}
	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
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
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public String getDerivation() {
		return derivation;
	}
	public void setDerivation(String derivation) {
		this.derivation = derivation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKey_a() {
		return key_a;
	}
	public void setKey_a(String key_a) {
		this.key_a = key_a;
	}
	public String getKey_b() {
		return key_b;
	}
	public void setKey_b(String key_b) {
		this.key_b = key_b;
	}
	public String getKey_c() {
		return key_c;
	}
	public void setKey_c(String key_c) {
		this.key_c = key_c;
	}
	public String getKey_d() {
		return key_d;
	}
	public void setKey_d(String key_d) {
		this.key_d = key_d;
	}
	public String getKey_e() {
		return key_e;
	}
	public void setKey_e(String key_e) {
		this.key_e = key_e;
	}
	public String getCorrect_key() {
		return correct_key;
	}
	public void setCorrect_key(String correct_key) {
		this.correct_key = correct_key;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public Date getChange_time() {
		return change_time;
	}
	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
}
