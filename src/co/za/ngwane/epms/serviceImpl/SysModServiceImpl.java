package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.dao.SysModDAO;
import co.za.ngwane.epms.dao.UserModDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Sysmod;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.SysModService;
import co.za.ngwane.epms.service.UserModService;

public class SysModServiceImpl implements SysModService {
	
	@Override
	public List<Sysmod> getAll() throws Exception { 
		List<Sysmod> sysModList = null;
		try {
			sysModList = new SysModDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysModList;
	}

	@Override
	public boolean add(Sysmod sysmod) throws Exception {  
		boolean result = false;
		
		try {
			if(sysmod != null){
				result = new SysModDAO().add(sysmod);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
