package com.yc.bean;

import java.io.Serializable;
import java.util.Date;
/* 创建新表 "engage_interview"。                                                                   */
/* "engage_interview" : 面试表                                                                   */
/* 	"ein_id" : 主键，自动增长列                                                                       */
/* 	"human_name" : 姓名                                                                         */
/* 	"interview_amount" : 面试次数                                                                 */
/* 	"human_major_kind_id" : 职位分类编号                                                            */
/* 	"human_major_kind_name" : 职位分类名称                                                          */
/* 	"human_major_id" : 职位编号                                                                   */
/* 	"human_major_name" : 职位名称                                                                 */
/* 	"image_degree" : 形象等级                                                                     */
/* 	"native_language_degree" : 口才等级                                                           */
/* 	"foreign_language_degree" : 外语水平等级                                                        */
/* 	"response_speed_degree" : 应变能力                                                            */
/* 	"EQ_degree" : EQ等级                                                                        */
/* 	"IQ_degree" : IQ_等级                                                                       */
/* 	"multi_quality_degree" : 综合素质                                                             */
/* 	"register" : 面试人                                                                          */
/* 	"checker" : 筛选人                                                                           */
/* 	"registe_time" : 面试时间                                                                     */
/* 	"check_time" : 筛选时间                                                                       */
/* 	"resume_id" : 简历编号                                                                        */
/* 	"result" : 面试结果                                                                           */
/* 	"interview_comment" : 面试评价                                                                */
/* 	"check_comment" : 筛选评价                                                                    */
/* 	"interview_status" : 面试状态                                                                 */
/* 	"check_status" : 筛选状态                                                                     */  
public class EngageInterview implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4117455717674059170L;
	private Integer ein_id;
	private String human_name;
	private Integer interview_amount;
	private String human_major_kind_id;
	private String human_major_kind_name;
	private String human_major_id;
	private String human_major_name;
	private String image_degree;
	private String native_language_degree;
	private String foreign_language_degree;
	private String response_speed_degree;
	private String EQ_degree;
	private String IQ_degree;
	private String multi_quality_degree;
	private String register;
	private String checker;
	private Date registe_time;
	private Date check_time;
	private Integer resume_id;
	private String result;
	private String interview_comment;
	private String check_comment;
	private Integer interview_status;
	private Integer check_status;
	public Integer getEin_id() {
		return ein_id;
	}
	public void setEin_id(Integer ein_id) {
		this.ein_id = ein_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public Integer getInterview_amount() {
		return interview_amount;
	}
	public void setInterview_amount(Integer interview_amount) {
		this.interview_amount = interview_amount;
	}
	public String getHuman_major_kind_id() {
		return human_major_kind_id;
	}
	public void setHuman_major_kind_id(String human_major_kind_id) {
		this.human_major_kind_id = human_major_kind_id;
	}
	public String getHuman_major_kind_name() {
		return human_major_kind_name;
	}
	public void setHuman_major_kind_name(String human_major_kind_name) {
		this.human_major_kind_name = human_major_kind_name;
	}
	public String getHuman_major_id() {
		return human_major_id;
	}
	public void setHuman_major_id(String human_major_id) {
		this.human_major_id = human_major_id;
	}
	public String getHuman_major_name() {
		return human_major_name;
	}
	public void setHuman_major_name(String human_major_name) {
		this.human_major_name = human_major_name;
	}
	public String getImage_degree() {
		return image_degree;
	}
	public void setImage_degree(String image_degree) {
		this.image_degree = image_degree;
	}
	public String getNative_language_degree() {
		return native_language_degree;
	}
	public void setNative_language_degree(String native_language_degree) {
		this.native_language_degree = native_language_degree;
	}
	public String getForeign_language_degree() {
		return foreign_language_degree;
	}
	public void setForeign_language_degree(String foreign_language_degree) {
		this.foreign_language_degree = foreign_language_degree;
	}
	public String getResponse_speed_degree() {
		return response_speed_degree;
	}
	public void setResponse_speed_degree(String response_speed_degree) {
		this.response_speed_degree = response_speed_degree;
	}
	public String getEQ_degree() {
		return EQ_degree;
	}
	public void setEQ_degree(String eQ_degree) {
		EQ_degree = eQ_degree;
	}
	public String getIQ_degree() {
		return IQ_degree;
	}
	public void setIQ_degree(String iQ_degree) {
		IQ_degree = iQ_degree;
	}
	public String getMulti_quality_degree() {
		return multi_quality_degree;
	}
	public void setMulti_quality_degree(String multi_quality_degree) {
		this.multi_quality_degree = multi_quality_degree;
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
	public Date getRegiste_time() {
		return registe_time;
	}
	public void setRegiste_time(Date registe_time) {
		this.registe_time = registe_time;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Integer getResume_id() {
		return resume_id;
	}
	public void setResume_id(Integer resume_id) {
		this.resume_id = resume_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getInterview_comment() {
		return interview_comment;
	}
	public void setInterview_comment(String interview_comment) {
		this.interview_comment = interview_comment;
	}
	public String getCheck_comment() {
		return check_comment;
	}
	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}
	public Integer getInterview_status() {
		return interview_status;
	}
	public void setInterview_status(Integer interview_status) {
		this.interview_status = interview_status;
	}
	public Integer getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Integer check_status) {
		this.check_status = check_status;
	}
}
