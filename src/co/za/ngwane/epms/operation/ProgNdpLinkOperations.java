package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Progndplink;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.serviceImpl.ProgNdpLinkServiceImpl;

public class ProgNdpLinkOperations {
	
	
	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.operation.ProgNdpLinkOperations");
	
	public boolean addProgramNdpLinks(String programName, List<Ndp> ndp){

		boolean results = true;
		logger.info("Adding Program Ndp Link....");

		if(programName != null && !programName.isEmpty()){
			logger.info("Trying to get Program Ndp link Object for Program name : " + programName);
			Progtbl progtbl = new ProgramOperations().getByName(programName);
			
			for (Ndp link : ndp) {
				logger.info("Trying to add Program Ndp link Object for Program : " + progtbl.getName());
				try {
					Progndplink progndplink = new Progndplink();
					progndplink.setNdpid(link);
					progndplink.setProgid(progtbl);
					new ProgNdpLinkServiceImpl().add(progndplink);
					logger.info("Program Ndp link Object added for NDP name : " + programName);
				} catch (Exception e) {
					logger.info("Failed to add Program Ndp Link for Program name : " + programName); 
					results = false;
					e.printStackTrace();
				}
			}
		}

		return results;
	} 

	public List<Progndplink> retrieveByProgram(String programName) throws Exception {
		List<Progndplink> projndplinks = null;

		Progtbl progtbl = new ProgramOperations().getByName(programName);
		if(programName != null){
			projndplinks = new ProgNdpLinkServiceImpl().retrieveByProgram(progtbl);				
		}
		
		return projndplinks;
	}
	
	public List<Progndplink> getNdpByProg(Progtbl program) throws Exception {
		List<Progndplink> projndplinks = null;

		if(program != null){
			projndplinks = new ProgNdpLinkServiceImpl().retrieveByProgram(program);		
			logger.info("projndplinks.size() for program "+program.getName()+" is : "+projndplinks.size());
		}
		
		return projndplinks;
	}

}
