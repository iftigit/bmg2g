package org.controller.authentication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.model.*;
import org.table.UserDTO;

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
			String mobile = (String) ServletActionContext.getRequest().getParameter("mobile");
			if(mobile==null || mobile.length()<11)
			{
				response.getOutputStream().write("You are not authorized user.".getBytes());
				return null;
			}
			
			mobile = mobile.trim().substring(mobile.length()-11, mobile.length());
			
			
System.out.println("SMS mobile :"+(String) ServletActionContext.getRequest().getParameter("mobile"));			
System.out.println("SMS code :"+(String) ServletActionContext.getRequest().getParameter("code"));

			String pass = getPasswordCode().substring(0, 5);
			String response1 = new NewPaawordDAO().setPasswordCode(mobile, "no1234", pass);
			
			if(response1.equalsIgnoreCase("no"))
			{
				response.getOutputStream().write("You are not authorized user.".getBytes());
				return null;
			}
			if(response1.equalsIgnoreCase("yes"))
			{
				response.getOutputStream().write(("Your Password is :"+pass+"").getBytes());
				
//				URL yahoo;
//				if(mobile.substring(0,3).equalsIgnoreCase("011"))
//					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
//						"&txt="+URLEncoder.encode("Your password is="+pass)+"&username="+URLEncoder.encode("bmet2")+
//						"&password="+URLEncoder.encode("bmet231"));
//				else
//					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+mobile)+
//							"&txt="+URLEncoder.encode("Your password is="+pass)+"&username="+URLEncoder.encode("bmet")+
//							"&password="+URLEncoder.encode("bmet231")); 		  
//					
//				URLConnection yc = yahoo.openConnection();
//				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
//				String inputLine;
//				String inputLine1="";
//				while ((inputLine = in.readLine()) != null)
//				{
//					System.out.println(inputLine);
//					if(inputLine!=null)
//						inputLine1+=inputLine;
//				}
//				in.close();
			}
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
  public String sendFirstPassword()
  {
	  ArrayList<UserDTO> tmp = null;
//	  tmp = new NewPaawordDAO().getAllUser();
	  tmp = new NewPaawordDAO().getFirstLottery();
	  Iterator<UserDTO> it = tmp.iterator();
	  String pass = "";
	  int counter=0;
	  while(it.hasNext())
	  {
		  try
		  {
			  UserDTO ut = it.next();

//			  pass = getPasswordCode().substring(0, 5);
//			  NewPaawordDAO.setNewPassword(ut.getUserId(), pass);
//			  String pass1="pls login: g2g.bmet.gov.bd ID:type your mobile no abong Password:"+pass+" .login korte na parle call korun 09613016364.";

//			  String pass1="Apnar attio Mr."+ut.getPassword() +"  Malaysia jabar lotteryte bijoyee hoyechhen. Tahake g2g.bmet.gov.bd  website hote confirmation card songroho kore medical test e ongsho nite bolun.DG,BMET (8322946,8319322, 831751)";
//			  String pass1="Apnar union ar Mr."+ut.getPassword() +"  Malaysia jabar lotteryte bijoyee hoyechhen. Tahake g2g.bmet.gov.bd  website hote confirmation card oti sheeghroi songroho korte bolun.DG,BMET (8322946,8319322, 831751)";
			  
			  String pass1="Apni Passport, Confirmation Card, Medical O Good Conduct Certificate, TK.500 nie 22/8/2013 tarikh BMET, 89/2,Kakrail,Dhaka ashben. DG,BMET(Tel:028322946)";

//			  pass = ut.getPassword();
//			  String pass1="Interview o training ar tarikh abong sthan poriborton hoyeche. Poribortito confirmation card g2g.bmet.gov.bd theke shongroho korun o onayanno bishoy jene nin.";
//			  String pass1="Interview ar din 3 copy PP size cobir sate 1 copy 3R size color full body picture (white background) nie asben.";			  
//			  String pass1="apnar Interview ar sthan change hoiese. apnar confirmation card abar download kore nin.";			  
//			  String pass1="Apni druto Malaysia jete chaile drutoi passport (MRP) korun. Passport office shohojogita korbe.";			  
//			  String pass1="Malaysia te niog bisoe gurutto purno alochona hobe.Apni shoporibare Montri mohodoyer bodorpurer barite agami 2 March Shonibar bikal 3.30 minite alochonae ashben";
//			  String pass1="Onibarjo karone agami 2 March shanibarer Malayshiate niog bishoe Montri mohodoyer barir onushthanti sthogit (cancel) kora hoyeche.";
//			  String pass1="Otisighroe apnar Malaysiar visa asbe. apni Tk.35,500,Passport,Good conduct certificate, Medical certificate, Training certificate,5 copy PP Photo soho ready thakun. Porborti message e apnake flight schedule o Dhaka ashar tarikh janano hobe. DG,BMET";
//			  String pass1="Apnar passport sizer photo (size 5.0cm x 3.5cm,background white) abar shothik vabe pathanor jonno "+ut.getPassword()+"-te jogajog korun. Valo studio theke photo(2 copy) tule TTC-te 20 April 2013 tarikher moddhe joma din. DG, BMET";
//			  String pass1=ut.getPassword()+"-te jogajog kore valo studio theke 2 copy pp size photo(5cm x 3.5cm,background white) tule 24/4/13 tarikher modhye joma din. DG BMET";
//			  String pass1="Apni 28.4.2013 sokal 10 tay airport er pashe hazi camp e obosyoi luggage soho uposthit hoben, apnar Malaysia jabar flight 29.4.2013 sokale. DG BMET.";
//			  String pass1="Apnake etipurbe BMET te ashar jonno message pathano holeo apni ashen nai. Tai apni malaysiay jete chaile agami 01-08-2013 tarikher moddhe passport niye BMET, 89/2, Kakrail, Dhakay obosshoi hazir hoben. DG,BMET (Contact:01716415319,01715228307)";
//			  String pass1="Malaysiay visar jonno apnar uposthiti joruri. Apni malaysiay jete chaile agamikal 13-07-2013 shokale passport niye BMET,89/2 Kakrail,Dhakay obosshoi hazir hoben.DG,BMET (contact:01716415319,01715228307)";
			  
//			  pass2 = "Apni final lotteryte joyi hoyesen. g2g.bmet.gov.bd web thikanay log in kore proshikhhoner sthan o tarikhsoho onyanno bishoy jene nin.";
			  
			  
//			  String pass1="Apnake ovinondon.Apni Malaysia jabar ditio lottery-te bijoyee hoyechhen.Apnake g2g.bmet.gov.bd website hote Confirmation Card songroho kore medical test-e ongshogrohoner jonno onurodh kora holo. DG, BMET. Helpline: 9351275, 8322946,8319322, 8317511";
			  
			  
//			  String pass1="g2g.bmet.gov.bd website thikay apner Confirmation Card songroho korun";
			  
//			  String pass1="Apni malaysiay jete chaile agami 01-08-2013 tarikher moddhe passport niye BMET,89/2, Kakrail, Dhakay obosshoi hazir hoben.DG,BMET(Mob: 01716415319,01715228307)";
			  
			  
		//	  String pass1="Apnar  Malaysia jabar visa asheche. Apni  Passport, Medical certificate,  02 copy passport sizer photo (Background white), Tk. 29000/- niye  21-8-2013  tarikher modhey BMET, 89/2, Kakrail, Dhaka ashben. DG,BMET.";
			  
			  URL yahoo;
				if(ut.getUserId().substring(0,3).equalsIgnoreCase("011"))
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+ut.getUserId())+
							"&txt="+URLEncoder.encode(pass1)+
							"&username="+URLEncoder.encode("bmet2")+"&password="+URLEncoder.encode("BI909")); 		  
				else
					yahoo = new URL("http://123.49.3.58:8081/web_send_sms.php?ms="+URLEncoder.encode("88"+ut.getUserId())+
							"&txt="+URLEncoder.encode(pass1)+
							"&username="+URLEncoder.encode("bmet")+"&password="+URLEncoder.encode("BI909")); 		  
					
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
				counter++;
				if(counter%500==0)
					System.out.println("yes");
//				Thread.sleep(100);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
	  System.out.println("End");
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

  public String getLottery1()
  {
	  
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
			String regid = (String) ServletActionContext.getRequest().getParameter("regid");
			response.getOutputStream().write(new NewPaawordDAO().getLottery1(regid).getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;	  
  }
  
}
