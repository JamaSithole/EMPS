package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.NdpDAO;
import co.za.ngwane.epms.dao.OutcomeDAO;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.service.NdpService;

public class NdpServiceImpl implements NdpService {

	@Override
	public List<Ndp> getAll() throws Exception {
		List<Ndp> ndpList = null;
		try {
			ndpList = new NdpDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ndpList;
	}

	@Override
	public Ndp getByName(String ndpName) throws Exception {
		Ndp ndp = null;
		try {
			ndp = new NdpDAO().getByName(ndpName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ndp;
	}

	@Override
	public boolean add(Ndp ndp) throws Exception {
		boolean result = false;

		try {
			if (ndp != null) {
				result = new NdpDAO().add(ndp);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
