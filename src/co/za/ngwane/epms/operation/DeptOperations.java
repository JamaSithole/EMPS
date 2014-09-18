package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.serviceImpl.DeptServiceImpl;
import co.za.ngwane.epms.serviceImpl.DirectorateServiceImpl;

public class DeptOperations {
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.DeptOperations");
	
	public List<Dept> getAll() throws Exception { 
		List<Dept> deptList = null; 
		try {
			deptList = new DeptServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "+e.getMessage());
		}
		return deptList;
	}
	
	public boolean add(Dept dept){
		
		boolean results = false;
		logger.info("Entering Department Operations : User Name [" );//TO Be Completed 
		
		try {
			if(dept != null){
				 
				logger.info("");
				results = new DeptServiceImpl().add(dept);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return results;
	}
	
	public List<Dept> getDeptByCluster(Clustertbl clustertbl){ 
		
		List<Dept> results = null;
		logger.info("in getDeptByCluster, retrieving by clusterName" ); 
		try {
			if(clustertbl != null){
				if (clustertbl.getName().equalsIgnoreCase("All Clusters")) {
					results = new DeptServiceImpl().getAll();
				} else {
					results = new DeptServiceImpl().getDeptByCluster(clustertbl);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return results;
	}


}
