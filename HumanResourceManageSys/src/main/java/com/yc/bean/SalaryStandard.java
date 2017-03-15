package com.yc.bean;

import java.io.Serializable;
import java.util.Date;
/* 创建新表 "salary_standard"。                                                                    */
/* "salary_standard" : 薪酬标准基本信息表                                                              */
/* 	"ssd_id" : 主键，自动增长列                                                                       */
/* 	"standard_id" : 薪酬标准单编号                                                                   */
/* 	"standard_name" : 薪酬标准单名称                                                                 */
/* 	"designer" : 制定者名字                                                                        */
/* 	"register" : 登记人                                                                          */
/* 	"checker" : 复核人                                                                           */
/* 	"changer" : 变更人                                                                           */
/* 	"regist_time" : 登记时间                                                                      */
/* 	"check_time" : 复核时间                                                                       */
/* 	"change_time" : 变更时间                                                                      */
/* 	"salary_sum" : 薪酬总额                                                                       */
/* 	"check_status" : 是否经过复核                                                                   */
/* 	"change_status" : 更改状态                                                                    */
/* 	"check_comment" : 复核意见                                                                   */ 
/* 	"remark" : 备注                                                                             */  
public class SalaryStandard implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ssd_id;
	private String standard_id;
	private String standard_name;
	private String designer;
	private String register;
	private String checker;
	private String changer;
	private Date regist_time;
	private Date check_time;
	private Date change_time;
	private Double salary_sum;
	private Integer check_status;
	private Integer change_status;
	private String check_comment;
	private String remark;
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
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public Integer getSsd_id() {
		return ssd_id;
	}
	public void setSsd_id(Integer ssd_id) {
		this.ssd_id = ssd_id;
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
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Date getChange_time() {
		return change_time;
	}
	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
	public Double getSalary_sum() {
		return salary_sum;
	}
	public void setSalary_sum(Double salary_sum) {
		this.salary_sum = salary_sum;
	}
	public Integer getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Integer check_status) {
		this.check_status = check_status;
	}
	public Integer getChange_status() {
		return change_status;
	}
	public void setChange_status(Integer change_status) {
		this.change_status = change_status;
	}
	public String getCheck_comment() {
		return check_comment;
	}
	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
