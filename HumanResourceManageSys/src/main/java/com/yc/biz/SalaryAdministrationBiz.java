package com.yc.biz;
import java.util.List;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
public interface SalaryAdministrationBiz {
	public void addSalaryStandard(String sqlId,SalaryStandard salaryS);
	public void addSalaryStandardDetails(String sqlId,SalaryStandardDetails salarySD);
	public List<ConfigPublicChar> findSalaryProjectName(String sqlId,ConfigPublicChar cpc);
}
