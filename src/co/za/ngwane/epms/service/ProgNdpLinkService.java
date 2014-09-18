package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Progndplink;
import co.za.ngwane.epms.repository.Progtbl;

public interface ProgNdpLinkService {
	public boolean add(Progndplink progndplink) throws Exception;
	public List<Progndplink> retrieveByProgram(Progtbl progtbl) throws Exception;
//	boolean updateItemByProject(Projndplinkitems projNdpLinkItems) throws Exception;

}
