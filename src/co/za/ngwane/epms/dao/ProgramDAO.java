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

public class ProgramDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.ProgramDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Progtbl progtbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Program object");
			if (progtbl != null)
			{
				em.persist(progtbl);
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
	
	public boolean update(Progtbl progtbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to update Program object");
			if (progtbl != null)
			{
				em.merge(progtbl);
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
	
	public Progtbl retrieveByName(String programName) throws Exception
	{
		Progtbl program = new Progtbl();
		try
		{
			logger.info("Attempting to get Program by Name");
			EntityManager em = getEntityManager();
			Query namedQuery = em.createNamedQuery("Progtbl.findByName");
			namedQuery.setParameter("name", programName);
			program = (Progtbl) namedQuery.getSingleResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return program;
	}
	
	public List<Progtbl> getAll() throws Exception {
		List<Progtbl> progList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Progtbl.findAll");

			progList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return progList;
	}
}
