package com.yc.view;
import java.util.List;
public class HumanFileAndStandardGrant {
	private List<String> human_id;
	private List<String> human_name;
	private List<Double> bouns_sum;
	private List<Double> sale_sum;
	private List<Double> deduct_sum;
	private List<Double> sum;
	private List<Double> paidsum;
	public List<Double> getSum() {
		return sum;
	}
	public void setSum(List<Double> sum) {
		this.sum = sum;
	}
	public List<Double> getPaidsum() {
		return paidsum;
	}
	public void setPaidsum(List<Double> paidsum) {
		this.paidsum = paidsum;
	}
	public List<String> getHuman_id() {
		return human_id;
	}
	public void setHuman_id(List<String> human_id) {
		this.human_id = human_id;
	}
	public List<String> getHuman_name() {
		return human_name;
	}
	public void setHuman_name(List<String> human_name) {
		this.human_name = human_name;
	}
	public List<Double> getBouns_sum() {
		return bouns_sum;
	}
	public void setBouns_sum(List<Double> bouns_sum) {
		this.bouns_sum = bouns_sum;
	}
	public List<Double> getSale_sum() {
		return sale_sum;
	}
	public void setSale_sum(List<Double> sale_sum) {
		this.sale_sum = sale_sum;
	}
	public List<Double> getDeduct_sum() {
		return deduct_sum;
	}
	public void setDeduct_sum(List<Double> deduct_sum) {
		this.deduct_sum = deduct_sum;
	}
	public String toString() {
		return "HumanFileAndStandardGrant [human_id=" + human_id + ", human_name=" + human_name + ", bouns_sum="
				+ bouns_sum + ", sale_sum=" + sale_sum + ", deduct_sum=" + deduct_sum + ", sum=" + sum + ", paidsum="
				+ paidsum + "]";
	}
}
