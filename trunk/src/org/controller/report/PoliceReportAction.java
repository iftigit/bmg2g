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
import org.table.FingerDTO;
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
		String distID=(String)ServletActionContext.getRequest().getParameter("distID");
		ArrayList dlist=AddressDAO.getAllDistrict();
		ServletActionContext.getRequest().getSession().setAttribute("dlist",dlist);
//		if(sessionRegId==null )
//		{
//			return "police_home";
//		}
		
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",null);
		RegistrationDAO regDAO=new RegistrationDAO();
		
		
		
		PoliceDTO pDTO = regDAO.getPoliceData(sessionRegId);
		
//		ArrayList<PoliceDTO> plist = new ArrayList<PoliceDTO>();
//		PoliceDTO pDTO = null;
//		plist = regDAO.getPoliceDataAll(distID);
		
		
//		
//		//Image
//		String ImagePath = servlet.getRealPath("resources/images/");
//		RandomAccessFile raf = new RandomAccessFile(ImagePath+"/P"+pDTO.getRegno()+".jpg", "rw");
//		byte [] image = regDAO.getImage(pDTO.getRegno());
//		int length = (int) image.length;
//		raf.write(image,0,length);
//		//image
//		
//		FingerDTO fDTO = regDAO.getFingerData(sessionRegId);
//		//Finger Print
//		RandomAccessFile rafLT = new RandomAccessFile(ImagePath+"/LT"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenLT = (int)fDTO.getLT().length;
//		rafLT.write(fDTO.getLT(),0,lenLT);
//		
//		
//		RandomAccessFile rafLI = new RandomAccessFile(ImagePath+"/LI"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenLI = (int)fDTO.getLI().length;
//		rafLI.write(fDTO.getLI(),0,lenLI);
//		
//		
//		RandomAccessFile rafLM = new RandomAccessFile(ImagePath+"/LM"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenLM = (int)fDTO.getLM().length;
//		rafLM.write(fDTO.getLM(),0,lenLM);
//		
//		
//		RandomAccessFile rafLR = new RandomAccessFile(ImagePath+"/LR"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenLR = (int)fDTO.getLR().length;
//		rafLR.write(fDTO.getLR(),0,lenLR);
//		
//		
//		RandomAccessFile rafLL = new RandomAccessFile(ImagePath+"/LL"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenLL = (int)fDTO.getLL().length;
//		rafLL.write(fDTO.getLL(),0,lenLL);
//		
//		
//		
//		
//		
//		RandomAccessFile rafRT = new RandomAccessFile(ImagePath+"/RT"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenRT = (int)fDTO.getRT().length;
//		rafRT.write(fDTO.getRT(),0,lenRT);
//		
//		
//		RandomAccessFile rafRI = new RandomAccessFile(ImagePath+"/RI"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenRI = (int)fDTO.getRI().length;
//		rafRI.write(fDTO.getRI(),0,lenRI);
//		
//		
//		RandomAccessFile rafRM = new RandomAccessFile(ImagePath+"/RM"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenRM = (int)fDTO.getRM().length;
//		rafRM.write(fDTO.getRM(),0,lenRM);
//		
//		
//		RandomAccessFile rafRR = new RandomAccessFile(ImagePath+"/RR"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenRR = (int)fDTO.getRR().length;
//		rafRR.write(fDTO.getRR(),0,lenRR);
//		
//		
//		RandomAccessFile rafRL = new RandomAccessFile(ImagePath+"/RL"+pDTO.getRegno()+".jpg", "rw"); 
//		int lenRL = (int)fDTO.getRL().length;
//		rafRL.write(fDTO.getRL(),0,lenRL);
//		
//		//Finger	
		
