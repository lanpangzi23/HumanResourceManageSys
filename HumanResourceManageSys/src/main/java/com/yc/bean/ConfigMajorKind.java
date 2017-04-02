package com.yc.bean;

import java.io.Serializable;

/* 创建新表 "config_major_kind"。                                                                  */
/* "config_major_kind" : 职位分类设置                                                               */
/* 	"mfk_id" : 主键，自动增长列                                                                       */
/* 	"major_kind_id" : 职位分类编号                                                                  */
/* 	"major_kind_name" : 职分类位名称                                                                */ 
public class ConfigMajorKind implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer minPage;
	private Integer maxPage;
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
	@Override
	public String toString() {
		return "ConfigMajorKind [minPage=" + minPage + ", maxPage=" + maxPage + ", mfk_id=" + mfk_id
				+ ", major_kind_id=" + major_kind_id + ", major_kind_name=" + major_kind_name + "]";
	}
	private Integer mfk_id;
	private String major_kind_id;
	private String major_kind_name;
	public Integer getMfk_id() {
		return mfk_id;
	}
	public void setMfk_id(Integer mfk_id) {
		this.mfk_id = mfk_id;
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
	
}
