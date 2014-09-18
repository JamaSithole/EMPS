package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;

public interface UserModService {
	public List<Usermod> getByUser(Userepms userepms) throws Exception;
	public boolean add(Usermod usermod) throws Exception;

}
