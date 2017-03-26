package com.yc.biz;
import java.util.List;
import com.yc.bean.HumanFile;
import com.yc.bean.SalaryGrant;
import com.yc.bean.SalaryStandard;
import com.yc.bean.SalaryStandardDetails;
public interface SalaryAdministrationBiz {
	public void addSalaryStandard(SalaryStandard salaryS,SalaryStandardDetails ssd);
	public List<SalaryStandard> findSalaryStandard(int minPage,int maxPage);
	public List<Object> findSalaryStandardDetails(String id);
	public void reviewSalaryStandard(String standard_id,String check_commnt);
	public List<SalaryStandard> fuzzyQuery(SalaryStandard ss);
	public List<HumanFile> findPayoff(int page,int rows);
	public void updateHumanFile();
	public List<SalaryGrant> findSalaryGrant();
	public List<HumanFile> findHumanName(String firstname,String secondname);
	public List<SalaryStandardDetails> findBySalarySN(String name);
}
