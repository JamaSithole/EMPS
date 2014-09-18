package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.serviceImpl.DirectorateServiceImpl;

public class DirectorateOperations {
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.DirectorateOperations");
	
	public List<Directorate> getAll() throws Exception { 
		List<Directorate> dirList = null;
		try {
			dirList = new DirectorateServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Directorate> getAll() : "+e.getMessage());
		}
		return dirList;
	}
	
	public boolean add(Directorate directorate){
		
		boolean results = false;
		logger.info("Entering Directorate Operations : User Name [" );//TO Be Completed 
		try {
			if(directorate != null){
				results = new DirectorateServiceImpl().add(directorate);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}
	
	public List<Directorate> getDirByDept(Dept dept){ 
		
		List<Directorate> results = null;
		logger.info("in getDirByDept, retrieving by deptName" ); 
		try {
			if(dept != null){
				if (dept.getName().equalsIgnoreCase("All Departments")) {
					results = new DirectorateServiceImpl().getAll();
				} else {
					results = new DirectorateServiceImpl().getDirByDept(dept);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}
	
	


}
