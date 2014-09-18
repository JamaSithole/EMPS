package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;

public interface OutputService {
	public boolean add(Outputtbl outputtbl) throws Exception;
	public boolean update(Outputtbl outputtbl, Qoupd qoupd) throws Exception;
	public List<Outputtbl> getByOutcomeName(Outcometbl outcometbl) throws Exception;
	public List<Outputtbl> getAll() throws Exception;
}
