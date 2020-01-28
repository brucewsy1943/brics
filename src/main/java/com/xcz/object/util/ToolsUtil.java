package com.xcz.object.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToolsUtil {

	
	public final static String SUCCESS = "SUCCESS";
	public final static String FAIL = "FAIL";
	
	// 转码方法
	public static String getES(String str) {
		String st = null;
		try {
			st = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	// 转码方法
		public static String getES1(String str) {
			String st = null;
			try {
				st = new String(str.getBytes("GBK"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return st;
		}
		
		
		// 转码方法
		public static String getES2(String str) {
			String st = null;
			try {
				st = new String(str.getBytes("utf-8"), "GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return st;
		}
	
	    // 获取系统时间和时间
		public static String getDateAndTime() {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			return time;
		}
		
		
		
		public static String getTypeName(String key){
			Map<String,String> map=new HashMap<String,String>();
			
			
			//细胞联盟
			map.put("细胞产业", "细胞产业");
			
			//新闻资讯
			map.put("zhxw", "综合新闻");
			map.put("hydt", "行业动态");
			map.put("cyhd", "产业活动");
			map.put("tzgg", "通知公告");
			map.put("rczp", "人才招聘");
			map.put("", "");
			return map.get(key);
		}
}
