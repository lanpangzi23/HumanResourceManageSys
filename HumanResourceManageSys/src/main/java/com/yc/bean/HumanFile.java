package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/* 创建新表 "human_file"。                                                                         */
/* "human_file" : 人力资源档案                                                                      */
/* 	"huf_id" : 主键，自动增长列                                                                       */
/* 	"human_id" : 档案编号                                                                         */
/* 	"first_kind_id" : 一级机构编号                                                                  */
/* 	"first_kind_name" : 一级机构名称                                                                */
/* 	"second_kind_id" : 二级机构编号                                                                 */
/* 	"second_kind_name" : 二级机构名称                                                               */
/* 	"third_kind_id" : 三级机构编号                                                                  */
/* 	"third_kind_name" : 三级机构名称                                                                */
/* 	"human_name" : 姓名                                                                         */
/* 	"human_address" : 地址                                                                      */
/* 	"human_postcode" : 邮政编码                                                                   */
/* 	"human_pro_designation" : 职称                                                              */
/* 	"human_major_kind_id" : 职位分类编号                                                            */
/* 	"human_major_kind_name" : 职位分类名称                                                          */
/* 	"human_major_id" : 职位编号                                                                   */
/* 	"hunma_major_name" : 职位名称                                                                 */
/* 	"human_telephone" : 电话                                                                    */
/* 	"human_mobilephone" : 手机号码                                                                */
/* 	"human_bank" : 开户银行                                                                       */
/* 	"human_account" : 银行帐号                                                                    */
/* 	"human_qq" : QQ号码                                                                         */
/* 	"human_email" : 电子邮件                                                                      */
/* 	"human_hobby" : 爱好                                                                        */
/* 	"human_speciality" : 特长                                                                   */
/* 	"human_sex" : 性别                                                                          */
/* 	"human_religion" : 宗教信仰                                                                   */
/* 	"human_party" : 政治面貌                                                                      */
/* 	"human_nationality" : 国籍                                                                  */
/* 	"human_race" : 民族                                                                         */
/* 	"human_birthday" : 出生日期                                                                   */
/* 	"human_birthplace" : 出生地                                                                  */
/* 	"human_age" : 年龄                                                                          */
/* 	"human_educated_degree" : 学历                                                              */
/* 	"human_educated_years" : 教育年限                                                             */
/* 	"human_educated_major" : 学历专业                                                             */
/* 	"human_society_security_id" : 社会保障号                                                       */
/* 	"human_id_card" : 身份证号                                                                    */
/* 	"remark" : 备注                                                                             */
/* 	"salary_standard_id" : 薪酬标准编号                                                             */
/* 	"salary_standard_name" : 薪酬标准名称                                                           */
/* 	"salary_sum" : 基本薪酬总额                                                                     */
/* 	"demand_salaray_sum" : 应发薪酬总额                                                             */
/* 	"paid_salary_sum" : 实发薪酬总额                                                                */
/* 	"major_change_amount" : 调动次数                                                              */
/* 	"bonus_amount" : 激励累计次数                                                                   */
/* 	"training_amount" : 培训累计次数                                                                */
/* 	"file_chang_amount" : 档案变更累计次数 ***************************/
/* 	"human_histroy_records" : 简历 ----------------------------- */
/* 	"human_family_membership" : 家庭关系                                                          */
/* 	"human_picture" : 相片                                                                      */
/* 	"attachment_name" : 附件名称  ------------------------------   */
/* 	"check_status" : 复核状态                                                                     */
/* 	"register" : 档案登记人                                                                        */
/* 	"checker" : 档案复核人                                                                         */
/* 	"changer" : 档案变更人                                                                         */
/* 	"regist_time" : 档案登记时间                                                                    */
/* 	"check_time" : 档案复核时间                                                                     */
/* 	"change_time" : 档案变更时间                                                                    */
/* 	"lastly_change_time" : 档案最近更改时间                                                           */
/* 	"delete_time" : 档案删除时间                                                                    */
/* 	"recovery_time" : 档案恢复时间                                                                  */
/* 	"human_file_status" : 档案状态                                                                */  
public class HumanFile implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer huf_id;
	/**
	 * 
	 */
