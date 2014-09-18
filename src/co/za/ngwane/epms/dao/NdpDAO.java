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

import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Ndpltems;
import co.za.ngwane.epms.repository.Outcometbl;

public class NdpDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.NdpDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public List<Ndp> getAll() throws Exception {
		List<Ndp> ndpList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Ndp.findAll");

			ndpList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return ndpList;
	}
	
	public Ndp getByName(String ndpName) throws Exception {
		Ndp ndp = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Ndp.findByName");
			namedQuery.setParameter("name", ndpName);
			ndp = (Ndp) namedQuery.getSingleResult();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return ndp;
	}
	
	public boolean add(Ndp ndp) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add ndp object");
			if (ndp != null)
			{
				em.persist(ndp);
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
