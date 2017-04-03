package com.yc.biz;

import java.util.List;

import com.yc.bean.Bonus;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;

public interface BonusBiz {
	//添加激励项目名称和查找
	boolean addBonusType(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findBonusType(ConfigPublicChar configPublicChar);
	//添加等级和查找
	boolean addBonusRate(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findBonusRate(ConfigPublicChar configPublicChar);
	//添加价值和查找
	boolean addBonusWorth(ConfigPublicChar configPublicChar);
	List<ConfigPublicChar> findBonusWorth(ConfigPublicChar configPublicChar);
	//简单的人力资源分页查询
	List <HumanFile> findAll(HumanFile humanfile);
	//根据id查找详情
	List<HumanFile> findPersonDetails(String id);
	//提交审核	
	boolean audit(Bonus bonus);
	//查找所有正在审核的奖励人员
	List<Bonus> findAlls(Bonus bonus);
	//根据id查找需要审核的人的详情
	List<Bonus> findBonusDetails(Bonus bonus);
	//通过奖励审核
	boolean bonusThey(Bonus bonus);
}
