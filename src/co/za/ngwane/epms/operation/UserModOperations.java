package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Sysmod;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;
import co.za.ngwane.epms.serviceImpl.UserModServiceImpl;

public class UserModOperations {
	
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.UserModOperations");
	
	public boolean add(Userepms userepms, List<Sysmod> sysmodList){ 
		boolean results = true;
		logger.info("Entering add method in UserModOperations" );
		
		if( sysmodList != null ){
			try {
				for (Sysmod sysmod : sysmodList)
				{
					Usermod usermod = new Usermod();
					
					usermod.setModule(sysmod);
					usermod.setUser(userepms);
					
					if(results = new UserModServiceImpl().add(usermod))
					{
						logger.info(" Module "+usermod.getModule().getDescription()+ " added successful for user "+usermod.getUser());
					}
					else
					{
						logger.info(" Failed to add Module "+usermod.getModule().getDescription()+ " for user "+usermod.getUser());
					}
				}
			} catch (Exception e) {
				results = false;
				logger.info("Exception caught : "+e.getMessage());
				e.printStackTrace();
			}
		}
		
		return results;
	}
	
	public List<Usermod> getByUser(Userepms userepms) throws Exception {
		List<Usermod> usermodList = null;
		try {
			usermodList = new UserModServiceImpl().getByUser(userepms);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Usermod> getByUser(Userepms userepms) : "+e.getMessage());
		}
		return usermodList; 
	}

}
