package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.DeptDAO;
import co.za.ngwane.epms.dao.NdpDAO;
import co.za.ngwane.epms.dao.UserepmsDAO;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.service.UserepmsService;

public class UserepmsServiceImpl implements UserepmsService {
	@Override
	public Userepms userLogin(String username, String password)
			throws Exception {
		Userepms user = null;
		try {
			if (username != null && password != null) {
				user = new UserepmsDAO().userLogin(username, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Userepms> getAll() throws Exception
	{
		List<Userepms> userlist = null;		
		userlist = new UserepmsDAO().getAll();
		return userlist;
	}

	@Override
	public Userepms getByName(String ndpName) throws Exception {  
		Userepms user = null; 
		try {
			user = new UserepmsDAO().getByName(ndpName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean add(Userepms user) throws Exception {
		boolean results = false;
		try {
			results = new UserepmsDAO().add(user);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return results;
	} 

}
