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

import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;

public class ProjectDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.ProjecttDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Projtbl projtbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Project object");
			if (projtbl != null)
			{
				em.persist(projtbl);
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
	
	public Projtbl retrieveByName(String name) throws Exception
	{
		Projtbl project = new Projtbl();
		try
		{
			logger.info("Attempting to get Project by Name");
			EntityManager em = getEntityManager();
			Query namedQuery = em.createNamedQuery("Projtbl.findByName");
			namedQuery.setParameter("name", name);
			
			project = (Projtbl) namedQuery.getSingleResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return project;
	}

	public List<Projtbl> getAll() throws Exception {
		List<Projtbl> projList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Projtbl.findAll");

			projList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return projList;
	}
	
	public List<Projtbl> getByProgName(Progtbl projtbl) throws Exception {
		List<Projtbl> projList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Projtbl.findByProgtblid");
			namedQuery.setParameter("progtblid", projtbl);
			projList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return projList;
	}
	
	public boolean updateBudget(Projtbl projtbl) throws Exception{
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.merge(projtbl);
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
