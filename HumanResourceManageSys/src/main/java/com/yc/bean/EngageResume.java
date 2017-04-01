package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/* 创建新表 "engage_resume"。                                                                      */
/* "engage_resume" : 简历管理                                                                     */
/* 	"res_id" : 主键，自动增长列                                                                       */
/* 	"human_name" : 姓名                                                                         */
/* 	"engage_type" : 招聘类型                                                                      */
/* 	"human_address" : 地址                                                                      */
/* 	"human_postcode" : 邮编                                                                     */
/* 	"human_major_kind_id" : 职位分类编号                                                            */
/* 	"human_major_kind_name" : 职位分类名称                                                          */
/* 	"human_major_id" : 职位编号                                                                   */
/* 	"human_major_name" : 职位名称                                                                 */
/* 	"human_telephone" : 电话号码                                                                  */
/* 	"human_homephone" : 家庭电话                                                                  */
/* 	"human_mobilephone" : 手机                                                                  */
/* 	"human_email" : Email                                                                     */
/* 	"human_hobby" : 兴趣爱好                                                                      */
/* 	"human_specility" : 特长                                                                    */
/* 	"human_sex" : 性别                                                                          */
/* 	"human_religion" : 宗教信仰                                                                   */
/* 	"human_party" : 政治面貌                                                                      */
/* 	"human_nationality" : 国籍                                                                  */
/* 	"human_race" : 民族                                                                         */
/* 	"human_birthday" : 生日                                                                     */
/* 	"human_age" : 年龄                                                                          */
/* 	"human_educated_degree" : 教育程度                                                            */
/* 	"human_educated_years" : 教育年限                                                             */
/* 	"human_educated_major" : 专业                                                               */
/* 	"human_college" : 毕业院校                                                                    */
/* 	"human_idcard" : 身份证号                                                                     */
/* 	"human_birthplace" : 出生地                                                                  */
/* 	"demand_salary_standard" : 薪酬标准                                                           */
/* 	"human_history_records" : 个人履历                                                            */
/* 	"remark" : 备注                                                                             */
/* 	"recomandation" : 推荐意见                                                                    */
/* 	"human_picture" : 照片                                                                      */
/* 	"attachment_name" : 档案附件                                                                  */
/* 	"check_status" : 复核状态                                                                     */
/* 	"register" : 登记人                                                                          */
/* 	"regist_time" : 登记时间                                                                      */
/* 	"checker" : 复核人姓名                                                                         */
/* 	"check_time" : 复核时间                                                                       */
/* 	"interview_status" : 面试状态                                                                 */
/* 	"total_points" : 总分                                                                       */
/* 	"test_amount" : 考试次数                                                                      */
/* 	"test_checker" : 测试复核人                                                                    */
/* 	"test_check_time" : 测试复核时间                                                                */
/* 	"pass_register" : 通过登记人姓名                                                                 */
/* 	"pass_regist_time" : 通过登记时间                                                               */
/* 	"pass_checker" : 通过复核人姓名                                                                  */
/* 	"pass_check_time" : 通过复核时间                                                                */
/* 	"pass_check_status" : 通过的复核状态
	"pass_checkComment":录用申请审核意见
	"pass_passComment":录用申请审批意见                                                            */ 
