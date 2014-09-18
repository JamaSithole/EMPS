package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.service.PlanService;

public class PlanServiceImpl implements PlanService {

	@Override
	public boolean addPlan(Plantbl plantbl) throws Exception {
		boolean result = false;
		
		try {
			if(plantbl != null){
				result = new PlanDAO().addPlan(plantbl);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	/*
	@Override
	public Plantbl retrievePlanByUser(Userepms userepms) throws Exception {
		
		Plantbl plantbl =  null;
		if(userepms != null){
			plantbl = new PlanDAO().retrievePlanByUser(userepms);				
		}
		
		return plantbl;
	}
	*/
	
	@Override
	public List<Plantbl> getAllPlans() throws Exception {
		
		List<Plantbl> plantblist = null;
		try {
			plantblist = new PlanDAO().getAllPlans();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantblist;
	}
	
	@Override
	public boolean updatePlan(Plantbl plantbl) throws Exception {
		boolean result = false;
		
		try {
			if(plantbl != null){
				result = new PlanDAO().updatePlan(plantbl);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
