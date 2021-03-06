package com.yc.biz;

import java.util.List;

import com.yc.bean.ConfigFileSecondKind;
import com.yc.bean.ConfigMajor;
import com.yc.bean.EngageMajorRelease;
import com.yc.bean.Users;

public interface UserBiz {
	public List<Users> selectUserByName(Users users);
	public List<Users> selectUserByHumanId(Users users);
	Users save(Users users);
	Users updateUsers(Users users);
	List<Users> getAllUsers(Users users);
	Users deleteUsers(Users users);
	//根据条件查看发布的职位
	public List<EngageMajorRelease> selectEngageMajorReleaseByName(EngageMajorRelease engageMajorRelease);
}
