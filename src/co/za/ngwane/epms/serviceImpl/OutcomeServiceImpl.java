package co.za.ngwane.epms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.za.ngwane.epms.dao.OutcomeDAO;
import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.service.OutcomeService;

public class OutcomeServiceImpl implements OutcomeService {

	@Override
	public boolean add(Outcometbl outcometbl) throws Exception {
		
		boolean result = false;
		
		try {
			if(outcometbl != null){
				result = new OutcomeDAO().add(outcometbl);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@Override
	public boolean update(Outcometbl outcometbl) throws Exception {
		
		boolean result = false;
		
		try {
			if(outcometbl != null){
				result = new OutcomeDAO().update(outcometbl);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Outcometbl retrieveByName(String outcome) throws Exception {
		
		Outcometbl outcometbl =  null;
		if(outcome != null && !outcome.trim().isEmpty()){
			outcometbl = new OutcomeDAO().retrieveByName(outcome);				
		}		
		return outcometbl;
	}
	
	@Override
	public List<Outcometbl> getAll() throws Exception {
		
		List<Outcometbl> progList = null;
		try {
			progList = new OutcomeDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progList;

	}
	
	public List<Outcometbl> findByProjectId(Projtbl  projtbl) throws Exception{
		
		List<Outcometbl> list = new ArrayList<Outcometbl>();
		
		try
		{
			list = new OutcomeDAO().getByProject(projtbl);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}

}
;
