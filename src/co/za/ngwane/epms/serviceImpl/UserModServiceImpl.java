package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.dao.UserModDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.UserModService;

public class UserModServiceImpl implements UserModService {
	
	@Override
	public List<Usermod> getByUser(Userepms userepms) throws Exception { 
		List<Usermod> userModList = null;
		try {
			userModList = new UserModDAO().getByUser(userepms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userModList;
	}

	@Override
	public boolean add(Usermod usermod) throws Exception { 
		boolean result = false;
		
		try {
			if(usermod != null){
				result = new UserModDAO().add(usermod);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
