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
import org.table.SelectPersonDTO;
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

public class InterviewReportAction extends ActionSupport implements ServletContextAware{

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
		
		
		
		String sessionRegId=(String)ServletActionContext.getRequest().getParameter("registrationId");
		
		if(sessionRegId==null && (registrationId==null || captchaCode==null))
		{
			return "inter_home";
		}
		
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",null);
		RegistrationDAO regDAO=new RegistrationDAO();
		
		
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		

		if(sessionRegId==null)
		{
		if(captchaCode==null || !captchaCode.equalsIgnoreCase(generatedCode))
			{
				addFieldError( "Err_captchaError", " Please Write Correctly" );
				return "inter_home";
			}
		else
		{
			ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
		}
		}
		
		SelectPersonDTO personalInfoDto= regDAO.getSelectPersonal(sessionRegId);
		if(personalInfoDto==null)
		{
			addFieldError( "Err_regId", " Invalid Registration Id" );
			return "inter_home";
		}

		
		HttpServletResponse response = ServletActionContext.getResponse();
		PdfReader reader =null;
		ByteArrayOutputStream certificate = null;
		List<PdfReader> readers = new ArrayList<PdfReader>();
		String realPath = servlet.getRealPath("/resources/staticpdf/interview.pdf");
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
			code128.setCode(sessionRegId); 
			PdfTemplate tp128= 
			code128.createTemplateWithBarcode(over, null, null); 
			over.addTemplate(tp128, 405, 738);
		
			//over.addTemplate(tp128, 405, 758);
			
			
			over.beginText();
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(220, 574);
			over.showText(personalInfoDto.getRegId());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(220, 550);
			over.showText(personalInfoDto.getEmpFullName());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(220, 527);
			over.showText(personalInfoDto.getFatherName());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(220, 506);
			over.showText(personalInfoDto.getMotherName());
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(220, 482);
			over.showText(personalInfoDto.getMobileNo());
			
					
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(222, 247);
			over.showText(personalInfoDto.getIDate());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(221, 230);
			over.showText(personalInfoDto.getTtcNmae());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(216, 208);
			over.showText(personalInfoDto.getAddressLine1());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(216, 188);
			over.showText(personalInfoDto.getAddressLine2());
			
			
			over.setFontAndSize(bf, 12);
			over.setTextMatrix(216, 168);
			over.showText(personalInfoDto.getAddressLine3());
			
			
			
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