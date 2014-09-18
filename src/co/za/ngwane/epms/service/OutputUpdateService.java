package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Qoupd;

public interface OutputUpdateService {
	public boolean addOutputUpdate(Qoupd outupdate) throws Exception;
	public List<Qoupd> getAll() throws Exception;
	public boolean update(Qoupd outupdate) throws Exception;

}
