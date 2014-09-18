package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Ndp;

public interface NdpService {
	public List<Ndp> getAll() throws Exception;
	public Ndp getByName(String ndpName) throws Exception;
	public boolean add(Ndp ndp) throws Exception;

}
