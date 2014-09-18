package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.serviceImpl.ClusterServiceImpl;
import co.za.ngwane.epms.serviceImpl.MunicipalServiceImpl;
import co.za.ngwane.epms.serviceImpl.PlanServiceImpl;

public class ClusterOperations {
	
	
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.ClusterOperations");
	
	public Clustertbl add(Clustertbl clustertbl){
		boolean results = false;
		logger.info("Entering add method in ClusterOperations" );
		
		if(clustertbl != null){
			
			try {
				clustertbl.setMunicipalid(new MunicipalServiceImpl().getById(1));
				results = new ClusterServiceImpl().add(clustertbl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("Exception caught : "+e.getMessage());
				e.printStackTrace();
			}
		}
		return clustertbl;
	}
	
	public List<Clustertbl> getAll() throws Exception {
		List<Clustertbl> clusterList = null;
		try {
			clusterList = new ClusterServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Clustertbl> getAll() : "+e.getMessage());
		}
		return clusterList;
	}

}
