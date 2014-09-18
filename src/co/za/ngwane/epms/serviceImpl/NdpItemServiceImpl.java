package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.NdpDAO;
import co.za.ngwane.epms.dao.NdpItemDAO;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Ndpltems;
import co.za.ngwane.epms.service.NdpItemService;

public class NdpItemServiceImpl implements NdpItemService {

	@Override
	public List<Ndpltems> getAll() throws Exception {
		List<Ndpltems> ndpItemList = null;
		try {
			ndpItemList = new NdpItemDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ndpItemList;
	}

	@Override
	public List<Ndpltems> getByNdp(Ndp ndp) throws Exception {
		List<Ndpltems> ndpItemList = null;
		try {
			ndpItemList = new NdpItemDAO().getByNdp(ndp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ndpItemList;
	}

	@Override
	public Ndpltems getByName(String ndpName) throws Exception {
		Ndpltems ndpListItem = null;
		try {
			ndpListItem = new NdpItemDAO().getByName(ndpName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ndpListItem;
	}

	@Override
	public boolean add(Ndpltems ndpItem) throws Exception {
		boolean result = false;

		try {
			if (ndpItem != null) {
				result = new NdpItemDAO().add(ndpItem);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
