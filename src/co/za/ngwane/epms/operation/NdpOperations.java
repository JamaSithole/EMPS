package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.dao.NdpDAO;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.serviceImpl.NdpServiceImpl;

public class NdpOperations {
	
	
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.NdpOperations");
	
	public List<Ndp> getAll() throws Exception { 
		List<Ndp> ndpList = null;
		try {
			ndpList = new NdpServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Ndp> getAll() : "+e.getMessage());
		}
		return ndpList;
	}
	
	public Ndp add(Ndp ndp) throws Exception {
		boolean result = false;

		try {
			if (ndp != null) {
				result = new NdpServiceImpl().add(ndp);
				if(result)
				{
					logger.info("Ndp added susscessful. "+ndp.getName());
				}
				else
				{
					logger.info("Failed to add Ndp. "+ndp.getName());
				}
			}

		} catch (Exception e) {
			logger.info("Exception caught in boolean add(Ndp ndp) : "+e.getMessage());
		}
		return ndp;
	}

}
