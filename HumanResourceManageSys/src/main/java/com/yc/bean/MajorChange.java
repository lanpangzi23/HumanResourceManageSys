package com.yc.bean;

import java.util.Date;

/* 创建新表 "major_change"。                                                                       */
/* "major_change" : 职位调动表                                                                     */
/* 	"mch_id" : 主键，自动增长列                                                                       */
/* 	"first_kind_id" : 一级机构编号                                                                  */
/* 	"first_kind_name" : 一级机构名称                                                                */
/* 	"second_kind_id" : 二级机构编号                                                                 */
/* 	"second_kind_name" : 二级机构名称                                                               */
/* 	"third_kind_id" : 三级机构编号                                                                  */
/* 	"third_kind_name" : 三级机构名称                                                                */
/* 	"major_kind_id" : 职位分类编号                                                                  */
/* 	"major_kind_name" : 职位分类名称                                                                */
/* 	"major_id" : 职位编号                                                                         */
/* 	"major_name" : 职位名称                                                                       */
/* 	"new_first_kind_id" : 新一级机构编号                                                             */
/* 	"new_first_kind_name" : 新一级机构名称                                                           */
/* 	"new_second_kind_id" : 新二级机构编号                                                            */
/* 	"new_second_kind_name" : 新二级机构名称                                                          */
/* 	"new_third_kind_id" : 新三级机构编号                                                             */
/* 	"new_third_kind_name" : 新三级机构名称                                                           */
/* 	"new_major_kind_id" : 新职位分类编号                                                             */
/* 	"new_major_kind_name" : 新职位分类名称                                                           */
/* 	"new_major_id" : 新职位编号                                                                    */
/* 	"new_major_name" : 新职位名称                                                                  */
/* 	"human_id" : 人力资源档案编号                                                                     */
/* 	"human_name" : 姓名                                                                         */
/* 	"salary_standard_id" : 薪酬标准编号                                                             */
/* 	"salary_standard_name" : 薪酬标准名称                                                           */
/* 	"salary_sum" : 薪酬总额                                                                       */
/* 	"new_salary_standard_id" : 新薪酬标准编号                                                        */
/* 	"new_salary_standard_name" : 新薪酬标准名称                                                      */
/* 	"new_salary_sum" : 新薪酬总额                                                                  */
/* 	"change_reason" : 调动原因                                                                    */
/* 	"check_reason" : 审核通过意见                                                                   */
/* 	"check_status" : 复核通过状态                                                                   */
/* 	"register" : 登记人                                                                          */
/* 	"checker" : 复核人                                                                           */
/* 	"regist_time" : 登记时间                                                                      */
/* 	"check_time" : 复核时间                                                                       */ 
public class MajorChange {
	private Integer mch_id;
	private String first_kind_id;
	private String first_kind_name;
	private String second_kind_id;
	private String second_kind_name;
	private String third_kind_id;
	private String third_kind_name;
	private String major_kind_id;
	private String major_kind_name;
	private String major_id;
	private String major_name;
	private String new_first_kind_id;
	private String new_first_kind_name;
	private String new_second_kind_id;
	private String new_second_kind_name;
	private String new_third_kind_id;
	private String new_third_kind_name;
	private String new_major_kind_id;
	private String new_major_kind_name;
	private String new_major_id;
	private String new_major_name;
	private String human_id;
	private String human_name;
	private String salary_standard_id;
	private String salary_standard_name;
	private Double salary_sum;
	private String new_salary_standard_id;
	private String new_salary_standard_name;
	private Double new_salary_sum;
	private String change_reason;
	private String check_reason;
	private Integer check_status;
	private String register;
	private String 	checker;
	private Date regist_time;
	private Date check_time;
	public Integer getMch_id() {
		return mch_id;
	}
	public void setMch_id(Integer mch_id) {
		this.mch_id = mch_id;
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
	public String getThird_kind_id() {
		return third_kind_id;
	}
	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}
	public String getThird_kind_name() {
		return third_kind_name;
	}
	public void setThird_kind_name(String thord_kind_name) {
		this.third_kind_name = thord_kind_name;
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
	public String getNew_first_kind_id() {
		return new_first_kind_id;
	}
	public void setNew_first_kind_id(String new_first_kind_id) {
		this.new_first_kind_id = new_first_kind_id;
	}
	public String getNew_first_kind_name() {
		return new_first_kind_name;
	}
	public void setNew_first_kind_name(String new_first_kind_name) {
		this.new_first_kind_name = new_first_kind_name;
	}
	public String getNew_second_kind_id() {
		return new_second_kind_id;
	}
	public void setNew_second_kind_id(String new_second_kind_id) {
		this.new_second_kind_id = new_second_kind_id;
	}
	public String getNew_second_kind_name() {
		return new_second_kind_name;
	}
	public void setNew_second_kind_name(String new_second_kind_name) {
		this.new_second_kind_name = new_second_kind_name;
	}
	public String getNew_third_kind_id() {
		return new_third_kind_id;
	}
	public void setNew_third_kind_id(String new_third_kind_id) {
		this.new_third_kind_id = new_third_kind_id;
	}
	public String getNew_third_kind_name() {
		return new_third_kind_name;
	}
	public void setNew_third_kind_name(String new_third_kind_name) {
		this.new_third_kind_name = new_third_kind_name;
	}
	public String getNew_major_kind_id() {
		return new_major_kind_id;
	}
	public void setNew_major_kind_id(String new_major_kind_id) {
		this.new_major_kind_id = new_major_kind_id;
	}
	public String getNew_major_kind_name() {
		return new_major_kind_name;
	}
	public void setNew_major_kind_name(String new_major_kind_name) {
		this.new_major_kind_name = new_major_kind_name;
	}
	public String getNew_major_id() {
		return new_major_id;
	}
	public void setNew_major_id(String new_major_id) {
		this.new_major_id = new_major_id;
	}
	public String getNew_major_name() {
		return new_major_name;
	}
	public void setNew_major_name(String new_major_name) {
		this.new_major_name = new_major_name;
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
	public String getSalary_standard_id() {
		return salary_standard_id;
	}
	public void setSalary_standard_id(String salary_standard_id) {
		this.salary_standard_id = salary_standard_id;
	}
	public String getSalary_standard_name() {
		return salary_standard_name;
	}
	public void setSalary_standard_name(String salary_standard_name) {
		this.salary_standard_name = salary_standard_name;
	}
	public Double getSalary_sum() {
		return salary_sum;
	}
	public void setSalary_sum(Double salary_sum) {
		this.salary_sum = salary_sum;
	}
	public String getNew_salary_standard_id() {
		return new_salary_standard_id;
	}
	public void setNew_salary_standard_id(String new_salary_standard_id) {
		this.new_salary_standard_id = new_salary_standard_id;
	}
	public String getNew_salary_standard_name() {
		return new_salary_standard_name;
	}
	public void setNew_salary_standard_name(String new_salary_standard_name) {
		this.new_salary_standard_name = new_salary_standard_name;
	}
	public Double getNew_salary_sum() {
		return new_salary_sum;
	}
	public void setNew_salary_sum(Double new_salary_sum) {
		this.new_salary_sum = new_salary_sum;
	}
	public String getChange_reason() {
		return change_reason;
	}
	public void setChange_reason(String change_reason) {
		this.change_reason = change_reason;
	}
	public String getCheck_reason() {
		return check_reason;
	}
	public void setCheck_reason(String check_reason) {
		this.check_reason = check_reason;
	}
	public Integer getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Integer check_status) {
		this.check_status = check_status;
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
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	
}
