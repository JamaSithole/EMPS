package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.dao.UserModDAO;
import co.za.ngwane.epms.repository.Sysmod;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;
import co.za.ngwane.epms.serviceImpl.SysModServiceImpl;
import co.za.ngwane.epms.serviceImpl.UserModServiceImpl;

public class SysModOperations {

	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.SysModOperations");

	public boolean add(Sysmod sysmod) {
		boolean results = true;
		logger.info("Entering add method in SysModOperations");

		if (sysmod != null) {

			try {
				results = new SysModServiceImpl().add(sysmod);
			} catch (Exception e) {
				results = false;
				logger.info("Exception caught : " + e.getMessage());
				e.printStackTrace();
			}
		}
		return results;
	}

	public List<Sysmod> getAll() throws Exception {
		List<Sysmod> sysmodList = null;
		try {
			sysmodList = new SysModServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Sysmod> getAll() : "
					+ e.getMessage());
		}
		return sysmodList;
	}

	public List<Sysmod> getSysMod(Userepms userepms) throws Exception {
		
		List<Usermod> userModList = new UserModServiceImpl().getByUser(userepms);
		List<Sysmod> sysmodList = new SysModServiceImpl().getAll();
		
		try {
			
			for (Usermod usermod : userModList) {
				if (sysmodList.contains(usermod.getModule())) {
					sysmodList.remove(usermod.getModule());
				}
			}
		} catch (Exception e) {
			logger.info("Exception caught in List<Sysmod> getSysMod( List<Usermod> userModList, List<Sysmod> sysmodList)"
					+ ": " + e.getMessage());
			e.printStackTrace();
		}
		return sysmodList;
	}

}
