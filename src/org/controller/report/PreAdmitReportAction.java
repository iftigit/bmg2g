package org.controller.report;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.model.RegistrationDAO;
import org.table.PersonalInfoDTO;
import org.util.PassPhrase;
import org.util.RandomGenerator;
import org.util.ReportUtil;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

public class PreAdmitReportAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = 8854240739341830184L;
	private ServletContext servlet;
	private String registrationId;
	private String captchaCode;
	
	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}


	public String execute() throws Exception
	{	
		
		
		String sessionRegId=(String)ServletActionContext.getRequest().getSession().getAttribute("sessionObj_regId");
		
		if(sessionRegId==null && (registrationId==null || captchaCode==null))
		{
			return "registration_home";
		}
		
		else if(registrationId==null && sessionRegId!=null)
		{
			registrationId=sessionRegId;
		}

		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",null);
		RegistrationDAO regDAO=new RegistrationDAO();
		
		
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		

		if(sessionRegId==null)
		{
		if(captchaCode==null || !captchaCode.equalsIgnoreCase(generatedCode))
			{
				addFieldError( "Err_captchaError", " Please Write Correctly" );
				return "admit_home";
			}
		else
		{
			ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
		}
		}
		
		PersonalInfoDTO personalInfoDto= regDAO.getPersonalInformation(registrationId);
		if(personalInfoDto==null)
		{
			addFieldError( "Err_regId", " Invalid Registration Id" );
			return "admit_home";
		}

		
		HttpServletResponse response = ServletActionContext.getResponse();
		PdfReader reader =null;
		ByteArrayOutputStream certificate = null;
		List<PdfReader> readers = new ArrayList<PdfReader>();
		String realPath = servlet.getRealPath("/resources/staticpdf/application.pdf");
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		document.setPageSize(PageSize.A4);
		document.setMargins(10, 10, 10, 10);
		
		
		try
		{
			reader = new PdfReader(new FileInputStream(realPath));
			certificate = new ByteArrayOutputStream();
			PdfStamper stamp = new PdfStamper(reader,certificate);
			PdfContentByte over;
			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.WINANSI,BaseFont.EMBEDDED);
			over = stamp.getOverContent(1);
			
			Barcode128 code128 = new Barcode128(); 
			code128.setCode(registrationId); 
			PdfTemplate tp128= 
			code128.createTemplateWithBarcode(over, null, null); 
			over.addTemplate(tp128, 405, 758);
			
			/*cb.concatCTM(1, 0, 0, 1, 295, 770); 
				Barcode128 code128 = new Barcode128(); 
				code128.setCode(BOLNULDV);                  // code 
				code128.setCodeType(Barcode.CODE128); // type 
				code128.setBarHeight(15);             // height of the 
				tall bars 
				code128.setSize(11);                  // height of the 
				short bars 
				code128.setBaseline(12);              // the text 
				distance under the bar 
				code128.setN(5f);              // distance between 
				bars 
				code128.setX(1f);            // bar width 
				code128.setFont(courB); 
				code128.placeBarcode(cb, null, null); 
				... 
				cb.setFontAndSize(cour, 7); 
				cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "Data e 
				ora", 450, 754, 0); 
			*/
			
			over.beginText();
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(200, 587);
			over.showText(personalInfoDto.getRegId());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(200, 562);
			over.showText(personalInfoDto.getEmpFullName());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(200, 538);
			over.showText(personalInfoDto.getFatherName());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(200, 514);
			over.showText(personalInfoDto.getMotherName());
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(200, 488);
			over.showText(personalInfoDto.getContactMobileNumber());
			
			
			over.setFontAndSize(bf, 8);
			over.setTextMatrix(90, 456);
			over.showText("Printed on : "+personalInfoDto.getPrintedOn()+"    IP Address :"+personalInfoDto.getIpAddress()+"  Union : "+personalInfoDto.getQuotaUnionName()+"  Submitted on :"+personalInfoDto.getApplicationDateTime());
			
			

			over.endText();
			stamp.close();
			readers.add(new PdfReader(certificate.toByteArray()));
			
			
						
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		if(readers.size()>0)
		{
			PdfWriter writer = PdfWriter.getInstance(document, out);
			document.open();
			
			PdfContentByte cb = writer.getDirectContent();
			PdfReader pdfReader = null;
			PdfImportedPage page;
			
			for(int k=0;k<readers.size();k++)
			{
				document.newPage();
				pdfReader = readers.get(k);
				page = writer.getImportedPage(pdfReader, 1);
				cb.addTemplate(page, 0, 0);
			}
			

			document.close();
			ReportUtil rptUtil = new ReportUtil();
			rptUtil.downloadPdf(out, response);
			document=null;	
					
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
		
		return null;	
		
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
	
	

}
