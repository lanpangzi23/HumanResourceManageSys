package com.yc.biz;
import java.util.List;
import com.yc.bean.EngageExam;
import com.yc.bean.EngageExamDetails;
import com.yc.bean.EngageInterview;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.bean.EngageSubjects;
import com.yc.view.EngageSubjectsView;
public interface RecruitmentManagementBiz {
	public void addEngageMajor(EngageMajorRelease emr);//职位发表登记
	public List<EngageMajorRelease> findEngageMajor(Integer page,Integer rows,Integer name);//分页查看所有发布的职位(包含条件查询)
	public void updateEngageMajor(EngageMajorRelease emr);//根据职位名称变更职位信息
	public void deleteEngageMajor(int id);//根据职位id删除职位信息
	public void addEngageResume(EngageResume er);//简历登记
	//根据条件模糊查询
	public List<EngageResume> findEngageResume(Integer rec_id,Integer minPage,Integer maxPage,String human_major_kind_id,String keyword,String minDate,String maxDate,String op);
	public void updateEngageResume(EngageResume er);//修改简历信息
	public void updateEngageResume1(int id);//修改简历信息
	public List<EngageInterview> findEngageInterview(Integer resume_id,Integer page,Integer rows);//查询面试信息
	public void addEngageInterview(EngageInterview ei);//添加面试信息
	public void updateEngageInterview(EngageInterview ei);//修改面试信息，进行面试筛选
	public void addEngageSubjects(EngageSubjects es);//添加试题
	//根据条件查询试题
	public List<EngageSubjects> findByChoose(String fid,String sid,String keyword,String minDate,String maxDate,Integer page,Integer size);
	public List<EngageSubjects> findByGroup();//根据一级试题分类分组查询试题
	public List<EngageSubjects> findByGroupBySecond(String id);//根据一级试题,二级试题分类分组查询试题
	public List<EngageExam> findEngageExamByPage(Integer page,Integer rows);//分页查询试卷表
	public void addEngageExam(EngageSubjectsView esv,EngageExam ee);//添加套题
	public List<EngageSubjects> findEngageSubjectsByRandom(int count,String fid,String sid);//根据题数随机出题
	public List<EngageExam> findEngageExam(String fid,String sid);//根据职位名称查询试卷
	public List<EngageExamDetails> findEngageExamDetails(String id);//根据考试编号查询试卷
}
