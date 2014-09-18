package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Outcometbl;

public interface OutcomeService {
	public boolean add(Outcometbl outcometbl) throws Exception;
	public Outcometbl retrieveByName(String outcome) throws Exception;
	public List<Outcometbl> getAll() throws Exception;
	boolean update(Outcometbl outcometbl) throws Exception;

}
