package org.controller.report;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.model.AddressDAO;
import org.model.RegistrationDAO;
import org.table.AddressDTO;
import org.table.PersonalInfoDTO;
import org.table.PoliceDTO;
import org.table.SelectPersonDTO;
import org.util.PassPhrase;
import org.util.RandomGenerator;
import org.util.ReportUtil;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
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

public class PoliceReportAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = 8854240739341830184L;
	private ServletContext servlet;
	private String registrationId;
	//private String captchaCode;
	
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
		//String distID=(String)ServletActionContext.getRequest().getParameter("distID");
		//ArrayList dlist=AddressDAO.getAllDistrict();
		//ServletActionContext.getRequest().getSession().setAttribute("dlist",dlist);
		if(sessionRegId==null )
		{
			return "police_home";
		}
		
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",null);
		RegistrationDAO regDAO=new RegistrationDAO();
		
		
		
		PoliceDTO pDTO = regDAO.getPoliceData(sessionRegId);
		
		//ArrayList<PoliceDTO> plist = new ArrayList<PoliceDTO>();
		//PoliceDTO pDTO = null;
		//plist = regDAO.getPoliceDataAll(distID);
		
		//Image
//		String ImagePath = servlet.getRealPath("resources/images/");
//		RandomAccessFile raf = new RandomAccessFile(ImagePath+"/P"+pDTO.getRegno()+".jpg", "rw");
//		byte [] image = regDAO.getImage(pDTO.getRegno());
//		int length = (int) image.length;
//		raf.write(image,0,length);
		//image
		
		if(pDTO==null)
		{
			addFieldError( "Err_regId", " Invalid Registration Id" );
			return "police_home";
		}

		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		PdfReader reader =null;
		ByteArrayOutputStream certificate = null;
		List<PdfReader> readers = new ArrayList<PdfReader>();
		String realPath = servlet.getRealPath("/resources/staticpdf/police.pdf");		
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		document.setPageSize(PageSize.A4);
		document.setMargins(10, 10, 10, 10);
		//left,right,top,bottom
		
		try
		{
			//reader = new PdfReader(new FileInputStream(realPath));
			//certificate = new ByteArrayOutputStream();
			//PdfStamper stamp = new PdfStamper(reader,certificate);
			//PdfContentByte over;
			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.WINANSI,BaseFont.EMBEDDED);
			
			
			
//			for(int i=0;i<plist.size();i++)
//			{
//				pDTO=plist.get(i);
				
				reader = new PdfReader(new FileInputStream(realPath));
				certificate = new ByteArrayOutputStream();
				PdfStamper stamp = new PdfStamper(reader,certificate);
				PdfContentByte over;
			over = stamp.getOverContent(1);
			
			Barcode128 code128 = new Barcode128(); 
			code128.setCode(pDTO.getRegno()); 
			PdfTemplate tp128= code128.createTemplateWithBarcode(over, null, null); 
			over.addTemplate(tp128, 25, 790);
		
			//over.addTemplate(tp128, 405, 758);
			
			
			//Image
//			Image ima= Image.getInstance(ImagePath+"/P"+pDTO.getRegno()+".jpg");
//			ima.scalePercent(73);
//			PdfContentByte content = stamp.getUnderContent(1);
//			ima.setAbsolutePosition(467f, 635f);
//			content.addImage(ima);
			//image
			
			
			
			over.beginText();
			
					
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(110, 754);
			over.showText(pDTO.getName());
			
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(110, 728);
			over.showText(pDTO.getFathername());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(120, 707);
			over.showText(pDTO.getRegno());		
			
			
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(110, 685);
			over.showText(pDTO.getRace());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(110, 662);
			over.showText(pDTO.getBirthdate());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(110, 640);
			over.showText(pDTO.getBirthplace());
			
			
			
			over.setFontAndSize(bf, 17);
			over.setTextMatrix(370, 748);
			over.showText(pDTO.getGender());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(360, 708);
			over.showText(pDTO.getPasportno());
			
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(360, 685);
			over.showText(pDTO.getReligion());
			
			over.setFontAndSize(bf, 9);
			over.setTextMatrix(340, 666);
			over.showText(pDTO.getAddress());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(340, 654);
			over.showText(pDTO.getAddress1());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(340, 642);
			over.showText(pDTO.getAddress2());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(340, 630);
			over.showText(pDTO.getAddress3());
			
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(371, 552);
			over.showText(pDTO.getTtcdate());
			
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(445, 552);
			over.showText(pDTO.getTtcname());
			
			
			over.endText();		
			
			stamp.close();
			readers.add(new PdfReader(certificate.toByteArray()));
//			}
				
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
		
		
		
		return null;	
		
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

		

}
