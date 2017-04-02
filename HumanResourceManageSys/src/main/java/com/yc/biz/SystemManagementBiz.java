package com.yc.biz;
import java.util.List;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.ConfigQuestionFirstKind;
import com.yc.bean.ConfigQuestionSecondKind;
public interface SystemManagementBiz {
	public List<ConfigPublicChar> findSalaryProjectName();
	public boolean updateSalaryProjectName(int pbc_id,String attribute_name);
	public void deleteSalaryProjectName(int pbc_id);
	public boolean addSalaryProjectName(String attribute_name);
	public List<ConfigQuestionFirstKind> findByPage(Integer page,Integer size);//分页查询一级试题机构
	public void addConfigQuestionFirstKind(String name);//添加一级机构试题
	public void deleteConfigQuestionFirstKind(String id);//删除一级机构试题
	public void updateConfigQuestionFirstKind(String id,String name);//删除一级机构试题
	public List<ConfigQuestionSecondKind> findByPageSecond(Integer page,Integer size,String id);//分页查询二级试题机构
	public void addConfigQuestionSecondKind(ConfigQuestionSecondKind cqsk);//添加二级机构试题
	public void deleteConfigQuestionSecondKind(String id);//删除二级机构试题
	public void updateConfigQuestionSecondKind(String id,String name);//删除二级机构试题
}
