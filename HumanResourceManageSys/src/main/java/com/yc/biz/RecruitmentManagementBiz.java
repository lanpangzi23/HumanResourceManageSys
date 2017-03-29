package com.yc.biz;
import java.util.List;
import com.yc.bean.EngageMajorRelease;
public interface RecruitmentManagementBiz {
	public void addEngageMajor(EngageMajorRelease emr);//职位发表登记
	public List<EngageMajorRelease> findEngageMajor(Integer page,Integer rows,Integer name);//分页查看所有发布的职位(包含条件查询)
	public void updateEngageMajor(EngageMajorRelease emr);//根据职位名称变更职位信息
	public void deleteEngageMajor(int id);//根据职位id删除职位信息
}
