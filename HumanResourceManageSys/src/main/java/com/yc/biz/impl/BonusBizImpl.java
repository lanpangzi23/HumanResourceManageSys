package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yc.bean.Bonus;
import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.biz.BonusBiz;
import com.yc.dao.BaseDao;
@Repository
public class BonusBizImpl implements BonusBiz {
	private BaseDao baseDaoMybatisImpl;
	@Resource
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	@Override
	public boolean addBonusType(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addBonus");
		return true;
	}
	@Override
	public boolean addBonusRate(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addBonus");
		return true;
	}
	@Override
	public boolean addBonusWorth(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addBonus");
		return true;
	}
	@Override
	public List<ConfigPublicChar> findBonusType(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllBonus");
		return list;
	}
	@Override
	public List<ConfigPublicChar> findBonusRate(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllBonus");
		return list;
	}
	@Override
	public List<ConfigPublicChar> findBonusWorth(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllBonus");
		return list;
	}
	@Override
	public List<HumanFile> findAll(HumanFile humanfile) {
		// TODO Auto-generated method stub

		List<HumanFile> list=baseDaoMybatisImpl.findAll(humanfile, "selectAllPerson");
		return list;
		
	}
	//根据id查找详情
			public List<HumanFile> findPersonDetails(String id){
				HumanFile hf=new HumanFile();
				List<HumanFile> list=new ArrayList<>();
				hf.setHuman_id(id);
				List<HumanFile> salaryStandard=baseDaoMybatisImpl.findAll(hf, "selectTransferDetails");
				list.add(salaryStandard.get(0));
				return list;
			}
			@Override
			public boolean audit(Bonus bonus) {
				this.baseDaoMybatisImpl.add(bonus, "toAudit");
				return true;
			}
			@Override
			public List<Bonus> findAlls(Bonus bonus) {
				List <Bonus> list=this.baseDaoMybatisImpl.findAll(bonus, "selectByPage");
				return list;
			}
			@Override
			public List<Bonus> findBonusDetails(Bonus bonus) {
				List<Bonus> list=this.baseDaoMybatisImpl.findAll(bonus, "selectById");
				return list;
			}
			@Override
			public boolean bonusThey(Bonus bonus) {
				this.baseDaoMybatisImpl.update(bonus, "bonusThey");
				return true;
			}
		
	
}
