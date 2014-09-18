package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import co.za.ngwane.epms.dao.OutputUpdateDAO;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.service.OutputUpdateService;

public class OutputUpdateServiceImpl implements OutputUpdateService {
	
	@Override
	public boolean addOutputUpdate(Qoupd outupdate) throws Exception {
		boolean result = false;

		try {
			if (outupdate != null) {
				result = new OutputUpdateDAO().addOutputUpdate(outupdate);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Qoupd> getAll() throws Exception {

		List<Qoupd> outputUpdateList = null;
		try {
			outputUpdateList = new OutputUpdateDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputUpdateList;
	}

	public boolean addSignedOffData(Qoupd outupdate) throws Exception {
		boolean result = false;

		try {
			if (outupdate != null) {
				result = new OutputUpdateDAO().addOutputUpdate(outupdate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Qoupd outupdate) throws Exception {
		boolean result = false;

		try {
			if (outupdate != null) {
				result = new OutputUpdateDAO().addOutputUpdate(outupdate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
