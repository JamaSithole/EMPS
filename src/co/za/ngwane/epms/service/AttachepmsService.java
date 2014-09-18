package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Attachepms;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Qoupd;

public interface AttachepmsService {
	public List<Attachepms> getAll() throws Exception;
	public boolean add(Attachepms attachepms) throws Exception;
	public boolean update(Attachepms attachepms) throws Exception;
	public List<Attachepms> getByQoup(Qoupd qoupd) throws Exception;

}
