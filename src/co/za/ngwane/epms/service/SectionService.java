package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.repository.Sectiontbl;

public interface SectionService {
	public List<Sectiontbl> getAll() throws Exception;
	public Sectiontbl retrieveByName(String sectionName) throws Exception;
	public boolean add(Sectiontbl sectiontbl) throws Exception;

}
