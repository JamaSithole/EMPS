package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.DeptDAO;
import co.za.ngwane.epms.dao.DirectorateDAO;
import co.za.ngwane.epms.dao.SectionDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.repository.Sectiontbl;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.DeptService;
import co.za.ngwane.epms.service.DirectorateService;
import co.za.ngwane.epms.service.SectionService;

public class SectionServiceImpl implements SectionService {

	@Override
	public List<Sectiontbl> getAll() throws Exception { 
		List<Sectiontbl> sectionList = null;
		try {
			sectionList = new SectionDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return sectionList;
	}
	
	@Override
	public Sectiontbl retrieveByName(String sectionName) throws Exception {
		Sectiontbl section =  null;
		if(sectionName != null && !sectionName.trim().isEmpty()){
			section = new SectionDAO().retrieveByName(sectionName);				
		}		
		return section;
	}

	@Override
	public boolean add(Sectiontbl sectiontbl) throws Exception {
		boolean results  = false;
		try {
			if(sectiontbl != null){
				results = new SectionDAO().add(sectiontbl);				
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}
	
	public List<Sectiontbl> getSectionByDir(Directorate directorate) throws Exception {
		List<Sectiontbl> sectiontbls = null;
		if(directorate != null){
			sectiontbls = new SectionDAO().getSectionByDir(directorate);				
		}
		
		return sectiontbls;
	}

}
