package com.yc.biz.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.yc.bean.EngageMajorRelease;
import com.yc.biz.RecruitmentManagementBiz;
import com.yc.dao.BaseDao;
import com.yc.dao.impl.BaseDaoMybatisImpl;
@Repository
public class RecruitmentManagementBizImpl implements RecruitmentManagementBiz{
	private BaseDao baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	public void addEngageMajor(EngageMajorRelease emr) {
		baseDaoMybatisImpl.add(emr, "insertEngageMajorRelease");
	}
	public List<EngageMajorRelease> findEngageMajor(Integer page,Integer rows,String name) {
		EngageMajorRelease emr=new EngageMajorRelease();
		emr.setPage(page);
		emr.setRows(rows);
		emr.setMajor_name(name);
		List<EngageMajorRelease> list=baseDaoMybatisImpl.findAll(emr, "selectEngageMajorRelease");
		return list;
	}
	public void findEngageMajor(EngageMajorRelease emr) {
		baseDaoMybatisImpl.update(emr, "updateEngageMajorRelease");
	}
}
