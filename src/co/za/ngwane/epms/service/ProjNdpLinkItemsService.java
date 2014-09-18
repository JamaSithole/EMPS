package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Projndplinkitems;
import co.za.ngwane.epms.repository.Projtbl;

public interface ProjNdpLinkItemsService {
	public boolean add(Projndplinkitems projNdpLinkItems) throws Exception;
	public List<Projndplinkitems> retrieveByProject(Projtbl projtbl) throws Exception;
	boolean updateItemByProject(Projndplinkitems projNdpLinkItems) throws Exception;

}
