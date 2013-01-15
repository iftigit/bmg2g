package org.controller.registration;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.model.AddressDAO;
import org.model.LotteryDAO;
import org.table.UserDTO;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

public class DcLotteryResult extends ActionSupport implements ServletContextAware{
	
	private static final long serialVersionUID = 9203852155056386824L;
	private InputStream inputStream;
	AddressDAO addressDAO=new AddressDAO();

	
	
	public String execute() throws Exception
	{	
		UserDTO loggedInUser=(UserDTO) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		String districtName=addressDAO.getDistrictNameFromId(Integer.parseInt(loggedInUser.getDistrictId()));
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();		
		Document document = new Document(PageSize.A4.rotate());
		
		
		String fileName="Lottery_G2G_"+districtName+".pdf";
		
		document.setMargins(40, 40, 20, 20);
		
		
		document.addHeader("G2G Lottery", "");
		
		String realpath = servlet.getRealPath("");
		


		PdfPTable ptable = null;
		PdfPCell pcell=null;
		
		try{
			
			DCLotteryReportEvent eEvent = new DCLotteryReportEvent(servlet);
			PdfWriter.getInstance(document, baos).setPageEvent(eEvent);
			document.open();
			
			Font font1 = new Font(Font.COURIER, 8, Font.BOLD); 
			font1.setColor(new Color(0x92, 0x90, 0x83));
			Font fontT = FontFactory.getFont("Helvetica", 9, Font.NORMAL,Color.BLACK);
			Font fontL = FontFactory.getFont("Helvetica", 9, Font.BOLD,Color.BLACK);
			Font fontTL = FontFactory.getFont("Helvetica", 7, Font.NORMAL,Color.BLACK);
			Font fontTLL = FontFactory.getFont("Times New Roman", 6, Font.NORMAL,Color.BLACK);
			
			Font fontb = FontFactory.getFont("Helvetica", 10, Font.BOLD,Color.BLACK);
			Font font2 = FontFactory.getFont("Courier", 9, Font.NORMAL,Color.BLACK);
			Font font3 = FontFactory.getFont("Helvetica", 15, Font.BOLD,Color.BLACK);
			Font font4 = FontFactory.getFont("Helvetica", 14, Font.NORMAL,Color.BLACK);
			Font font5 = FontFactory.getFont("Times New Roman", 11, Font.BOLD,Color.BLACK);
			Font font6 = FontFactory.getFont("Helvetica", 14, Font.BOLD,Color.BLACK);
			Font font7 = FontFactory.getFont("Helvetica", 11, Font.NORMAL,Color.BLACK);
			Font font8 = FontFactory.getFont("Helvetica", 17, Font.BOLD,Color.BLACK);	
			
			
			
			LotteryDAO lotteryDAO = new LotteryDAO();
			
			List<JobseekerDTO> selectedList = null;
			PdfPTable headerTable=null;
			/* Test Data */
				selectedList=new ArrayList<JobseekerDTO>();
				for(int i=0;i<10;i++)
				{
					JobseekerDTO jobseeker=new JobseekerDTO();
					jobseeker.setRegId("BBM12090353G2G");
					jobseeker.setName("Ifta Khirul");
					jobseeker.setFatherName("Md. Nurnabi Sarkar");
					jobseeker.setMotherName("Fatema Khatun");
					jobseeker.setpMobileNumber("01190547558");
					
					selectedList.add(jobseeker);
				}
			/*===========*/

			
			
			String preUnionId="";
			
			for(int i=0;i<selectedList.size();i++)
			{
				if(!preUnionId.equalsIgnoreCase(selectedList.get(i).getpUnionId()))				
				{
					ptable = new PdfPTable(8);
					ptable.setWidthPercentage(100);
					ptable.setWidths(new float[]{5,14,18,18,18,10,8,7});

					pcell=new PdfPCell(new Paragraph("Sl. No.",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("Registration Id",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					pcell=new PdfPCell(new Paragraph("Name of the Employee",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					
					pcell=new PdfPCell(new Paragraph("Father Name",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
								
					pcell=new PdfPCell(new Paragraph("Mother Name",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					pcell=new PdfPCell(new Paragraph("Birth Date",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					pcell=new PdfPCell(new Paragraph("Mobile Number",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					pcell=new PdfPCell(new Paragraph("Comments",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					ptable.setHeaderRows(1);
					
					if(i!=0)
					{
						document.add(ptable);
						document.newPage();
					}

				}
//				ptable = new PdfPTable(8);
//				ptable.setWidthPercentage(100);
//				ptable.setWidths(new float[]{5,14,18,18,18,10,8,7});
//
				
				JobseekerDTO seekerDTO =selectedList.get(i);
				
								
				pcell = new PdfPCell(new Paragraph(String.valueOf(i+1),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getRegId(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getName(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getFatherName(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getMotherName(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getName(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getpMobileNumber(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell = new PdfPCell(new Paragraph(seekerDTO.getName(),fontT));
				pcell.setMinimumHeight(20f);
				pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				
				
				
				//eEvent.setDisplayValue(String.valueOf(i));				
				
			}
			
			document.add(ptable);
		document.close();
		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		out.write(baos.toByteArray());
		out.flush();

	
	}catch(Exception e){e.printStackTrace();}

    return null;
	}
	
	
	private ServletContext servlet;
	
	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	

}

class DCLotteryReportEvent extends PdfPageEventHelper
{
	protected ServletContext servlet =null;
	protected PdfTemplate total;
	protected BaseFont helv;
	protected PdfPTable footer;
	
	private String header="";
	 private String DisplayValue=null;
	 
	public void addheader(String header)
	{
		this.header = header;
	}
//	String cBean;
//	String projectname;
//	String monyear;
	
	
	
	public DCLotteryReportEvent(ServletContext servlet) {
		
		this.servlet = servlet;
//		this.cBean = cBean;
//		String [] st=cBean.split("#");
//		this.projectname=st[1];
//		this.monyear=st[0];
		
	}

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub

		
		
		total = writer.getDirectContent().createTemplate(100, 100);
		total.setBoundingBox(new Rectangle(-20,-20,100,100));
		
		try{
			helv=BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI,BaseFont.NOT_EMBEDDED);
		}catch(Exception e){
			throw new ExceptionConverter(e);
		}
		
	}
	
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
		PdfContentByte cb = writer.getDirectContent();
		
		footer = new PdfPTable(5);
		footer.setTotalWidth(700);
		footer.setWidthPercentage(80);

		try
		{
			footer.setWidths(new float[] {20,14,30,14,20});
			footer.setHorizontalAlignment(Element.ALIGN_CENTER);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		PdfPCell pcell=null;
		
		Font f10nornal = new Font(Font.TIMES_ROMAN,10,Font.NORMAL);
		
		pcell=new PdfPCell(new Paragraph("Prepared by",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph("\n Page"+document.getPageNumber(),f10nornal));
		pcell.setColspan(3);
		pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph("Verified by",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		
		footer.writeSelectedRows(0, -1, (document.right()-document.left()-600)/2-document.leftMargin(),document.bottom()+5,cb);
		
		
	}
	
	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		
		PdfContentByte cb = writer.getDirectContent();
		
		cb.saveState();
		String text = header;
		float textBase = document.top()+5;
		float textSize = helv.getWidthPoint(text, 12);
		cb.beginText();
		cb.setFontAndSize(helv, 10);
		if ((writer.getPageNumber() > 1))
		{
			cb.setTextMatrix((document.getPageSize().width()/2)-(textSize/2), textBase);
			cb.showText(text);
			cb.endText();
			cb.addTemplate(total,(document.getPageSize().width()/2)-(textSize/2), textBase);
		}
		else
		{
		cb.setTextMatrix(document.left()+50, textBase);
		cb.showText("");
		cb.endText();
		cb.addTemplate(total, document.right() + textSize, textBase);
			
		}
	
		cb.restoreState();
		
		String realpath = servlet.getRealPath("");
		String filepath = "/resources/images/bagladesh_logo.gif";
		String bmetLogo=realpath+filepath;

		bmetLogo=realpath+filepath;
		

		try{
			
			URL  url = new URL("file", "localhost",bmetLogo);
			
			Image jpg = Image.getInstance(url);
			jpg.scalePercent(100f);

			
			Paragraph pg =null;
			
			
			PdfPTable ptable = new PdfPTable(2);
			ptable.setWidthPercentage(60);
			ptable.setWidths(new float[] {15f,80f });
			ptable.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell pcell = new PdfPCell();
			
			
			pcell.addElement(jpg);
			//pcell.setPaddingBottom(-3f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);		
			pcell.setBorderColor(Color.WHITE);
			pcell.setFixedHeight(50f);
			ptable.addCell(pcell);
			
			
			
			String header1="G2G Project Lottery Result "+getDisplayValue();
			pcell = new PdfPCell();
			pg = new Paragraph(header1,new Font(Font.TIMES_ROMAN,13,Font.BOLD));
			pg.setAlignment(Element.ALIGN_LEFT);
			pcell.setColspan(4);
			pcell.addElement(pg);
			pcell.setPaddingBottom(5f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);		
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);		
			ptable.addCell(pcell);
			
			ptable.setSpacingBefore(40f);
			ptable.setSpacingAfter(10f);
			
			
			/*
			pcell = new PdfPCell();
			String header2="Central Store, Dhaka.";
			
			pg = new Paragraph(header2,new Font(Font.TIMES_ROMAN,9,Font.NORMAL));
			pg.setAlignment(Element.ALIGN_CENTER);
			pcell.setColspan(5);
			pcell.addElement(pg);
			pcell.setPaddingBottom(-3f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			ptable.addCell(pcell);
			
			pcell = new PdfPCell();
			String header3="Store Statement for the month of";;
			
			pg = new Paragraph(header3,new Font(Font.TIMES_ROMAN,9,Font.NORMAL));
			pg.setAlignment(Element.ALIGN_CENTER);
			pg.font().setStyle(Font.UNDERLINE);			
			pcell.setColspan(5);
			pcell.addElement(pg);
			pcell.setPaddingBottom(-3f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			ptable.addCell(pcell);
			
			
			pcell = new PdfPCell();
			String header4="Project Name";
			
			pg = new Paragraph(header4,new Font(Font.TIMES_ROMAN,10,Font.BOLD));
			pg.setAlignment(Element.ALIGN_CENTER);
			//pg.font().setStyle(Font.UNDERLINE);			
			pcell.setColspan(5);
			pcell.addElement(pg);
			pcell.setPaddingBottom(8f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			ptable.addCell(pcell);
			*/
			
			document.add(ptable);
			
			
		}catch(Exception ex){
			
		}
		
		
	}

	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}



	public String getDisplayValue() {
		return DisplayValue;
	}



	public void setDisplayValue(String displayValue) {
		DisplayValue = displayValue;
	}

	
}