//	private S
	private Integer minPage;
	private Integer maxPage;
	private Integer count;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
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
	private Double demand_salaray_sum;
	@Override
	public String toString() {
		return "HumanFile [huf_id=" + huf_id + ", demand_salaray_sum=" + demand_salaray_sum + ", remark=" + remark
				+ ", human_id=" + human_id + ", first_kind_name=" + first_kind_name + ", first_kind_id=" + first_kind_id
				+ ", second_kind_id=" + second_kind_id + ", second_kind_name=" + second_kind_name + ", third_kind_id="
				+ third_kind_id + ", third_kind_name=" + third_kind_name + ", human_address=" + human_address
				+ ", human_name=" + human_name + ", human_postcode=" + human_postcode + ", human_pro_designation="
				+ human_pro_designation + ", human_major_kind_id=" + human_major_kind_id + ", human_major_kind_name="
				+ human_major_kind_name + ", human_major_id=" + human_major_id + ", hunma_major_name="
				+ hunma_major_name + ", human_telephone=" + human_telephone + ", human_mobilephone=" + human_mobilephone
				+ ", human_account=" + human_account + ", human_bank=" + human_bank + ", human_email=" + human_email
				+ ", human_hobby=" + human_hobby + ", human_qq=" + human_qq + ", human_speciality=" + human_speciality
				+ ", human_sex=" + human_sex + ", human_religion=" + human_religion + ", human_party=" + human_party
				+ ", human_nationality=" + human_nationality + ", human_race=" + human_race + ", human_birthday="
				+ human_birthday + ", human_birthplace=" + human_birthplace + ", human_age=" + human_age
				+ ", human_educated_degree=" + human_educated_degree + ", human_educated_years=" + human_educated_years
				+ ", human_educated_major=" + human_educated_major + ", human_society_security_id="
				+ human_society_security_id + ", human_id_card=" + human_id_card + ", salary_standard_id="
				+ salary_standard_id + ", salary_standard_name=" + salary_standard_name + ", salary_sum=" + salary_sum
				+ ", demand_salary_sum=" + demand_salary_sum + ", paid_salary_sum=" + paid_salary_sum
				+ ", major_change_amount=" + major_change_amount + ", bonus_amount=" + bonus_amount
				+ ", training_amount=" + training_amount + ", file_change_amount=" + file_chang_amount
				+ ", human_history_records=" + human_histroy_records + ", human_family_membership="
				+ human_family_membership + ", human_picture=" + human_picture + ", attchment_name=" + attachment_name
				+ ", check_status=" + check_status + ", register=" + register + ", checker=" + checker + ", changer="
				+ changer + ", regist_time=" + regist_time + ", check_time=" + check_time + ", change_time="
				+ change_time + ", lastly_change_time=" + lastly_change_time + ", delete_time=" + delete_time
				+ ", recovery_time=" + recovery_time + ", human_file_status=" + human_file_status
				+ ", human_pro_desgination=" + human_pro_desgination + ", human_major_name=" + human_major_name
				+ ", human_mobliephone=" + human_mobliephone + ", picUrl=" + picUrl + "]";
	}
	private String remark;
	private String human_id;
	
	
	public Integer getHuf_id() {
		return huf_id;
	}
	public void setHuf_id(Integer huf_id) {
		this.huf_id = huf_id;
	}
	public Double getDemand_salaray_sum() {
		return demand_salaray_sum;
	}
	public void setDemand_salaray_sum(Double demand_salaray_sum) {
		this.demand_salaray_sum = demand_salaray_sum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHuman_id() {
		return human_id;
	}
	public void setHuman_id(String human_id) {
		this.human_id = human_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
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
	public void setThird_kind_name(String third_kind_name) {
		this.third_kind_name = third_kind_name;
	}
	public String getHuman_address() {
		return human_address;
	}
	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public String getHuman_postcode() {
		return human_postcode;
	}
	public void setHuman_postcode(String human_postcode) {
		this.human_postcode = human_postcode;
	}
	public String getHuman_pro_designation() {
		return human_pro_designation;
	}
	public void setHuman_pro_designation(String human_pro_designation) {
		this.human_pro_designation = human_pro_designation;
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
	public String getHunma_major_name() {
		return hunma_major_name;
	}
	public void setHunma_major_name(String hunma_major_name) {
		this.hunma_major_name = hunma_major_name;
	}
	public String getHuman_telephone() {
		return human_telephone;
	}
	public void setHuman_telephone(String human_telephone) {
		this.human_telephone = human_telephone;
	}
	public String getHuman_mobilephone() {
		return human_mobilephone;
	}
	public void setHuman_mobilephone(String human_mobilephone) {
		this.human_mobilephone = human_mobilephone;
	}
	public String getHuman_account() {
		return human_account;
	}
	public void setHuman_account(String human_account) {
		this.human_account = human_account;
	}
	public String getHuman_bank() {
		return human_bank;
	}
	public void setHuman_bank(String human_bank) {
		this.human_bank = human_bank;
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
	public String getHuman_qq() {
		return human_qq;
	}
	public void setHuman_qq(String human_qq) {
		this.human_qq = human_qq;
	}
	public String getHuman_speciality() {
		return human_speciality;
	}
	public void setHuman_speciality(String human_speciality) {
		this.human_speciality = human_speciality;
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
	public String getHuman_birthplace() {
		return human_birthplace;
	}
	public void setHuman_birthplace(String human_birthplace) {
		this.human_birthplace = human_birthplace;
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
	public String getHuman_society_security_id() {
		return human_society_security_id;
	}
	public void setHuman_society_security_id(String human_society_security_id) {
		this.human_society_security_id = human_society_security_id;
	}
	public String getHuman_id_card() {
		return human_id_card;
	}
	public void setHuman_id_card(String human_id_card) {
		this.human_id_card = human_id_card;
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
	public Double getDemand_salary_sum() {
		return demand_salary_sum;
	}
	public void setDemand_salary_sum(Double demand_salary_sum) {
		this.demand_salary_sum = demand_salary_sum;
	}
	public Double getPaid_salary_sum() {
		return paid_salary_sum;
	}
	public void setPaid_salary_sum(Double paid_salary_sum) {
		this.paid_salary_sum = paid_salary_sum;
	}
	public Integer getMajor_change_amount() {
		return major_change_amount;
	}
	public void setMajor_change_amount(Integer major_change_amount) {
		this.major_change_amount = major_change_amount;
	}
	public Integer getBonus_amount() {
		return bonus_amount;
	}
	public void setBonus_amount(Integer bonus_amount) {
		this.bonus_amount = bonus_amount;
	}
	public Integer getTraining_amount() {
		return training_amount;
	}
	public void setTraining_amount(Integer training_amount) {
		this.training_amount = training_amount;
	}
	public Integer getFile_chang_amount() {
		return file_chang_amount;
	}
	public void setFile_chang_amount(Integer file_chang_amount) {
		this.file_chang_amount = file_chang_amount;
	}
	public String getHuman_history_records() {
		return human_histroy_records;
	}
	public void setHuman_history_records(String human_history_records) {
		this.human_histroy_records = human_history_records;
	}
	public String getHuman_family_membership() {
		return human_family_membership;
	}
	public void setHuman_family_membership(String human_family_membership) {
		this.human_family_membership = human_family_membership;
	}
	public String getHuman_picture() {
		return human_picture;
	}
	public void setHuman_picture(String human_picture) {
		this.human_picture = human_picture;
	}
	public String getAttchment_name() {
		return attachment_name;
	}
	public void setAttchment_name(String attchment_name) {
		this.attachment_name = attchment_name;
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
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
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
	public Date getChange_time() {
		return change_time;
	}
	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
	public Date getLastly_change_time() {
		return lastly_change_time;
	}
	public void setLastly_change_time(Date lastly_change_time) {
		this.lastly_change_time = lastly_change_time;
	}
	public Date getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(Date delete_time) {
		this.delete_time = delete_time;
	}
	public Date getRecovery_time() {
		return recovery_time;
	}
	public void setRecovery_time(Date recovery_time) {
		this.recovery_time = recovery_time;
	}
	public Boolean getHuman_file_status() {
		return human_file_status;
	}
	public void setHuman_file_status(Boolean human_file_status) {
		this.human_file_status = human_file_status;
	}
	public String getHuman_pro_desgination() {
		return human_pro_desgination;
	}
	public void setHuman_pro_desgination(String human_pro_desgination) {
		this.human_pro_desgination = human_pro_desgination;
	}
	public String getHuman_major_name() {
		return human_major_name;
	}
	public void setHuman_major_name(String human_major_name) {
		this.human_major_name = human_major_name;
	}
	public String getHuman_mobliephone() {
		return human_mobliephone;
	}
	public void setHuman_mobliephone(String human_mobliephone) {
		this.human_mobliephone = human_mobliephone;
	}
	public List<MultipartFile> getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(List<MultipartFile> picUrl) {
		this.picUrl = picUrl;
	}
	private String first_kind_name;
	private String first_kind_id;
	private String second_kind_id;
	private String second_kind_name;
	private String third_kind_id;
	private String third_kind_name;
	private String human_address;
	private String human_name;
	private String human_postcode;
	private String human_pro_designation;
	
	private String human_major_kind_id;
	private String human_major_kind_name;
	private String human_major_id;
	private String hunma_major_name;
	private String human_telephone;
	private String human_mobilephone;
	private String human_account;
	private String human_bank;
	private String human_email;
	private String human_hobby;
	private String human_qq;
	private String human_speciality;
	private String human_sex;
	private String human_religion;
	private String human_party;
	private String human_nationality;
	private String human_race;
	private Date human_birthday;
	private String human_birthplace;
	private Integer human_age;
	private String human_educated_degree;
	private Integer human_educated_years;
	private String human_educated_major;
	private String human_society_security_id;
	private String human_id_card;
	private String salary_standard_id;
	private String salary_standard_name;
	private Double salary_sum;
	private Double demand_salary_sum;
	private Double paid_salary_sum;
	private Integer major_change_amount;
	private Integer bonus_amount;
	private Integer training_amount;
	private Integer file_chang_amount;
	private String human_histroy_records;
	private String human_family_membership;
	private String human_picture;
	private String attachment_name;
	private Integer check_status;
	private String register;
	private String checker;
	private String changer;
	private Date regist_time;
	private Date check_time;
	private Date change_time;
	private Date lastly_change_time;
	private Date delete_time;
	private Date recovery_time;
	private Boolean human_file_status;
	private String human_pro_desgination;
	private String human_major_name;
	private String human_mobliephone;
	//标准javabean方法在页面上，可以利用  ${book.pdfsStringList}
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
	//  界面用
	private List<MultipartFile> picUrl;
	
}
