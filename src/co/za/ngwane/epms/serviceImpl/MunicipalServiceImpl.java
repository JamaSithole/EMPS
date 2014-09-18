package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.MunicipalDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Municipal;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.MunicipalService;

public class MunicipalServiceImpl implements MunicipalService {

	@Override
	public List<Municipal> getAll() throws Exception {
		List<Municipal> municipalList = null;
		try {
			municipalList = new MunicipalDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return municipalList;
	}

	@Override
	public boolean add(Municipal municipal) throws Exception { 
		boolean result = false;
		
		try {
			if(municipal != null){
				result = new MunicipalDAO().add(municipal);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Municipal getById(Integer id) throws Exception {
		Municipal municipal = null;
		try {
			municipal = new MunicipalDAO().getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return municipal;
	}
}
