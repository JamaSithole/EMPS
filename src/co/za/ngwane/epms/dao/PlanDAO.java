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

import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Userepms;

public class PlanDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.PlanDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean addPlan(Plantbl plantbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Plan object");
			if (plantbl != null)
			{
				em.persist(plantbl);
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
	
	/*
	public Plantbl retrievePlanByUser(Userepms userepms) throws Exception
	{
		Plantbl plan = null;
		try
		{
			logger.info("Attempting to get Plan by User");
			EntityManager em = getEntityManager();
			Query namedQuery = em.createNamedQuery("Plantbl.findByUser");
			namedQuery.setParameter("name", userepms); // get the right names
			plan = (Plantbl) namedQuery.getSingleResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return plan;
	}
	*/
	
	public List<Plantbl> getAllPlans() throws Exception {
		List<Plantbl> planList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Plantbl.findAll");

			planList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return planList;
	}
	
	public boolean updatePlan(Plantbl plantbl) throws Exception{
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.merge(plantbl);
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
