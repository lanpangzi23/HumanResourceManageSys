package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.Users;

public interface UserBiz {
	public List<Users> selectUserByName(Users users);
	Users save(Users users);
	Users updateUsers(Users users);
	List<Users> getAllUsers();
	Users deleteUsers(Users users);
}
