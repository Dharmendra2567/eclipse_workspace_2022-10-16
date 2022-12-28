package com.learn.mycart.helper;

public class Helper {
	
	
	public static String getTenwords(String description) {
		String[] strs =description.split(" ");
		String result="";
		if(strs.length>10) {
			for(int i =0;i<10;i++) {
			result = result+strs[i]+" ";
			}
			return (result+"...");
		}
		else {
			return (description+"...");
		}
	}

}
