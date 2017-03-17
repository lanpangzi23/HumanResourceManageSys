package com.yc.biz;
import java.util.List;

import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
public interface SalaryAdministrationBiz {
	public void addSalaryStandard(SalaryStandard salaryS,SalaryStandardDetails ssd);
	public List<SalaryStandard> findSalaryStandard(int minPage,int maxPage);
	public List<Object> findSalaryStandardDetails(String id);
	public void reviewSalaryStandard(String standard_id,String check_commnt);
	public List<SalaryStandard> fuzzyQuery(SalaryStandard ss);
}
