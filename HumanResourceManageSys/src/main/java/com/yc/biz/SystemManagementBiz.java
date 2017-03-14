package com.yc.biz;
import java.util.List;
import com.yc.bean.ConfigPublicChar;
public interface SystemManagementBiz {
	public List<ConfigPublicChar> findSalaryProjectName();
	public boolean updateSalaryProjectName(int pbc_id,String attribute_name);
	public void deleteSalaryProjectName(int pbc_id);
	public boolean addSalaryProjectName(String attribute_name);
}
