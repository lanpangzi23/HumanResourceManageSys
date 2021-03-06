package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "salary_grant_details"。                                                               */
/* "salary_grant_details" : 薪酬发放详细信息                                                          */
/* 	"grd_id" : 主键，自动增长列                                                                       */
/* 	"salary_grant_id" : 薪酬发放编号                                                                */
/* 	"human_id" : 档案编号                                                                         */
/* 	"human_name" : 姓名                                                                         */
/* 	"bouns_sum" : 奖励金额                                                                        */
/* 	"sale_sum" : 销售绩效金额                                                                       */
/* 	"deduct_sum" : 应扣金额                                                                       */
/* 	"salary_standard_sum" : 标准薪酬总额                                                            */
/* 	"salary_paid_sum" : 实发薪酬总额                                                                */  
public class SalaryGrantDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1039375313700250803L;
	private Integer grd_id;
	private String salary_grant_id;
	private String human_id;
	private String human_name;
	private Double bouns_sum;
	private Double sale_sum;
	private Double deduct_sum;
	private Double salary_standard_sum;
	private Double salary_paid_sum;
	public Integer getGrd_id() {
		return grd_id;
	}
	public void setGrd_id(Integer grd_id) {
		this.grd_id = grd_id;
	}
	public String getSalary_grant_id() {
		return salary_grant_id;
	}
	public void setSalary_grant_id(String salary_grant_id) {
		this.salary_grant_id = salary_grant_id;
	}
	public String getHuman_id() {
		return human_id;
	}
	public void setHuman_id(String human_id) {
		this.human_id = human_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public Double getBouns_sum() {
		return bouns_sum;
	}
	public void setBouns_sum(Double bouns_sum) {
		this.bouns_sum = bouns_sum;
	}
	public Double getSale_sum() {
		return sale_sum;
	}
	public void setSale_sum(Double sale_sum) {
		this.sale_sum = sale_sum;
	}
	public Double getDeduct_sum() {
		return deduct_sum;
	}
	public void setDeduct_sum(Double deduct_sum) {
		this.deduct_sum = deduct_sum;
	}
	public Double getSalary_standard_sum() {
		return salary_standard_sum;
	}
	public void setSalary_standard_sum(Double salary_standard_sum) {
		this.salary_standard_sum = salary_standard_sum;
	}
	public Double getSalary_paid_sum() {
		return salary_paid_sum;
	}
	public void setSalary_paid_sum(Double salary_paid_sum) {
		this.salary_paid_sum = salary_paid_sum;
	}
}
