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

import co.za.ngwane.epms.repository.Projndplinkitems;
import co.za.ngwane.epms.repository.Projtbl;

public class ProjNdpLinkItemsDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.ProjNdpLinkItemsDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Projndplinkitems projndplinkitems) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Project Link Item object");
			if (projndplinkitems != null)
			{
				em.persist(projndplinkitems);
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
	
	public List<Projndplinkitems> retrieveByProject(Projtbl project) throws Exception
	{
		EntityManager em = getEntityManager();
		List<Projndplinkitems> projndplinkitems = null;
		try
		{
			logger.info("Attempting to get Project Ndp Items by Name");
			Query namedQuery = em.createNamedQuery("Projndplinkitems.findByProject");
			namedQuery.setParameter("projtblid", project);
			projndplinkitems = namedQuery.getResultList();
			logger.info("Got the list, size : " + projndplinkitems.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return projndplinkitems;
	}
	
	public boolean updateItemByProject(Projndplinkitems projNdpLinkItems) throws Exception{
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.merge(projNdpLinkItems);
			em.flush();

			et.commit();

			return true;
		} catch (IllegalStateException ise) {
			logger.info("IllegalStateException caught, msg: "
					+ ise.getMessage());
		} catch (IllegalArgumentException iae) {
			logger.info("IllegalArgumentException caught, msg: "
					+ iae.getMessage());
		} finally {
			em.close();
		}

		return false;
	}
}
