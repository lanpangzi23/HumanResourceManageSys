package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.EngageInterview;
import com.yc.bean.EngageMajorRelease;
import com.yc.biz.HireBiz;
import com.yc.dao.BaseDao;
@Service
public class HireBizImpl implements HireBiz {
private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<EngageInterview> selectEngageInterviewByResult(EngageInterview engageInterview) {
		List<EngageInterview> list=this.baseDao.findAll(engageInterview, "selectEngageInterview");
		return list;
	}

}
