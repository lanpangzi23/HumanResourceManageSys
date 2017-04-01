package com.yc.biz.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.biz.HumanBiz;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.dao.BaseDao;
import com.yc.web.utils.RandomNumberUtil;
@Repository
public class RecruitmentManagementBizImpl implements RecruitmentManagementBiz{
	private HumanBiz humanBiz;
	private BaseDao baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	public void addEngageMajor(EngageMajorRelease emr) {
		baseDaoMybatisImpl.add(emr, "insertEngageMajorRelease");
	}
	public List<EngageMajorRelease> findEngageMajor(Integer page,Integer rows,Integer name) {
		EngageMajorRelease emr=new EngageMajorRelease();
		emr.setPage(page);
		emr.setRows(rows);
		emr.setMre_id(name);
		List<EngageMajorRelease> list=baseDaoMybatisImpl.findAll(emr, "selectEngageMajorRelease");
		return list;
	}
	public void updateEngageMajor(EngageMajorRelease emr) {
		baseDaoMybatisImpl.update(emr, "updateEngageMajorRelease");
	}
	public void deleteEngageMajor(int id) {
		EngageMajorRelease emr=new EngageMajorRelease();
		emr.setMre_id(id);
		baseDaoMybatisImpl.delete(emr, "deleteEngageMajorRelease");
	}
	public void addEngageResume(EngageResume er) {
		baseDaoMybatisImpl.add(er, "addEngageResume");
	}
	public List<EngageResume> findEngageResume(Integer rec_id,Integer minPage, Integer maxPage, String human_major_kind_id, String keyword,String minDate, String maxDate,String op) {
		EngageResume er=new EngageResume();
		if(minDate!=null&&!minDate.equals("")){
			er.setMinDate(RandomNumberUtil.toDate(minDate));
		}
		if(maxDate!=null&&!maxDate.equals("")){
			er.setMaxDate(RandomNumberUtil.toDate(maxDate));
		}
		if(keyword!=null&&!keyword.equals("")){
			er.setKeyword('%'+keyword+'%');
		}
		if(human_major_kind_id!=null&&!human_major_kind_id.equals("")){
			er.setHuman_major_kind_id(human_major_kind_id);
		}
		er.setRecomandation(op);//recomandation
		er.setRes_id(rec_id);
		er.setMinPage(minPage);
		er.setMaxPage(maxPage);
		System.out.println(er);
		List<EngageResume> list=baseDaoMybatisImpl.findAll(er, "findEngageResume");
		System.out.println(list);
		return list;
	}
	public void updateEngageResume(EngageResume er) {
		baseDaoMybatisImpl.update(er, "updateEngageResume");
	}
}
