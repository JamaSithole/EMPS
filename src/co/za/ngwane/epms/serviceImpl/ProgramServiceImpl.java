package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ProgramDAO;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.service.ProgramService;

public class ProgramServiceImpl implements ProgramService {

	@Override
	public boolean add(Progtbl progtbl) throws Exception {
		boolean result = false;
		
		try {
			if(progtbl != null){
				result = new ProgramDAO().add(progtbl);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Progtbl retrieveByName(String programName) throws Exception {
		
		Progtbl progtbl =  null;
		if(programName != null && !programName.trim().isEmpty()){
			progtbl = new ProgramDAO().retrieveByName(programName);				
		}
		
		return progtbl;
	}
	
	@Override
	public List<Progtbl> getAll() throws Exception {
		
		List<Progtbl> progList = null;
		try {
			progList = new ProgramDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progList;
	}
	
	@Override
	public boolean update(Progtbl progtbl) throws Exception {
		
		boolean result = false;
		try
		{
			result = new ProgramDAO().update(progtbl);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
