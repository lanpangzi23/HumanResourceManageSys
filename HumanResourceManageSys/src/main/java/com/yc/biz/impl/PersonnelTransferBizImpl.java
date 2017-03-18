package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yc.bean.HumanFile;
import com.yc.biz.PersonnelTransferBiz;
import com.yc.dao.BaseDao;
import com.yc.dao.impl.BaseDaoMybatisImpl;
@Repository
public class PersonnelTransferBizImpl implements PersonnelTransferBiz {
	private BaseDaoMybatisImpl baseDaoMybatisImpl;
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDaoMybatisImpl =baseDaoMybatisImpl ;
	}
	@Override//根据机构，姓名等查找需要调动的人的信息
	public List<HumanFile> findPersonnel(HumanFile humanfile) {
		List <HumanFile> list=this.baseDaoMybatisImpl.findAll(humanfile,  "selectPersonInfos");
		return list;
	}
	@Override
	public HumanFile insert(HumanFile human) {
		HumanFile hf=new HumanFile();
		hf.setHuman_name(hf.getHuman_name());
		hf.setHuman_id_card(hf.getHuman_id_card());
		this.baseDaoMybatisImpl.add(hf, "insertHumanFile");
		return hf;
	}


}
