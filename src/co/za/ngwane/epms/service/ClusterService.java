package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;

public interface ClusterService {
	public List<Clustertbl> getAll() throws Exception;
	public boolean add(Clustertbl clustertbl) throws Exception;

}
