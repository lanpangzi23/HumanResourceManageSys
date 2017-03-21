package com.yc.web.utils;
import java.util.Date;
public class ResponseData {
	private String total;
	private String charact;
	private Object rows;
	private Date date;
	private String salary_grant_id;
	private int count;
	private Double paidSalarySum;
	public Double getPaidSalarySum() {
		return paidSalarySum;
	}
	public void setPaidSalarySum(Double paidSalarySum) {
		this.paidSalarySum = paidSalarySum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSalary_grant_id() {
		return salary_grant_id;
	}
	public void setSalary_grant_id(String salary_grant_id) {
		this.salary_grant_id = salary_grant_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCharact() {
		return charact;
	}
	public void setCharact(String charact) {
		this.charact = charact;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
}
