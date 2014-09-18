package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Progtbl;

public interface ProgramService {
	public boolean add(Progtbl progtbl) throws Exception;
	public Progtbl retrieveByName(String programName) throws Exception;
	public List<Progtbl> getAll() throws Exception;
	public boolean update(Progtbl progtbl) throws Exception;

}
