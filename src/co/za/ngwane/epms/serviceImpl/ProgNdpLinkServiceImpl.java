package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ProgNdpLinkDAO;
import co.za.ngwane.epms.repository.Progndplink;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.service.ProgNdpLinkService;

public class ProgNdpLinkServiceImpl implements ProgNdpLinkService {

	@Override
	public boolean add(Progndplink progndplink) throws Exception {
		boolean result = false;
		
		try {
			if(progndplink != null){
				result = new ProgNdpLinkDAO().add(progndplink);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Progndplink> retrieveByProgram(Progtbl progtbl) throws Exception {
		List<Progndplink> progndplinks = null;

		if(progtbl != null){
			progndplinks = new ProgNdpLinkDAO().retrieveByProgram(progtbl);				
		}		
		return progndplinks;
	}
	
}
