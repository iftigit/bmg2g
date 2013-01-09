package org.controller.authentication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;
import org.model.*;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;

public class NewPassword extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 633695203157893843L;
	HttpServletResponse response = ServletActionContext.getResponse();
	public String securityCode()
	{
System.out.println((String) ServletActionContext.getRequest().getSession().getAttribute("captchaText"));
System.out.println((String) ServletActionContext.getRequest().getParameter("mobile"));
System.out.println((String) ServletActionContext.getRequest().getParameter("ctext"));

		String submittedCode = (String) ServletActionContext.getRequest().getParameter("ctext");
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		try
		{
			if(!submittedCode.equalsIgnoreCase(generatedCode))
			{
				response.getOutputStream().write("Please type captcha text correctly".getBytes());
				return null;
			}
//			response.getOutputStream().write(getSecurityCode().getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			String scode = getSecurityCode();
			if(scode.length()>5)
				scode=scode.substring(0,5);
			String mobile=(String) ServletActionContext.getRequest().getParameter("mobile");
			String response1 = new NewPaawordDAO().setSecurityCode(mobile, scode);
			if(response1.equalsIgnoreCase("no"))
			{
				response.getOutputStream().write("Please type correct mobile no".getBytes());
				return null;
			}
			if(response1.equalsIgnoreCase("yes"))
			{
				URL yahoo;
				if(mobile.substring(0,3).equalsIgnoreCase("011"))
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
						"&txt="+URLEncoder.encode("Your Conformation Code="+scode)+"&username="+URLEncoder.encode("bmet2")+
						"&password="+URLEncoder.encode("bmet231")); 
				else
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
							"&txt="+URLEncoder.encode("Your Conformation Code="+scode)+"&username="+URLEncoder.encode("bmet")+
							"&password="+URLEncoder.encode("bmet231"));
				URLConnection yc = yahoo.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				String inputLine;
				String inputLine1="";
				while ((inputLine = in.readLine()) != null)
				{
					System.out.println(inputLine);
					if(inputLine!=null)
						inputLine1+=inputLine;
				}
				in.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public String getNewPassword()
	{
System.out.println((String) ServletActionContext.getRequest().getSession().getAttribute("captchaText"));
System.out.println((String) ServletActionContext.getRequest().getParameter("mobile"));
System.out.println((String) ServletActionContext.getRequest().getParameter("ctext"));

		String submittedCode = (String) ServletActionContext.getRequest().getParameter("ctext");
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		try
		{
			if(!submittedCode.equalsIgnoreCase(generatedCode))
			{
				response.getOutputStream().write("Please type captcha text correctly".getBytes());
				return null;
			}
//			response.getOutputStream().write(getSecurityCode().getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			String scode = (String) ServletActionContext.getRequest().getParameter("scode").trim();
			String mobile=(String) ServletActionContext.getRequest().getParameter("mobile");
			String pass = getPasswordCode().substring(0, 5);
			String response1 = new NewPaawordDAO().setPasswordCode(mobile, scode, pass);
			if(response1.equalsIgnoreCase("no"))
			{
				response.getOutputStream().write("Please type correct mobile no or code".getBytes());
				return null;
			}
			if(response1.equalsIgnoreCase("yes"))
			{
				URL yahoo;
				if(mobile.substring(0,3).equalsIgnoreCase("011"))
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
						"&txt="+URLEncoder.encode("Your password is="+pass)+"&username="+URLEncoder.encode("bmet2")+
						"&password="+URLEncoder.encode("bmet231")); 
				else
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
							"&txt="+URLEncoder.encode("Your password is="+pass)+"&username="+URLEncoder.encode("bmet")+
							"&password="+URLEncoder.encode("bmet231")); 
				URLConnection yc = yahoo.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				String inputLine;
				String inputLine1="";
				while ((inputLine = in.readLine()) != null)
				{
					System.out.println(inputLine);
					if(inputLine!=null)
						inputLine1+=inputLine;
				}
				in.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}	
	public String np_pp()
	{
		try
		{
			String pcode=getPasswordCode();
			String mobile = (String) ServletActionContext.getRequest().getParameter("mobile");
			mobile = mobile.trim().substring(mobile.length()-11, mobile.length());
			response.getOutputStream().write("<reply>1</reply>".getBytes());
System.out.println("SMS mobile :"+(String) ServletActionContext.getRequest().getParameter("mobile"));			
System.out.println("SMS code :"+(String) ServletActionContext.getRequest().getParameter("code"));
			if(pcode.length()>5)
				pcode = pcode.substring(0, 5);
//			String response1 = new NewPaawordDAO().setPasswordCode(mobile, scode, pass);
			
			
			
			URL yahoo;
			if(mobile.substring(0,3).equalsIgnoreCase("011"))
				yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
					"&txt="+URLEncoder.encode("Your password is="+pcode)+"&username="+URLEncoder.encode("bmet2")+
					"&password="+URLEncoder.encode("bmet231"));
			else
				yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
						"&txt="+URLEncoder.encode("Your password is="+pcode)+"&username="+URLEncoder.encode("bmet")+
						"&password="+URLEncoder.encode("bmet231")); 		  
				
			URLConnection yc = yahoo.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			String inputLine1="";
			while ((inputLine = in.readLine()) != null)
			{
				System.out.println(inputLine);
				if(inputLine!=null)
					inputLine1+=inputLine;
			}
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public String execute()
	{
//		try
//		{
//			response.getOutputStream().write(getSecurityCode().getBytes());
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return null;
	}
	
  public String getSecurityCode() {
	    Random rand = new Random();
	    int length = rand.nextInt(6) + 8;
	    char[] password = new char[length];
	    for (int x = 0; x < length; x++) {
	      int randDecimalAsciiVal = 0;
	      int cas = rand.nextInt(3);
	      if (cas == 0)
	        randDecimalAsciiVal = rand.nextInt(9) + 48;
	      else if (cas == 1)
	        randDecimalAsciiVal = rand.nextInt(26) + 65;
	      else
	        randDecimalAsciiVal = rand.nextInt(26) + 97;
	      password[x] = String.valueOf(randDecimalAsciiVal/10).charAt(0);
	    }
	    String result = String.valueOf(password);
	    return result;
	  }	   
  public String getPasswordCode() {
	    Random rand = new Random();
	    int length = rand.nextInt(6) + 8;
	    char[] password = new char[length];
	    for (int x = 0; x < length; x++) {
	      int randDecimalAsciiVal = 0;
	      int cas = rand.nextInt(3);
	      if (cas == 0)
	        randDecimalAsciiVal = rand.nextInt(9) + 48;
	      else if (cas == 1)
	        randDecimalAsciiVal = rand.nextInt(26) + 65;
	      else
	        randDecimalAsciiVal = rand.nextInt(26) + 97;
	      password[x] = (char) randDecimalAsciiVal;
	    }
	    String result = String.valueOf(password);
	    return result;
	  }	

}
