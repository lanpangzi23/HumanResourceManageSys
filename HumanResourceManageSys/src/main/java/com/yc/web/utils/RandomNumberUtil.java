package com.yc.web.utils;
import java.util.Random;
public class RandomNumberUtil {
	private static Random rd=new Random();
	public static String getTenByteNumber(){
		String tenByte="";
		for(int i=0;i<10;i++){
			tenByte=tenByte+rd.nextInt(9);
		}
		return tenByte;
	}
	public static String getTrueNumber(String id){
		int num=0;
		for(int i=0;i<10;i++){
			if(i==9){
				num=Integer.parseInt(id.substring(i-1));
			}else{
				num=Integer.parseInt(id.substring(i, i+1));
			}
			if(num>8){
				return id;
			}
		}
		return "0"+id;
	}
}
