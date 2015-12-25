package util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类
 * @author czq
 *
 */
public class MyDate implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int year;
	
	public int month;
	
	public int day;
	
	public int hour;
	
	public int minute;
	
	public int second;
	
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		minute = -1;
		hour = -1;
		second = -1;
	}


	public MyDate(int year, int month, int day, int hour, int minute, int second) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public static String toString(MyDate date){
		if(date.hour == -1){
			return String.valueOf(date.year)+ "-" + String.valueOf(date.month) + "-" + String.valueOf(date.day);
		}else{
			return String.valueOf(date.year)+ "-" + String.valueOf(date.month) + "-" + String.valueOf(date.day) + "-" +String.valueOf(date.hour) + "-" + String.valueOf(date.minute) + "-" + String.valueOf(date.second);
		}
	}
	
	public static MyDate getDate(String date){
		String[] temp = date.split("-");
		if(temp.length == 3){
			return new MyDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		}else{
			return new MyDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]) ,Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
		}
	}
	
	public boolean equals(MyDate date){
		if(this.year!=date.year)
			return false;
		if(this.month!=date.month)
			return false;
		if(this.day!=date.day)
			return false;
		return true;
		
	}
	/**
	 * 获得当前系统的时间
	 * @return
	 */
	public static MyDate getNowTime() {
		MyDate date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String[] d = df.format(new Date()).split("-");// new Date()为获取当前系统时间
		try {
			date = new MyDate(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("得到当前时间出错");
		}
		return date;
	}


	public boolean between(MyDate past, MyDate nowDate) {
		if(this.year>nowDate.year||this.year<past.year)
			return false;
		if(this.month>nowDate.month||this.year<past.month)
			return false;
		if(this.day>nowDate.day||this.day<past.day)
			return false;
		return true;
	}
	
}
