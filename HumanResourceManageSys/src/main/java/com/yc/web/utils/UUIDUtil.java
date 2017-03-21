package com.yc.web.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtil {
	public String getUuidUtil(){
		int machineId=1;
		int hashCodeV=UUID.randomUUID().toString().hashCode();
		if(hashCodeV<0){
			hashCodeV=-hashCodeV;
		}
		return machineId+String.format("%015d", hashCodeV);
		
	}
	//生成机构编号
	public static String getASIC(){
		String aray="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str="";
		for (int i=0;i<2;i++){
			str=str+aray.charAt(new Random().nextInt(58));
		}
		return str;
	}

}
