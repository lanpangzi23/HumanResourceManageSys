package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Users;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
@Service
public class UserBizImpl implements UserBiz {
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<Users> selectUserByName(Users users) {
		List<Users> list=this.baseDao.findAll(users, "selectUserByName");
		return list;
	}
	@Override
	public Users save(Users users) {
		this.baseDao.add(users, "saveUser");
		return users;
	}
	@Override
	public Users updateUsers(Users users) {
		this.baseDao.update(users, "updateUser");
		return users;
	}
	@Override
	public List<Users> getAllUsers() {
		List<Users> list=this.baseDao.findAll(new Users(), "selectUser");
		return list;
	}
	@Override
	public Users deleteUsers(Users users) {
		this.baseDao.delete(users, "deleteUser");
		return users;
	}

}
