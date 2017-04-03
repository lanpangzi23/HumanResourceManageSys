package com.yc.biz.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.EngageExam;
import com.yc.bean.EngageExamDetails;
import com.yc.bean.EngageInterview;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.EngageResume;
import com.yc.bean.EngageSubjects;
import com.yc.biz.HumanBiz;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.dao.BaseDao;
import com.yc.view.EngageSubjectsView;
import com.yc.web.utils.RandomNumberUtil;
@Repository
@Transactional(readOnly=false)
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
		List<EngageResume> list=baseDaoMybatisImpl.findAll(er, "findEngageResume");
		return list;
	}
	public void updateEngageResume(EngageResume er) {
		baseDaoMybatisImpl.update(er, "updateEngageResume");
	}
	public List<EngageInterview> findEngageInterview(Integer resume_id,Integer page,Integer rows) {
		EngageInterview ei=new EngageInterview();
		ei.setResume_id(resume_id);
		ei.setMinPage(page);
		ei.setMaxPage(rows);
		List<EngageInterview> list=baseDaoMybatisImpl.findAll(ei, "selectEngageInterview");
		return list;
	}
	public void addEngageInterview(EngageInterview ei) {
		baseDaoMybatisImpl.add(ei, "addEngageInterview");
	}
	public void updateEngageResume1(int id) {
		EngageResume er=new EngageResume();
		er.setRes_id(id);
		baseDaoMybatisImpl.update(er, "updateEngageResume1");
	}
	public void updateEngageInterview(EngageInterview ei) {
		ei.setCheck_time(new Date());
		ei.setCheck_status(1);
		baseDaoMybatisImpl.update(ei, "updateEngageInterview");
	}
	public void addEngageSubjects(EngageSubjects es) {
		baseDaoMybatisImpl.add(es, "addEngageSubjects");
	}
	public List<EngageSubjects> findByChoose(String fid, String sid, String keyword, String minDate, String maxDate,Integer page,Integer size) {
		EngageSubjects es=new EngageSubjects();
		if(fid!=null&&!fid.equals("")){
			es.setFirst_kind_id(fid);
		}
		if(sid!=null&&!sid.equals("")){
			es.setSecond_kind_id(sid);
		}
		if(keyword!=null&&!keyword.equals("")){
			es.setKeyword(keyword);
		}
		if(minDate!=null&&!minDate.equals("")){
			es.setMinDate(RandomNumberUtil.toDate(minDate));
		}
		if(maxDate!=null&&!maxDate.equals("")){
			es.setMaxDate(RandomNumberUtil.toDate(maxDate));
		}
		es.setPage(page);
		es.setSize(size);
		List<EngageSubjects> list=baseDaoMybatisImpl.findAll(es, "findEngageSubjects");
		return list;
	}
	public List<EngageExam> findEngageExamByPage(Integer page, Integer rows) {
		EngageExam ee=new EngageExam();
		ee.setPage(page);
		ee.setSize(rows);
		List<EngageExam> list=baseDaoMybatisImpl.findAll(ee, "selectEngageExam");
		return list;
	}
	public List<EngageSubjects> findByGroup() {
		List<EngageSubjects> es=baseDaoMybatisImpl.findAll(new EngageSubjects(),"findEngageSubjects1");
		return es;
	}
	public List<EngageSubjects> findByGroupBySecond(String id) {
		EngageSubjects ee=new EngageSubjects();
		ee.setFirst_kind_id(id);
		List<EngageSubjects> es=baseDaoMybatisImpl.findAll(ee,"findEngageSubjects2");
		return es;
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void addEngageExam(EngageSubjectsView esv, EngageExam ee) {
		String id=RandomNumberUtil.getTenByteNumber();
		ee.setExam_number(id);
		baseDaoMybatisImpl.add(ee, "addEngageExam");
		for(int i=0;i<esv.getSid().size();i++){
			String sid[]=esv.getSid().get(i).split(",");
			String total[]=esv.getTotal().get(i).split(",");
			if(total[1].equals(sid[1])){
				EngageExamDetails eed=new EngageExamDetails();
				eed.setQuestion_amount(Integer.parseInt(total[0]));
				eed.setSecond_kind_id(sid[0]);
				eed.setSecond_kind_name(esv.getSname().get(i));
				eed.setFirst_kind_id(sid[1]);
				eed.setFirst_kind_name(sid[2]);
				eed.setExam_number(id);
				baseDaoMybatisImpl.add(eed, "addEngageExamDetails");
			}
		}
	}
	public List<EngageSubjects> findEngageSubjectsByRandom(int count, String fid, String sid) {
		List<EngageSubjects> list=this.findByChoose(fid, sid, null, null, null, null, null);
		List<EngageSubjects> es=new ArrayList<>();
		for(int i=0;i<count;i++){
			es.add(list.get(new Random().nextInt(list.size())));
		}
		return es;
	}
	public List<EngageExam> findEngageExam(String fid, String sid) {
		EngageExam ee=new EngageExam();
		ee.setMajor_kind_id(fid);
		ee.setMajor_id(sid);
		List<EngageExam> list=baseDaoMybatisImpl.findAll(ee, "selectEngageExam1");
		return list;
	}
	public List<EngageExamDetails> findEngageExamDetails(String id) {
		EngageExamDetails eed=new EngageExamDetails();
		eed.setExam_number(id);
		List<EngageExamDetails> list=baseDaoMybatisImpl.findAll(eed, "findEngageExamDetails");
		return list;
	}
}
