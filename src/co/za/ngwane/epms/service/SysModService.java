package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Sysmod;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;

public interface SysModService {
	public List<Sysmod> getAll() throws Exception;
	public boolean add(Sysmod sysmod) throws Exception;

}
