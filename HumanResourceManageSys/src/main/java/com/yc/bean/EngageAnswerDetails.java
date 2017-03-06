package com.yc.bean;

import java.io.Serializable;
/* 创建新表 "engage_answer_details"。                                                              */
/* "engage_answer_details" : 考试答题详细信息                                                         */
/* 	"and_id" : 答案详细信息                                                                         */
/* 	"answer_number" : 答案编号                                                                    */
/* 	"subject_id" : 试题编号                                                                       */
/* 	"answer" : 答题者答案  */
public class EngageAnswerDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3484756009558152413L;
	private int and_id;
	private String answer_number;
	private int subject_id;
	private String answer;
	public int getAnd_id() {
		return and_id;
	}
	public void setAnd_id(int and_id) {
		this.and_id = and_id;
	}
	public String getAnswer_number() {
		return answer_number;
	}
	public void setAnswer_number(String answer_number) {
		this.answer_number = answer_number;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
