package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

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
/* 	"file_chang_amount" : 档案变更累计次数                                                            */
/* 	"human_histroy_records" : 简历                                                              */
/* 	"human_family_membership" : 家庭关系                                                          */
/* 	"human_picture" : 相片                                                                      */
/* 	"attachment_name" : 附件名称                                                                  */
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
	private int huf_id;
	private String human_id;
	private String first_kind_name;
	private String first_kind_id;
	private String second_kind_id;
	private String second_kind_name;
	private String third_kind_id;
	private String third_kind_name;
	private String human_address;
	private String human_name;
	private String human_postcode;
	private String human_pro_desgination;
	private String human_major_kind_id;
	private String human_major_kind_name;
	private String human_major_id;
	private String human_major_name;
	private String human_telephone;
	private String human_mobliephone;
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
	private int human_age;
	private String human_educated_degree;
	private int human_educated_years;
	private String human_educated_major;
	private String human_society_security_id;
	private String human_id_card;
	private String remark;
	private String salary_standard_id;
	private String salary_standard_name;
	private double salary_sum;
	private double demand_salary_sum;
	private double paid_salary_sum;
	private int major_change_amount;
	private int bonus_amount;
	private int training_amount;
	private int file_change_amount;
	private String human_history_records;
	private String human_family_membership;
	private String human_picture;
	private String attchment_name;
	private int check_status;
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
}
