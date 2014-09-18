package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Ndpltems;
import co.za.ngwane.epms.repository.Projndplinkitems;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.serviceImpl.ProjNdpLinkItemsServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProjectServiceImpl;

public class ProjNdpLinkItemsOperations {
	
	
	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.operation.ProjectOperations");
	
	public boolean addProjectNdpItems(Projtbl projtbl, List<Ndpltems> ndpltemsList){ 

		boolean results = false;
		logger.info("Adding Project Ndp Link Items....");
		
		Projndplinkitems projndplinkitems = new Projndplinkitems();
		if(projtbl != null && (ndpltemsList != null)){	
			for (Ndpltems item : ndpltemsList) {
				logger.info("Trying to add Project Ndp link Object for Project name : " + projtbl.getName());
				try {
					projndplinkitems.setProjtblid(projtbl);
					projndplinkitems.setNdpltemsid(item);
					
					results = new ProjNdpLinkItemsServiceImpl().add(projndplinkitems);
					
					logger.info("Project Ndp link Item Object added for Project name : " + projtbl.getName());
				} catch (Exception e) {
					logger.info("Failed to add Project Ndp Link for Project name : " + projtbl.getName()); 
					results = false;
					e.printStackTrace();
				}
			}
		}

		return results;
	} 


	public List<Projndplinkitems> retrieveByProject(String projName) throws Exception {
		logger.info("Retrieving Project by name....");
		List<Projndplinkitems> projndplinkitems = null;
		Projtbl projtbl = new ProjectServiceImpl().retrieveByName(projName);
		
		if(projtbl != null){
			logger.info("Retrieving Items by Project....");

			projndplinkitems = new ProjNdpLinkItemsServiceImpl().retrieveByProject(projtbl);				
		}		
		return projndplinkitems;
	}

}
