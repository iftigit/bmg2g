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
import org.table.VisaDTO;
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

public class VisaReportAction extends ActionSupport implements ServletContextAware{

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
	
	
	
	
	RegistrationDAO regDAO=new RegistrationDAO();
	
	
	ArrayList<VisaDTO> vlist = new ArrayList<VisaDTO>();
	VisaDTO vDTO = null;
	vlist = regDAO.getVisaDataAll();
	
	

	
	HttpServletResponse response = ServletActionContext.getResponse();
	PdfReader reader =null;
	ByteArrayOutputStream certificate = null;
	List<PdfReader> readers = new ArrayList<PdfReader>();
	String realPath = servlet.getRealPath("/resources/staticpdf/visa1.pdf");
	String realPath1 = servlet.getRealPath("/resources/staticpdf/visa2.pdf");
	Document document = new Document();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	document.setPageSize(PageSize.A4);
	document.setMargins(10, 10, 10, 10);
	
	
	try
	{
		BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.WINANSI,BaseFont.EMBEDDED);
		
		
		for(int i=0;i<vlist.size();i++)
		{
			vDTO=vlist.get(i);
		
		reader = new PdfReader(new FileInputStream(realPath));
		certificate = new ByteArrayOutputStream();
		PdfStamper stamp = new PdfStamper(reader,certificate);
		PdfContentByte over;
				
		over = stamp.getOverContent(1);
				
		over.beginText();
		
		
		over.setFontAndSize(bf, 14);
		over.setTextMatrix(240, 667);
		over.showText("X");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(90, 579);
		over.showText(vDTO.getName());
		
		
		over.setFontAndSize(bf, 14);
		over.setTextMatrix(218, 548);
		over.showText("X");
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(180, 520);
		over.showText("BANGLADESH");
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(168, 488);
		over.showText(vDTO.getBday());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(205, 488);
		over.showText(vDTO.getBmon());
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(230, 488);
		over.showText(vDTO.getByear());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(390, 488);
		over.showText("BANGLADESHI");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(168, 445);
		over.showText("PLANTATION");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(166,413);
		over.showText(vDTO.getAddress1());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(166,397);
		over.showText(vDTO.getAddress2());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(166,380);
		over.showText(vDTO.getAddress3());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(410, 346);
		over.showText(vDTO.getMobile());
		
		
		if(vDTO.getMaritalstatus().equalsIgnoreCase("Married"))
		{
			over.setFontAndSize(bf, 14);
			over.setTextMatrix(352, 305);
			over.showText("X");
		}
		else
		{
			
			
			over.setFontAndSize(bf, 14);
			over.setTextMatrix(250, 305);
			over.showText("X");
			
		}
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(210, 220);
		over.showText("PASSPORT");
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(210, 177);
		over.showText(vDTO.getPassport());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(210, 134);
		over.showText("BANGLADESH");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(215, 90);
		over.showText(vDTO.getEday());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(255, 90);
		over.showText(vDTO.getEmon());
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(293, 90);
		over.showText(vDTO.getEyear());
		
		over.endText();
		stamp.close();
		
		readers.add(new PdfReader(certificate.toByteArray()));
		certificate.close();
		
		
		PdfReader reader1 = new PdfReader(new FileInputStream(realPath1));
		ByteArrayOutputStream certificate1 = new ByteArrayOutputStream();
		PdfStamper stamp1 = new PdfStamper(reader1,certificate1);
		over = stamp1.getOverContent(1);		
		over.beginText();
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(195, 688);
		over.showText("UNITED PLANTATIONS BERHAD (240A)");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(425, 650);
		over.showText("");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(195, 612);
		over.showText("JENDARATA ESTATE TELUK INTAN");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(195,593);
		over.showText("36009 HILIR PERAK,");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(195, 578);
		over.showText("PERAK, MALAYSIA.");
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(195, 560);
		over.showText("");
		
		
		over.setFontAndSize(bf, 12);
		over.setTextMatrix(300, 476);
		over.showText("24");
		
		over.setFontAndSize(bf, 14);
		over.setTextMatrix(345, 312);
		over.showText("X");
		
		
		over.endText();
		stamp1.close();
		
		
		
		readers.add(new PdfReader(certificate1.toByteArray()));
		
		} //for loop
					
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
