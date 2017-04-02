package com.yc.biz;
import java.util.List;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.ConfigQuestionFirstKind;
public interface SystemManagementBiz {
	public List<ConfigPublicChar> findSalaryProjectName();
	public boolean updateSalaryProjectName(int pbc_id,String attribute_name);
	public void deleteSalaryProjectName(int pbc_id);
	public boolean addSalaryProjectName(String attribute_name);
	public List<ConfigQuestionFirstKind> findByPage(Integer page,Integer size);//分页查询一级试题机构
}
