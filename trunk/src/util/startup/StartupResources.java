package util.startup;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.AddressDAO;

public class StartupResources  extends HttpServlet {
	
	private static final long serialVersionUID = -7227671581272961718L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  
	  }
	


	public void init(ServletConfig config)  throws ServletException
	{	
		super.init(config);
		config.getServletContext().setAttribute("ALL_DIVISION", AddressDAO.getAllDivision());
		config.getServletContext().setAttribute("ALL_DISTRICT", AddressDAO.getAllDistrict());
		config.getServletContext().setAttribute("ALL_THANA", AddressDAO.getAllThana());
		config.getServletContext().setAttribute("ALL_UNION", AddressDAO.getAllUnion());
		
		
	}

}
