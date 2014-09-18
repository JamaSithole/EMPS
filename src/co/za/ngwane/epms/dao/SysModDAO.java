package co.za.ngwane.epms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Sysmod;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermod;

public class SysModDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.Sysmod");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}
	
	public List<Sysmod> getAll()
			throws Exception {  
		List<Sysmod> sysModList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Sysmod.findAll");

			sysModList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return sysModList;
	}
	
	public boolean add(Sysmod sysmod) throws NamingException, SQLException 
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Sysmod object");
			if (sysmod != null)
			{
				em.persist(sysmod);
				em.flush();

				et.commit();
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (EntityExistsException eee)
		{
			System.err.println("EntityExistsException caught, msg: " + eee.getMessage());
		}
		catch (IllegalStateException ise)
		{
			System.err.println("IllegalStateException caught, msg: " + ise.getMessage());
		}
		finally
		{
			em.close();
		}
		return false;
	}

}
