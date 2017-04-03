package com.yc.view;
import java.util.List;
import com.yc.bean.EngageSubjects;
public class EngageSubjectsView {
	private String first_kind_id;
	private String first_kind_name;
	private List<EngageSubjects> esList;
	private List<String> fid;
	private List<String> fname;
	private List<String> sid;
	private List<String> sname;
	private List<String> total;
	public List<String> getFid() {
		return fid;
	}
	public void setFid(List<String> fid) {
		this.fid = fid;
	}
	public List<String> getFname() {
		return fname;
	}
	public void setFname(List<String> fname) {
		this.fname = fname;
	}
	public List<String> getSid() {
		return sid;
	}
	public void setSid(List<String> sid) {
		this.sid = sid;
	}
	public List<String> getSname() {
		return sname;
	}
	public void setSname(List<String> sname) {
		this.sname = sname;
	}
	public List<String> getTotal() {
		return total;
	}
	public void setTotal(List<String> total) {
		this.total = total;
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
	public List<EngageSubjects> getEsList() {
		return esList;
	}
	public void setEsList(List<EngageSubjects> esList) {
		this.esList = esList;
	}
}
