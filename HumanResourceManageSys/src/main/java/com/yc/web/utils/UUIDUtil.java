package com.yc.web.utils;

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

}
