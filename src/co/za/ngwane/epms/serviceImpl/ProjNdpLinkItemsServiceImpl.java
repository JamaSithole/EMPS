package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.ProjNdpLinkItemsDAO;
import co.za.ngwane.epms.repository.Projndplinkitems;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.service.ProjNdpLinkItemsService;

public class ProjNdpLinkItemsServiceImpl implements ProjNdpLinkItemsService {

	@Override
	public boolean add(Projndplinkitems projndplinkitems) throws Exception {
		boolean result = false;
		
		try {
			if(projndplinkitems != null){
				result = new ProjNdpLinkItemsDAO().add(projndplinkitems);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Projndplinkitems> retrieveByProject(Projtbl projtbl) throws Exception {
		List<Projndplinkitems> projndplinkitems = null;

		if(projtbl != null){
			projndplinkitems = new ProjNdpLinkItemsDAO().retrieveByProject(projtbl);				
		}		
		return projndplinkitems;
	}
	
	@Override
	public boolean updateItemByProject(Projndplinkitems projNdpLinkItems) throws Exception
	{
		boolean result = false;

		try {
			if (projNdpLinkItems != null) {
				result = new ProjNdpLinkItemsDAO().updateItemByProject(projNdpLinkItems);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
