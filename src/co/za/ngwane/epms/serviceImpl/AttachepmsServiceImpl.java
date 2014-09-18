package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.AttachepmsDAO;
import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.repository.Attachepms;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.service.AttachepmsService;
import co.za.ngwane.epms.service.ClusterService;

public class AttachepmsServiceImpl implements AttachepmsService {

	@Override
	public List<Attachepms> getAll() throws Exception {
		List<Attachepms> attachList = null;
		try {
			attachList = new AttachepmsDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return attachList;
	}

	@Override
	public boolean add(Attachepms attachepms) throws Exception {
		boolean result = false;
		
		try {
			if(attachepms != null){
				result = new AttachepmsDAO().add(attachepms);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean update(Attachepms attachepms) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Attachepms> getByQoup(Qoupd qoupd) throws Exception {
		List<Attachepms> attachList = null;
		try {
			attachList = new AttachepmsDAO().getByQoupd(qoupd);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return attachList;
	}

	
}
