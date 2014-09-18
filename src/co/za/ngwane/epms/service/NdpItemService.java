package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Ndpltems;

public interface NdpItemService {
	public List<Ndpltems> getAll() throws Exception;
	public List<Ndpltems> getByNdp(Ndp ndp) throws Exception;
	public Ndpltems getByName(String ndpItemName) throws Exception;
	public boolean add(Ndpltems ndpItem) throws Exception;

}
