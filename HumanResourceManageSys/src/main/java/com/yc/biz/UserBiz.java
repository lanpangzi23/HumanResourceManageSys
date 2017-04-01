package com.yc.biz;

import java.util.List;

import com.yc.bean.Users;

public interface UserBiz {
	public List<Users> selectUserByName(Users users);

}
