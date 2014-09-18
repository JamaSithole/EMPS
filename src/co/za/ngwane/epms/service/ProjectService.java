package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Qoupd;

public interface ProjectService {
	public boolean add(Projtbl projtbl) throws Exception;
	public Projtbl retrieveByName(String projectName) throws Exception;
	public List<Projtbl> getAll() throws Exception;
	//public Emailtbl retrieveEmailByRef(Emailtbl emailtbl) throws Exception;
	boolean updateBudget(Projtbl projtbl) throws Exception;
	boolean updateBudget(Projtbl projtbl,Outputtbl outputtbl) throws Exception;
	boolean updateBudget(Projtbl projtbl,Qoupd qoupd) throws Exception;
	public List<Projtbl> getByProgName(String progName) throws Exception;

}
