package co.za.ngwane.epms.reports.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import co.za.ngwane.epms.reports.vo.Programs;

public class ReportRenderer {

	public byte[] renderReport (String path) {

		byte[] bytes = null;

		try {

			ProgramsDataProvider dataBeanMaker = new ProgramsDataProvider();
			ArrayList<Programs> dataBeanList = dataBeanMaker.findAllPrograms("");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
			Map parameters = new HashMap();

//			String sourcefile = JasperCompileManager.compileReportToFile(path);

//			String printFileName =  JasperFillManager.fillReportToFile(path, parameters, beanColDataSource);


			

			//		bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), new HashMap(), new JREmptyDataSource());

			bytes = JasperRunManager.runReportToPdf(path, new HashMap(), beanColDataSource);	
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bytes;
	}
}
