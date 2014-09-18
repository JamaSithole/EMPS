package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.PlanServiceImpl;

public class PlanOperations {
	
	
	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.operation.PlanOperations");
	
	public Plantbl addPlan(Plantbl plantbl){
		boolean results = false;
		logger.info("Entering addPlan method in PlanOperations" );
		
		if(plantbl != null){
			
			try {
				plantbl.setBudspend(0f);
				results = new PlanServiceImpl().addPlan(plantbl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("Exception caught : "+e.getMessage());
				e.printStackTrace();
			}
		}
		return plantbl;
	}
	
	public List<Plantbl> getAllPlans(){
		
		List<Plantbl> list = null; 
		try {
			list = new PlanServiceImpl().getAllPlans();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "+e.getMessage());
		}
		
		return list;
		
	}

	/*
	public Plantbl retrievePlanByUser(Userepms userepms) {

		Plantbl plan = null; 
		try {
			plan = new PlanServiceImpl().retrievePlanByUser(userepms);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in Progtbl getByName(String programName) : "
					+ e.getMessage());
		}
		return plan;

	}
	*/
	
	public boolean updatePlan(Plantbl plantbl){
		boolean results = false;
		logger.info("Entering addPlan method in PlanOperations" );
		
		if(plantbl != null){
			
			try {
				results = new PlanServiceImpl().updatePlan(plantbl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}



}
