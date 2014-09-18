package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.repository.Sectiontbl;
import co.za.ngwane.epms.serviceImpl.DeptServiceImpl;
import co.za.ngwane.epms.serviceImpl.SectionServiceImpl;

public class SectionOperations {
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.SectionOperations");
	
	public List<Sectiontbl> getAll() throws Exception { 
		List<Sectiontbl> sectionList = null;  
		try {
			sectionList = new SectionServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "+e.getMessage());
		}
		return sectionList;
	}
	
	public boolean add(Sectiontbl section){ 
		
		boolean results = false;
		logger.info("Entering Department Operations : User Name [" );//TO Be Completed 
		
		try {
			if(section != null){
				 
				logger.info("");
				results = new SectionServiceImpl().add(section);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return results;
	}
	
	public List<Sectiontbl> getSectionByDir(Directorate directorate){ 
		
		List<Sectiontbl> results = null;
		logger.info("in getSectionByDir, retrieving by dirName" ); 
		try {
			if(directorate != null){
				if (directorate.getName().equalsIgnoreCase("All Directorates")) {
					results = new SectionServiceImpl().getAll();
				}else {
					results = new SectionServiceImpl().getSectionByDir(directorate);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}


}
