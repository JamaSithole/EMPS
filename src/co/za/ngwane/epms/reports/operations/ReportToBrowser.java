package co.za.ngwane.epms.reports.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import co.za.ngwane.epms.reports.vo.Programs;

public class ReportToBrowser extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReportToBrowser ()
	{
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try

		{
			System.out.println(request.getParameter("templateName"));
			String templateName = request.getParameter("templateName"); 
			String program = request.getParameter("program"); 
			String project = request.getParameter("project"); 
			String source = request.getParameter("source"); 
			String rptName = request.getParameter("rptName"); 
			
			String jrxmlPath = "/reports/" + templateName + ".jrxml";

			ProgramsDataProvider dataBeanMaker = new ProgramsDataProvider();
			ArrayList<Programs> dataBeanList = new ArrayList<Programs>();
			
			if("program".equalsIgnoreCase(source)){
				dataBeanList = dataBeanMaker.findAllPrograms(program);
			} else if ("project".equalsIgnoreCase(source)) {
				dataBeanList = dataBeanMaker.findAllPrograms(program);
			}
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
			Map parameters = new HashMap();
			 
			String sourcefile = JasperCompileManager.compileReportToFile(getServletConfig().getServletContext().getRealPath(jrxmlPath));


			ServletOutputStream servletOutputStream = response.getOutputStream();

			byte[] bytes = null;
			
			bytes = JasperRunManager.runReportToPdf(sourcefile, new HashMap(), beanColDataSource);

			response.setContentType("application/pdf");
            
			response.setContentLength(bytes.length);
			
			response.setHeader("Content-disposition","inline; filename=" + "ProgramsBudgetRpt_"+new Date().getTime() + "." + response.getContentType().toLowerCase() );

			servletOutputStream. write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();

		}

		catch (Exception e)  
		
		{

			// display stack trace in the browser

			StringWriter stringWriter = new StringWriter();

			PrintWriter printWriter = new PrintWriter(stringWriter);

			e.printStackTrace(printWriter);

			response.setContentType("text/plain");

			response.getOutputStream().print(stringWriter.toString());

		}

	}
}
