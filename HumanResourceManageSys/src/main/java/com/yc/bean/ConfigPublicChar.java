package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "config_public_char"。                                                                 */
/* "config_public_char" : 公共字段设置，包括薪酬设置，职称设置，国籍，民族，宗教信仰，政治面貌，教育年限，学历,专业，特长，爱好，培训项目，培训成绩，奖励项目，奖励等级 */
/* 	"pbc_id" : 主键，自动增长列                                                                       */
/* 	"attribute_kind" : 属性的种类                                                                  */
/* 	"attribute_name" : 属性的名称                                                                  */  
public class ConfigPublicChar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6779703261814557280L;
	private Integer minPage;
	public Integer getMinPage() {
		return minPage;
	}
	public void setMinPage(Integer minPage) {
		this.minPage = minPage;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	private Integer maxPage;
	private Integer pbc_id;
	private String attribute_kind;
	private String attribute_name;
	public Integer getPbc_id() {
		return pbc_id;
	}
	public void setPbc_id(Integer pbc_id) {
		this.pbc_id = pbc_id;
	}
	public String getAttribute_kind() {
		return attribute_kind;
	}
	public void setAttribute_kind(String attribute_kind) {
		this.attribute_kind = attribute_kind;
	}
	public String getAttribute_name() {
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	
}
