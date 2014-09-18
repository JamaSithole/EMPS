package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Ndpltems;
import co.za.ngwane.epms.serviceImpl.NdpItemServiceImpl;
import co.za.ngwane.epms.serviceImpl.NdpServiceImpl;

public class NdpItemsOperations {

	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.operation.NdpItemsOperations");

	public List<Ndpltems> getByNdpName( String ndpName ) throws Exception {
		List<Ndpltems> ndpItemList = null;
		try {
			//get ndp by name
			Ndp ndp = new NdpServiceImpl().getByName(ndpName);
			
			ndpItemList = new NdpItemServiceImpl().getByNdp(ndp);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Ndpltems> getByNdp() : "
					+ e.getMessage());
		}
		
		return ndpItemList;
	}
	
	public List<Ndpltems> getByNdp(Ndp ndp) throws Exception {
		logger.info("getByNdp object getting an object....");
		List<Ndpltems> ndpItemList = null;
		try {
			ndpItemList = new NdpItemServiceImpl().getByNdp(ndp);
			logger.info("NDPItemList succesfully retrieved......"+ndpItemList.size());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Ndpltems> getByNdp() : "
					+ e.getMessage());
		}
		
		return ndpItemList;
	}

	public Ndpltems add(Ndpltems ndpltems) throws Exception {
		boolean result = false;

		try {
			if (ndpltems != null) {
				result = new NdpItemServiceImpl().add(ndpltems);
				if(result)
				{
					logger.info("Ndpltems added susscessful. "+ndpltems.getName());
				}
				else
				{
					logger.info("Failed to add Ndpltems. "+ndpltems.getName());
				}
			}

		} catch (Exception e) {
			logger.info("Exception caught in boolean add(Ndp ndp) : "+e.getMessage());
		}
		return ndpltems;
	}

}
