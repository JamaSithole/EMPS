package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;

public interface DeptService {
	public List<Dept> getAll() throws Exception;
	public boolean add(Dept dept) throws Exception;

}
