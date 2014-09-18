package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Userepms;

public interface PlanService {
	public boolean addPlan(Plantbl plantbl) throws Exception;
	//public Plantbl retrievePlanByUser(Userepms userepms) throws Exception;
	public List<Plantbl> getAllPlans() throws Exception;
	public boolean updatePlan(Plantbl plantbl) throws Exception;

}
