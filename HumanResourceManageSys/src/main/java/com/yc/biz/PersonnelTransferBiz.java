package com.yc.biz;

import java.util.List;

import com.yc.bean.HumanFile;

public interface PersonnelTransferBiz {
	List<HumanFile> findPersonnel(HumanFile humanfile);//根据机构等查找需要调动的人
	HumanFile insert(HumanFile human);
}
