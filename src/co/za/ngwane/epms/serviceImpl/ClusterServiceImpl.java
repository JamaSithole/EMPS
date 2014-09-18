package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.PlanDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.service.ClusterService;

public class ClusterServiceImpl implements ClusterService {

	@Override
	public List<Clustertbl> getAll() throws Exception {
		List<Clustertbl> clusterList = null;
		try {
			clusterList = new ClusterDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clusterList;
	}

	@Override
	public boolean add(Clustertbl clustertbl) throws Exception {
		boolean result = false;
		
		try {
			if(clustertbl != null){
				result = new ClusterDAO().add(clustertbl);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
