package com.yc.web.utils;
import java.util.Date;
public class ResponseData {
	private String total;
	private Object rows;
	private Integer totalCount;
	private Date date;
	private String salaryGrantId;
	public String getSalaryGrantId() {
		return salaryGrantId;
	}
	public void setSalaryGrantId(String salaryGrantId) {
		this.salaryGrantId = salaryGrantId;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
}
