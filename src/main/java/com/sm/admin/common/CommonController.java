package com.sm.admin.common;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Users;


@Component
public class CommonController {

     public Users user = null;

    /*@ModelAttribute
	public void getLoggedUser(HttpSession session,Principal pricipal,Model model){
		if(pricipal!=null){
			user=userService.findUserByUserName(pricipal.getName());
			if(user!=null){
				
			}
			model.addAttribute("user", user);
		}
	}*/
	
	@Autowired protected ServletContext context;
	

	@Autowired 
	protected VelocityEngine velocityEngine;
	
	@Autowired 
	protected EmailSender emailSender;
	
	public static String SMSAuthetications(UsersDto users){
		
		//Send SMS API
		String smsUrl="https://control.msg91.com/api/sendhttp.php?";
		//Your authentication key
		String authkey = "103508AYUbCyawSS56a9b5fc";
		//Sender ID,While using route4 sender id should be 6 characters long.
		String senderId = "ravirk";
		//define route
		String route="4";
		
		String sbPostData=PrepareAutheticationURL(users,smsUrl,authkey,route,senderId);
		smsUrl=sbPostData;
		return smsUrl;
	}
	
	@SuppressWarnings("deprecation")
	private static String PrepareAutheticationURL(UsersDto users,String smsUrl, String authkey, String route, String senderId) {

		//encoding message 
		String encoded_message=URLEncoder.encode(PrepareSMSMessage(users).toString());
		StringBuilder sbPostData=new StringBuilder(smsUrl);
		sbPostData.append("authkey="+authkey); 
		sbPostData.append("&mobiles="+users.getMobile_no());
		sbPostData.append("&message="+encoded_message);
		sbPostData.append("&route="+route);
		sbPostData.append("&sender="+senderId);

		//final string
		smsUrl = sbPostData.toString();
		return smsUrl.toString();
	}

	private static String PrepareSMSMessage(UsersDto users) {
		
		StringBuilder message=new StringBuilder();
		
		if(StringUtils.isNotEmpty(users.getDynamic_access_code())){
			message.append("Dear "+users.getFirstname()+" "+users.getLastname());
			message.append("  Your verification Dynamic Access Code is "+users.getDynamic_access_code());
		}
		
		return message.toString();
	}

	protected static String getDynamicCode() {
		String code = null;
		for(int i=0;i<1;i++){
			 code=String.valueOf( Math.round(Math.random()*1000000));
		}
		return code;
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	
	}
	
	public static Date convertStringtoDateIndDDMMyyyyhhmmss(String strDate){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("StrDate:"+strDate);
		Date date = null;
		try {
			// Converting the input String to Date
			date = df.parse(strDate);

		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		System.out.println("Date:"+date);
		return date;

	}

	public static Date stringtoDate(String strDate){

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("StrDate:"+strDate);
		Date date = null;
		try {
			// Converting the input String to Date
			date = df.parse(strDate);

		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		System.out.println("Date:"+date);
		return date;

	}
	
	
	public static Date stringtoSqlDate(String strDate){

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("StrDate:"+strDate);
		Date date = null;
		try {
			// Converting the input String to Date
			date = df.parse(strDate);

		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		System.out.println("Date:"+date);
		return date;

	}
	
	public static Date stringtoSqlDateForPropertiy(String strDate){

		DateFormat df = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aa");

		System.out.println("StrDate:"+strDate);
		Date date = null;
		try {
			// Converting the input String to Date
			date = df.parse(strDate);

		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		System.out.println("Date:"+date);
		return date;

	}
	
	public static Date getDate(Integer size)
	{
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, size);
		Date nextDate = cal.getTime();
		return nextDate;
	}
	
}
