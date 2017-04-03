package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yc.bean.ConfigPublicChar;
import com.yc.bean.HumanFile;
import com.yc.bean.Training;
import com.yc.biz.TrainingBiz;
import com.yc.dao.BaseDao;
@Repository
public class TrainingBizImpl implements TrainingBiz {
	private BaseDao baseDaoMybatisImpl;
	@Resource
	public void setBaseDaoMybatisImpl(BaseDao baseDaoMybatisImpl) {
		this.baseDaoMybatisImpl = baseDaoMybatisImpl;
	}
	@Override
	public boolean addItem(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addTraining");
		return true;
	}

	@Override
	public List<ConfigPublicChar> findItem(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllTraining");
		return list;
	}

	@Override
	public boolean addTime(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addTraining");
		return true;
	}

	@Override
	public List<ConfigPublicChar> findTime(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllTraining");
		return list;
	}

	@Override
	public boolean addHour(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addTraining");
		return true;
	}

	@Override
	public List<ConfigPublicChar> findHour(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllTraining");
		return list;
	}

	@Override
	public boolean addDegree(ConfigPublicChar configPublicChar) {
		this.baseDaoMybatisImpl.add(configPublicChar, "addTraining");
		return true;
	}

	@Override
	public List<ConfigPublicChar> findDegree(ConfigPublicChar configPublicChar) {
		List<ConfigPublicChar> list=this.baseDaoMybatisImpl.findAll(configPublicChar, "selectAllTraining");
		return list;
	}
	@Override
	public List<HumanFile> findAll(HumanFile humanfile) {
		// TODO Auto-generated method stub
		List<HumanFile> list=baseDaoMybatisImpl.findAll(humanfile, "selectAllPerson");
		return list;
		
	}
	//根据id查找详情
	@Override
			public List<HumanFile> findPersonDetails(String id){
				HumanFile hf=new HumanFile();
				List<HumanFile> list=new ArrayList<>();
				hf.setHuman_id(id);
				List<HumanFile> salaryStandard=baseDaoMybatisImpl.findAll(hf, "selectTransferDetails");
				list.add(salaryStandard.get(0));
				return list;
		}
	@Override
	public boolean trainingCommit(Training training) {
		this.baseDaoMybatisImpl.add(training, "toTraining");
		return true;
	}
	@Override
	public List<Training> findTraing(Training traininig) {
		List<Training> list=this.baseDaoMybatisImpl.findAll(traininig, "selectTrainingPage");
		return list;
	}
	@Override
	public List<Training> findTrainingDetails(String id) {
		Training training=new Training();
		List<Training> list=new ArrayList<>();
		training.setHuman_id(id);
		List<Training> trainings=baseDaoMybatisImpl.findAll(training, "selectTrainingPage");
		list.add(trainings.get(0));
		return list;
	}
	@Override
	public boolean trainingPass(Training training) {
		baseDaoMybatisImpl.update(training, "trainingPass");
		return true;
	}

}
