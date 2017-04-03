package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.EngageInterview;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.Users;

public interface HireBiz {
	
	//根据条件查看发布的职位
	public List<EngageInterview> selectEngageInterviewByResult(EngageInterview engageInterview);
}
