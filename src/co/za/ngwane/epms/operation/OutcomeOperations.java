package co.za.ngwane.epms.operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.OutcomeServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProgramServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProjectServiceImpl;
import co.za.ngwane.epms.serviceImpl.UserepmsServiceImpl;

public class OutcomeOperations {

	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.OutcomeOperations");

	public Outcometbl addOutcome(Outcometbl outcometbl, String projectName, String owner) {

		boolean results = false;
		logger.info("Entering Outcome Operations : User Name [");// TO Be
																	// Completed

		if (outcometbl != null && projectName != null) {
			Projtbl projtbl = new Projtbl();
			logger.info("Trying to retrieve Project Object for Project name : "
					+ projectName);
			try {
				projtbl = new ProjectServiceImpl().retrieveByName(projectName);
			} catch (Exception e) {
				logger.info("Failed to retrieve Project Object for Program name : "
						+ projectName);
				e.printStackTrace();
			}
			if (projtbl != null) {
				logger.info("Succesfuly retrieved Project Object for project name : "
						+ projectName);
				logger.info("Trying to Add Outcome Object for Project name : "
						+ projectName);
				
				float projAvailableBalance = projtbl.getTotbud() - projtbl.getBudspend();
				if(outcometbl.getAbudget()  > projAvailableBalance){
					BigDecimal value1  = new BigDecimal(outcometbl.getAbudget());
					outcometbl.setErrorMessage("Failed to Add Outcome, Budget [ " + value1.abs() + " ] Allocated greater than Available budget on Project [" + projAvailableBalance +" ]");
					logger.info("Failed to Add Outcome, Budget [ " + outcometbl.getAbudget() + " ] Allocated greater than Available budget on Project [" + projAvailableBalance +" ]");
					return outcometbl;					
				}
				
				outcometbl.setProjtblid(projtbl);
				
				if (owner != null && outcometbl != null) {
					Userepms user = new Userepms();
					logger.info("Trying to retrieve User Object for User name : "
							+ owner);
					try {
						user = new UserepmsServiceImpl().getByName(owner);
						if(user != null){
							outcometbl.setOwner(user);
						}
					} catch (Exception e) {
						logger.info("Failed to retrieve User Object for User name : "
								+ owner);
						e.printStackTrace();
					}
				}
				try {
					outcometbl.setVal(0f);
					outcometbl.setAbalance(outcometbl.getAbudget());
					results = new OutcomeServiceImpl().add(outcometbl);
					if (results) {
						
						if(outcometbl.getAbalance() == null){
							outcometbl.setAbalance(0f);
						}
						float projBudgetSpend = projtbl.getBudspend() + outcometbl.getAbalance();
						projtbl.setBudspend(projBudgetSpend);
						boolean result = new ProjectServiceImpl().updateBudget(projtbl);
						logger.info("Added Outcome Object for Project name : "
								+ projectName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return outcometbl;
	}

	public List<Outcometbl> getAll() {

		List<Outcometbl> outcomeList = null;
		try {
			outcomeList = new OutcomeServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "
					+ e.getMessage());
		}
		return outcomeList;

	}
	
	public List<Outcometbl> getOutcomeByProj(String projName) {

		List<Outcometbl> outcomeList = new ArrayList<Outcometbl>();
		
		try {
			logger.info("Entering method to retrieve outcomes by Project Name : [" + projName + "]");
			Projtbl projtbl = new ProjectServiceImpl().retrieveByName(projName);
			
			if(!projtbl.getName().trim().isEmpty()){
				logger.info("Project Name : [" + projName + "] DB Entry Found" );
				outcomeList = new OutcomeServiceImpl().findByProjectId(projtbl);
				if(!outcomeList.isEmpty()){
					logger.info("Found Outcomes related to Project Name : [" + projName + "]");						
				}else{
					logger.info("No Outcomes for  Project Name : [" + projName + "]");	
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Outcomes> getOutcomeByProj() : "
					+ e.getMessage());
		}
		return outcomeList;

	}

}
