package co.za.ngwane.epms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.za.ngwane.epms.dao.ProgramDAO;
import co.za.ngwane.epms.dao.ProjectDAO;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public boolean add(Projtbl projtbl) throws Exception {
		boolean result = false;
		
		try {
			if(projtbl != null){
				result = new ProjectDAO().add(projtbl);		//Update Program Budget Spend	
				if(result){
					if(projtbl.getProgtblid().getOwner() == null){
						projtbl.getProgtblid().setOwner(projtbl.getOwner());
						
					}
					projtbl.getProgtblid().setAvbalance(projtbl.getProgtblid().getAvbalance() - projtbl.getTotbud());
					projtbl.getProgtblid().setBudspend(projtbl.getProgtblid().getBudspend() + projtbl.getTotbud());
					result = new ProgramServiceImpl().update(projtbl.getProgtblid());
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Projtbl retrieveByName(String projectName) throws Exception {
		Projtbl project =  null;
		if(projectName != null && !projectName.trim().isEmpty()){
			project = new ProjectDAO().retrieveByName(projectName);				
		}		
		return project;
	}

	@Override
	public List<Projtbl> getAll() throws Exception {
		
		List<Projtbl> projList = null;
		try {
			projList = new ProjectDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projList;
	}
	
	@Override
	public List<Projtbl> getByProgName(String progName) throws Exception {
		
		List<Projtbl> projList = new ArrayList<Projtbl>();
		try {
			//Load the Program
			Progtbl progtbl = new ProgramServiceImpl().retrieveByName(progName);
			
			if(!progtbl.getName().trim().isEmpty()){
				projList = new ProjectDAO().getByProgName(progtbl);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projList;
	}
	
	@Override
	public boolean updateBudget(Projtbl projtbl) throws Exception
	{
		boolean result = false;

		try {
			if (projtbl != null) {
				result = new ProjectDAO().updateBudget(projtbl);
			}
			//Update Budget Spend on Project and Program
//			projtbl.getProgtblid().setOwner(projtbl.getOwner().getId());
//			projtbl.getProgtblid().setBudspend(projtbl.getProgtblid().getBudspend() + projtbl.getBudspend());
//			new ProgramServiceImpl().update(projtbl.getProgtblid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateBudget(Projtbl projtbl, Outputtbl outputtbl) throws Exception
	{
		boolean result = false;

	try {
		if (projtbl != null) {
			result = new ProjectDAO().updateBudget(projtbl);
		}
		//Update Budget Spend on Project and Program
		projtbl.getProgtblid().setOwner(projtbl.getOwner());
		projtbl.getProgtblid().setBudspend(projtbl.getProgtblid().getBudspend() + outputtbl.getBudspend());
		new ProgramServiceImpl().update(projtbl.getProgtblid());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

	@Override
	public boolean updateBudget(Projtbl projtbl, Qoupd qoupd) throws Exception
	{
		boolean result = false;

	try {
		if (projtbl != null) {
			result = new ProjectDAO().updateBudget(projtbl);
		}
		//Update Budget Spend on Project and Program
//		projtbl.getProgtblid().setOwner(projtbl.getOwner());
//		projtbl.getProgtblid().setBudspend(projtbl.getProgtblid().getBudspend() + qoupd.getBudspend());
		//new ProgramServiceImpl().update(projtbl.getProgtblid());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	}

}
