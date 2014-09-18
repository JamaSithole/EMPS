package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.DirectorateDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.dao.ProgramDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.DirectorateService;

public class DirectorateServiceImpl implements DirectorateService {

	@Override
	public List<Directorate> getAll() throws Exception {
		List<Directorate> dirList = null;
		try {
			dirList = new DirectorateDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return dirList;
	}

	@Override
	public boolean add(Directorate directorate) throws Exception {
		boolean result = false;
		
		try {
			if(directorate != null){
				result = new DirectorateDAO().add(directorate);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public List<Directorate> getDirByDept(Dept dept) throws Exception {
		List<Directorate> directorates = null;
		if(dept != null){
			directorates = new DirectorateDAO().getDirByDept(dept);				
		}
		
		return directorates;
	}

	
}
