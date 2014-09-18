package co.za.ngwane.epms.service;

import java.util.List;

import co.za.ngwane.epms.repository.Userepms;


public interface UserepmsService 
{
	public Userepms userLogin(String username, String password) throws Exception;
	public List<Userepms> getAll() throws Exception;
	public Userepms getByName(String ndpName) throws Exception;
	public boolean add (Userepms user) throws Exception;
}
