package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Outupdate;
import co.za.ngwane.epms.repository.Qoupd;

public interface QoupdService {
	public boolean add(Qoupd qoupd) throws Exception;
	public List<Qoupd> getAll() throws Exception;
	public List<Qoupd> getByOutput(Outputtbl outputtbl) throws Exception;
	public List<Qoupd> getQoupByOutput(Outputtbl outputtbl) throws Exception;

}
