package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Municipal;

public interface MunicipalService {
	public List<Municipal> getAll() throws Exception;
	public boolean add(Municipal municipal) throws Exception;
	public Municipal getById(Integer id) throws Exception;

}
