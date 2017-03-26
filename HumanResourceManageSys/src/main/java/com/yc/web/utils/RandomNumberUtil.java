package com.yc.web.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class RandomNumberUtil {
	private static Random rd=new Random();
	private static int total=1;
	public static int getTotal(){
		return total++;
	}
	public static String getTenByteNumber(){
		String tenByte="";
		for(int i=0;i<10;i++){
			tenByte=tenByte+rd.nextInt(9);
		}
		return tenByte;
	}
	public static String getSalaryGrantId(){
		String tenByte="";
		String str="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		for(int i=0;i<2;i++){
			tenByte=tenByte+str.charAt(rd.nextInt(26));
		}
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
	public static Date toDate(String datestr){
		if(!datestr.equals("")){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(datestr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
