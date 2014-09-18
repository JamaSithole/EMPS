package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Directorate;

public interface DirectorateService {
	public List<Directorate> getAll() throws Exception;
	public boolean add(Directorate directorate) throws Exception;

}