public class EngageResume implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer res_id;
	private String human_name;
	private String engage_type;
	private String human_address;
	private String human_postcode;
	private String human_major_kind_id;
	private String human_major_kind_name;
	private String human_major_id;
	private String human_major_name;
	private String human_telephone;
	private String human_homephone;
	private String human_mobilephone;
	private String human_email;
	private String human_hobby;
	private String human_specility;
	private String human_sex;
	private String human_religion;
	private String human_party;
	private String human_nationality;
	private String human_race;
	private Date human_birthday;
	private Integer human_age;
	private String human_educated_degree;
	private Integer human_educated_years;
	private String human_educated_major;
	private String human_college;
	private String human_idcard;
	private String human_birthplace;
	private String demand_salary_standard;
	private String human_history_records;
	private String remark;
	private String recomandation;
	private String human_picture;
	private String attachment_name;//attachment_name
	private Integer check_status;
	private String register;
	private Date regist_time;
	private String checker;
	private Date check_time;
	private Integer interview_status;
	private Float total_points;
	private Integer test_amount;
	private String test_checker;
	private Date test_check_time;
	private String pass_register;
	private Date pass_regist_time;
	private String pass_checker;
	private Date pass_check_time;
	private Integer pass_check_status;
	private String pass_checkComment;
	private String pass_passComment;
	private List<MultipartFile> picUrl;
	private Date minDate;
	private Date maxDate;
	private String keyword;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDemand_salary_standard() {
		return demand_salary_standard;
	}
	public void setDemand_salary_standard(String demand_salary_standard) {
		this.demand_salary_standard = demand_salary_standard;
	}
	public List<MultipartFile> getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(List<MultipartFile> picUrl) {
		this.picUrl = picUrl;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public Integer getRes_id() {
		return res_id;
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public String getEngage_type() {
		return engage_type;
	}
	public void setEngage_type(String engage_type) {
		this.engage_type = engage_type;
	}
	public String getHuman_address() {
		return human_address;
	}
	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}
	public String getHuman_postcode() {
		return human_postcode;
	}
	public void setHuman_postcode(String human_postcode) {
		this.human_postcode = human_postcode;
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
	public String getHuman_telephone() {
		return human_telephone;
	}
	public void setHuman_telephone(String human_telephone) {
		this.human_telephone = human_telephone;
	}
	public String getHuman_homephone() {
		return human_homephone;
	}
	public void setHuman_homephone(String human_homephone) {
		this.human_homephone = human_homephone;
	}
	public String getHuman_mobilephone() {
		return human_mobilephone;
	}
	public void setHuman_mobilephone(String human_mobilephone) {
		this.human_mobilephone = human_mobilephone;
	}
	public String getHuman_email() {
		return human_email;
	}
	public void setHuman_email(String human_email) {
		this.human_email = human_email;
	}
	public String getHuman_hobby() {
		return human_hobby;
	}
	public void setHuman_hobby(String human_hobby) {
		this.human_hobby = human_hobby;
	}
	public String getHuman_specility() {
		return human_specility;
	}
	public void setHuman_specility(String human_specility) {
		this.human_specility = human_specility;
	}
	public String getHuman_sex() {
		return human_sex;
	}
	public void setHuman_sex(String human_sex) {
		this.human_sex = human_sex;
	}
	public String getHuman_religion() {
		return human_religion;
	}
	public void setHuman_religion(String human_religion) {
		this.human_religion = human_religion;
	}
	public String getHuman_party() {
		return human_party;
	}
	public void setHuman_party(String human_party) {
		this.human_party = human_party;
	}
	public String getHuman_nationality() {
		return human_nationality;
	}
	public void setHuman_nationality(String human_nationality) {
		this.human_nationality = human_nationality;
	}
	public String getHuman_race() {
		return human_race;
	}
	public void setHuman_race(String human_race) {
		this.human_race = human_race;
	}
	public Date getHuman_birthday() {
		return human_birthday;
	}
	public void setHuman_birthday(Date human_birthday) {
		this.human_birthday = human_birthday;
	}
	public Integer getHuman_age() {
		return human_age;
	}
	public void setHuman_age(Integer human_age) {
		this.human_age = human_age;
	}
	public String getHuman_educated_degree() {
		return human_educated_degree;
	}
	public void setHuman_educated_degree(String human_educated_degree) {
		this.human_educated_degree = human_educated_degree;
	}
	public Integer getHuman_educated_years() {
		return human_educated_years;
	}
	public void setHuman_educated_years(Integer human_educated_years) {
		this.human_educated_years = human_educated_years;
	}
	public String getHuman_educated_major() {
		return human_educated_major;
	}
	public void setHuman_educated_major(String human_educated_major) {
		this.human_educated_major = human_educated_major;
	}
	public String getHuman_college() {
		return human_college;
	}
	public void setHuman_college(String human_college) {
		this.human_college = human_college;
	}
	public String getHuman_idcard() {
		return human_idcard;
	}
	public void setHuman_idcard(String human_idcard) {
		this.human_idcard = human_idcard;
	}
	public String getHuman_birthplace() {
		return human_birthplace;
	}
	public void setHuman_birthplace(String human_birthplace) {
		this.human_birthplace = human_birthplace;
	}
	public String getHuman_history_records() {
		return human_history_records;
	}
	public void setHuman_history_records(String human_history_records) {
		this.human_history_records = human_history_records;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRecomandation() {
		return recomandation;
	}
	public void setRecomandation(String recomandation) {
		this.recomandation = recomandation;
	}
	public String getHuman_picture() {
		return human_picture;
	}
	public void setHuman_picture(String human_picture) {
		this.human_picture = human_picture;
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
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Integer getInterview_status() {
		return interview_status;
	}
	public void setInterview_status(Integer interview_status) {
		this.interview_status = interview_status;
	}
	public Float getTotal_points() {
		return total_points;
	}
	public void setTotal_points(Float total_points) {
		this.total_points = total_points;
	}
	public Integer getTest_amount() {
		return test_amount;
	}
	public void setTest_amount(Integer test_amount) {
		this.test_amount = test_amount;
	}
	public String getTest_checker() {
		return test_checker;
	}
	public void setTest_checker(String test_checker) {
		this.test_checker = test_checker;
	}
	public Date getTest_check_time() {
		return test_check_time;
	}
	public void setTest_check_time(Date test_check_time) {
		this.test_check_time = test_check_time;
	}
	public String getPass_register() {
		return pass_register;
	}
	public void setPass_register(String pass_register) {
		this.pass_register = pass_register;
	}
	public Date getPass_regist_time() {
		return pass_regist_time;
	}
	public void setPass_regist_time(Date pass_regist_time) {
		this.pass_regist_time = pass_regist_time;
	}
	public String getPass_checker() {
		return pass_checker;
	}
	public void setPass_checker(String pass_checker) {
		this.pass_checker = pass_checker;
	}
	public Date getPass_check_time() {
		return pass_check_time;
	}
	public void setPass_check_time(Date pass_check_time) {
		this.pass_check_time = pass_check_time;
	}
	public Integer getPass_check_status() {
		return pass_check_status;
	}
	public void setPass_check_status(Integer pass_check_status) {
		this.pass_check_status = pass_check_status;
	}
	public String getPass_checkComment() {
		return pass_checkComment;
	}
	public void setPass_checkComment(String pass_checkComment) {
		this.pass_checkComment = pass_checkComment;
	}
	public String getPass_passComment() {
		return pass_passComment;
	}
	public void setPass_passComment(String pass_passComment) {
		this.pass_passComment = pass_passComment;
	}
	public List<String> getPdfsStringList(){
		List<String> list=new ArrayList<String>();
		if(human_picture!=null&&human_picture.length()>0){
			String [] strs=human_picture.split(",");
			for(String s:strs){
				list.add(s);
			}
		}
		return list;
	}
	public String toString() {
		return "EngageResume [res_id=" + res_id + ", human_name=" + human_name + ", engage_type=" + engage_type
				+ ", human_address=" + human_address + ", human_postcode=" + human_postcode + ", human_major_kind_id="
				+ human_major_kind_id + ", human_major_kind_name=" + human_major_kind_name + ", human_major_id="
				+ human_major_id + ", human_major_name=" + human_major_name + ", human_telephone=" + human_telephone
				+ ", human_homephone=" + human_homephone + ", human_mobilephone=" + human_mobilephone + ", human_email="
				+ human_email + ", human_hobby=" + human_hobby + ", human_specility=" + human_specility + ", human_sex="
				+ human_sex + ", human_religion=" + human_religion + ", human_party=" + human_party
				+ ", human_nationality=" + human_nationality + ", human_race=" + human_race + ", human_birthday="
				+ human_birthday + ", human_age=" + human_age + ", human_educated_degree=" + human_educated_degree
				+ ", human_educated_years=" + human_educated_years + ", human_educated_major=" + human_educated_major
				+ ", human_college=" + human_college + ", human_idcard=" + human_idcard + ", human_birthplace="
				+ human_birthplace + ", demand_salary_standard=" + demand_salary_standard + ", human_history_records="
				+ human_history_records + ", remark=" + remark + ", recomandation=" + recomandation + ", human_picture="
				+ human_picture + ", attachment_name=" + attachment_name + ", check_status=" + check_status
				+ ", register=" + register + ", regist_time=" + regist_time + ", checker=" + checker + ", check_time="
				+ check_time + ", interview_status=" + interview_status + ", total_points=" + total_points
				+ ", test_amount=" + test_amount + ", test_checker=" + test_checker + ", test_check_time="
				+ test_check_time + ", pass_register=" + pass_register + ", pass_regist_time=" + pass_regist_time
				+ ", pass_checker=" + pass_checker + ", pass_check_time=" + pass_check_time + ", pass_check_status="
				+ pass_check_status + ", pass_checkComment=" + pass_checkComment + ", pass_passComment="
				+ pass_passComment + ", picUrl=" + picUrl + ", minDate=" + minDate + ", maxDate=" + maxDate
				+ ", keyword=" + keyword + ", minPage=" + minPage + ", maxPage=" + maxPage + "]";
	}
}
