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
import co.za.ngwane.epms.repository.Progtbl;

public class NdpItemDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.NdpDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public List<Ndpltems> getAll() throws Exception {
		List<Ndpltems> ndpItemList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Ndpltems.findAll");

			ndpItemList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return ndpItemList;
	}

	public List<Ndpltems> getByNdp(Ndp ndp) throws Exception {
		List<Ndpltems> ndpItemList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Ndpltems.findByNdp");
			namedQuery.setParameter("ndpid", ndp);
			ndpItemList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return ndpItemList;
	}
	
	
	public Ndpltems getByName(String itemName) throws Exception
	{
		Ndpltems ndpItem = new Ndpltems();
		try
		{
			logger.info("Attempting to get Program by Name");
			EntityManager em = getEntityManager();
			Query namedQuery = em.createNamedQuery("Ndpltems.findByName");
			namedQuery.setParameter("name", itemName);
			ndpItem = (Ndpltems) namedQuery.getSingleResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ndpItem;
	}
	
	public boolean add(Ndpltems ndp) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Ndpltems object");
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
