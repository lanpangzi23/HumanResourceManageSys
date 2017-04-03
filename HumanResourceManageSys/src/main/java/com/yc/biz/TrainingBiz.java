package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.Training;

public interface TrainingBiz {
	//添加培训名称和查找
	boolean addItem(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findItem(ConfigPublicChar configPublicChar);
	//添加时间和查找
	boolean addTime(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findTime(ConfigPublicChar configPublicChar);
	//添加课程和查找
	boolean addHour(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findHour(ConfigPublicChar configPublicChar);
	//添加等级和查找
	boolean addDegree(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findDegree(ConfigPublicChar configPublicChar);
	//简单的人力资源分页查询
	List <HumanFile> findAll(HumanFile humanfile);
	//根据id查找详情
	List<HumanFile> findPersonDetails(String id);
	//提交培训分配审核
	boolean trainingCommit(Training training);
	//查找正在审核中的人
	List<Training> findTraing(Training traininig);
	//根据id查看详情
	List<Training> findTrainingDetails(String id);
	//审核通过兵确定成绩等级
	boolean trainingPass(Training training);

}
