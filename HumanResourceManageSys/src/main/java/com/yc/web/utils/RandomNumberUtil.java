package com.yc.web.utils;
import java.util.Random;
public class RandomNumberUtil {
	private static Random rd=new Random();
	private static String tenByte="";
	public static String getTenByteNumber(){
		for(int i=0;i<10;i++){
			tenByte=tenByte+rd.nextInt(9);
		}
		return tenByte;
	}
}
