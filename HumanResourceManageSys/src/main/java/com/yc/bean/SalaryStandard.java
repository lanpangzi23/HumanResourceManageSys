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
	private int ssd_id;
	private String standard_id;
	private String standard_name;
	private String designer;
	private String register;
	private String checker;
	private String changer;
	private Date register_time;
	private Date check_time;
	private Date change_time;
	private double salary_sum;
	private int check_status;
	private int change_status;
	private String check_comment;
	private String remark;
	public int getSsd_id() {
		return ssd_id;
	}
	public void setSsd_id(int ssd_id) {
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
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
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
	public double getSalary_sum() {
		return salary_sum;
	}
	public void setSalary_sum(double salary_sum) {
		this.salary_sum = salary_sum;
	}
	public int getCheck_status() {
		return check_status;
	}
	public void setCheck_status(int check_status) {
		this.check_status = check_status;
	}
	public int getChange_status() {
		return change_status;
	}
	public void setChange_status(int change_status) {
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
