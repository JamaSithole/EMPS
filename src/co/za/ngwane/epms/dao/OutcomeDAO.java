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

import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Projtbl;

public class OutcomeDAO {

	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.OutcomeDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Outcometbl outcometbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Outcome object");
			if (outcometbl != null)
			{
				em.persist(outcometbl);
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
	
	public boolean update(Outcometbl outcometbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to update Outcome object");
			if (outcometbl != null)
			{
				em.merge(outcometbl);
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
	
	public Outcometbl retrieveByName(String name) throws Exception
	{
		Outcometbl outcome = new Outcometbl();
		try
		{
			logger.info("Attempting to get Outcometbl by Name");
			EntityManager em = getEntityManager();
			Query namedQuery = em.createNamedQuery("Outcometbl.findByName");
			namedQuery.setParameter("name", name);
			outcome = (Outcometbl) namedQuery.getSingleResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return outcome;
	}
	
	@SuppressWarnings("unchecked")
	public List<Outcometbl> getAll() throws Exception {
		List<Outcometbl> outcomeList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outcometbl.findAll");

			outcomeList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return outcomeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Outcometbl> getByProject(Projtbl projtbl) throws Exception {
		List<Outcometbl> outcomeList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outcometbl.findByProjtblid");
			namedQuery.setParameter("projtblid", projtbl);
			outcomeList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return outcomeList;
	}

}
