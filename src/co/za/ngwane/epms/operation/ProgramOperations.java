package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Sectiontbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.DeptServiceImpl;
import co.za.ngwane.epms.serviceImpl.NdpServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProgramServiceImpl;
import co.za.ngwane.epms.serviceImpl.SectionServiceImpl;
import co.za.ngwane.epms.serviceImpl.UserepmsServiceImpl;

public class ProgramOperations {
	
	
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.ProgramOperations");
	
	public Progtbl createProgram(Progtbl progtbl, String sectionName, String owner){
		
		boolean results = false;
		logger.info("Entering Program Operations : User Name [" );//TO Be Completed 
		
		Sectiontbl section = null;
		Ndp ndp = null;
		if(sectionName != null){		
			logger.info("Trying to retrieve Section Object for Program name : " + progtbl.getName());
			try {
				section = new SectionServiceImpl().retrieveByName(sectionName);
			} catch (Exception e) {
				logger.info("Failed to retrieve Section Object for Program name : " + progtbl.getName());
				e.printStackTrace();
			}
			if (owner != null) {
				Userepms user = new Userepms();
				logger.info("Trying to retrieve User Object for User name : "
						+ owner);
				try {
					user = new UserepmsServiceImpl().getByName(owner);
					if(user != null){
						progtbl.setOwner(user);
					}
				} catch (Exception e) {
					logger.info("Failed to retrieve User Object for User name : "
							+ owner);
					e.printStackTrace();
				}
			}
			progtbl.setAvbalance(progtbl.getTotalbudget());
			//progtbl.setTotalbudget(1000000f);
			
			if(section != null ){
				logger.info("Succesfuly retrieved Section Object for Program name : " + progtbl.getName());
				logger.info("Trying to Add Project Section for Program name : " + progtbl.getName());
				
				//progtbl.setNdpid(ndp);
				progtbl.setSectionid(section);
				progtbl.setBudspend(0f);
				
				try {
					results = new ProgramServiceImpl().add(progtbl);
					if(results){
						logger.info("Program added successful, Prog ID : " + progtbl.getId());
					}
				} catch (Exception e) {
					logger.info("Failed To Add Program Object for Section name : " + sectionName);
					e.printStackTrace();
				}
			}
			
		}
		
		return progtbl;
	}
	
	public List<Progtbl> getAll(){
		
		List<Progtbl> progList = null; 
		try {
			progList = new ProgramServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "+e.getMessage());
		}
		return progList;
		
	}

	public Progtbl getByName(String programName) {

		Progtbl prog = null; 
		try {
			prog = new ProgramServiceImpl().retrieveByName(programName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in Progtbl getByName(String programName) : "
					+ e.getMessage());
		}
		return prog;

	}


}