//		if(pDTO==null)
//		{
//			addFieldError( "Err_regId", " Invalid Registration Id" );
//			return "police_home";
//		}

		
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
			
			
//			//Image
//			Image ima= Image.getInstance(ImagePath+"/"+pDTO.getRegno()+".jpg");
//			ima.scalePercent(73);
//			PdfContentByte content = stamp.getUnderContent(1);
//			ima.setAbsolutePosition(467f, 635f);
//			content.addImage(ima);
//			//image
//			
//			
//			//Finger 
//			
//			Image iRT= Image.getInstance(ImagePath+"/RT"+pDTO.getRegno()+".jpg");
//			iRT.scalePercent(25);
//			PdfContentByte conRT = stamp.getUnderContent(1);
//			iRT.setAbsolutePosition(47f, 418f);
//			conRT.addImage(iRT);
//			
//			Image iRI= Image.getInstance(ImagePath+"/RI"+pDTO.getRegno()+".jpg");
//			iRI.scalePercent(25);
//			PdfContentByte conRI = stamp.getUnderContent(1);
//			iRI.setAbsolutePosition(150f, 418f);
//			conRI.addImage(iRI);
//			
//			
//			Image iRM= Image.getInstance(ImagePath+"/RM"+pDTO.getRegno()+".jpg");
//			iRM.scalePercent(25);
//			PdfContentByte conRM = stamp.getUnderContent(1);
//			iRM.setAbsolutePosition(252f, 418f);
//			conRM.addImage(iRM);
//			
//			
//			Image iRR= Image.getInstance(ImagePath+"/RR"+pDTO.getRegno()+".jpg");
//			iRR.scalePercent(25);
//			PdfContentByte conRR = stamp.getUnderContent(1);
//			iRR.setAbsolutePosition(360f, 418f);
//			conRR.addImage(iRR);
//			
//			Image iRL= Image.getInstance(ImagePath+"/RL"+pDTO.getRegno()+".jpg");
//			iRL.scalePercent(25);
//			PdfContentByte conRL = stamp.getUnderContent(1);
//			iRL.setAbsolutePosition(475f, 418f);
//			conRL.addImage(iRL);
//			
//			
//			
//			
//			
//			Image iLT= Image.getInstance(ImagePath+"/LT"+pDTO.getRegno()+".jpg");
//			iLT.scalePercent(25);
//			PdfContentByte conLT = stamp.getUnderContent(1);
//			iLT.setAbsolutePosition(47f, 308f);
//			conLT.addImage(iLT);
//			
//			Image iLI= Image.getInstance(ImagePath+"/LI"+pDTO.getRegno()+".jpg");
//			iLI.scalePercent(25);
//			PdfContentByte conLI = stamp.getUnderContent(1);
//			iLI.setAbsolutePosition(150f, 308f);
//			conLI.addImage(iLI);
//			
//			
//			Image iLM= Image.getInstance(ImagePath+"/LM"+pDTO.getRegno()+".jpg");
//			iLM.scalePercent(25);
//			PdfContentByte conLM = stamp.getUnderContent(1);
//			iLM.setAbsolutePosition(252f, 308f);
//			conLM.addImage(iLM);
//			
//			
//			Image iLR= Image.getInstance(ImagePath+"/LR"+pDTO.getRegno()+".jpg");
//			iLR.scalePercent(25);
//			PdfContentByte conLR = stamp.getUnderContent(1);
//			iLR.setAbsolutePosition(360f, 308f);
//			conLR.addImage(iLR);
//			
//			Image iLL= Image.getInstance(ImagePath+"/LL"+pDTO.getRegno()+".jpg");
//			iLL.scalePercent(25);
//			PdfContentByte conLL = stamp.getUnderContent(1);
//			iLL.setAbsolutePosition(475f, 308f);
//			conLL.addImage(iLL);
//			
//			
//			
//			
//			iLT.scalePercent(18);
//			PdfContentByte conLTe = stamp.getUnderContent(1);
//			iLT.setAbsolutePosition(222f, 40f);
//			conLTe.addImage(iLT);
//			
//			iLI.scalePercent(15);
//			PdfContentByte conLIe = stamp.getUnderContent(1);
//			iLI.setAbsolutePosition(160f, 70f);
//			conLIe.addImage(iLI);
//			
//			iLM.scalePercent(15);
//			PdfContentByte conLMe = stamp.getUnderContent(1);
//			iLM.setAbsolutePosition(110f, 90f);
//			conLMe.addImage(iLM);
//			
//			iLR.scalePercent(15);
//			PdfContentByte conLRe = stamp.getUnderContent(1);
//			iLR.setAbsolutePosition(60f, 80f);
//			conLRe.addImage(iLR);
//			
//			
//			iLL.scalePercent(15);
//			PdfContentByte conLLe = stamp.getUnderContent(1);
//			iLL.setAbsolutePosition(10f, 40f);
//			conLLe.addImage(iLL);
//			
//			
//			iRT.scalePercent(18);
//			PdfContentByte conRTe = stamp.getUnderContent(1);
//			iRT.setAbsolutePosition(300f, 40f);
//			conRTe.addImage(iRT);
//			
//			
//			iRI.scalePercent(15);
//			PdfContentByte conRIe = stamp.getUnderContent(1);
//			iRI.setAbsolutePosition(380f, 70f);
//			conRIe.addImage(iRI);
//			
//			iRM.scalePercent(15);
//			PdfContentByte conRMe = stamp.getUnderContent(1);
//			iRM.setAbsolutePosition(430f, 90f);
//			conRMe.addImage(iRM);
//			
//			
//			iRR.scalePercent(15);
//			PdfContentByte conRRe = stamp.getUnderContent(1);
//			iRR.setAbsolutePosition(480f, 80f);
//			conRRe.addImage(iRR);
//			
//			
//			iRL.scalePercent(15);
//			PdfContentByte conRLe = stamp.getUnderContent(1);
//			iRL.setAbsolutePosition(530f, 40f);
//			conRLe.addImage(iRL);
			
			
			
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
			over.setTextMatrix(460, 552);
			over.showText(pDTO.getTtcname());
			
			
			over.endText();		
			
			stamp.close();
			readers.add(new PdfReader(certificate.toByteArray()));
			//}
				
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
