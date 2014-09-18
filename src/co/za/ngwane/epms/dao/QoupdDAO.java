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
import co.za.ngwane.epms.repository.Outupdate;
import co.za.ngwane.epms.repository.Qoupd;


public class QoupdDAO {
	
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.QoupdDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean addQoupd(Qoupd qoupd) throws NamingException, SQLException  
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add outupdate object");
			if (qoupd != null)
			{
				em.persist(qoupd);
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
	
	public List<Outputtbl> getAll() throws Exception {
		List<Outputtbl> outputList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outputtbl.findAll");

			outputList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return outputList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Qoupd> getByOutputName(Outputtbl out) throws Exception {
		List<Qoupd> qoupdList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Qoupd.findPending");
			namedQuery.setParameter("outputtblid", out);
			qoupdList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return qoupdList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Qoupd> getRejectedByOutputName(Outputtbl out) throws Exception {
		List<Qoupd> qoupdList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Qoupd.findRejected");
			namedQuery.setParameter("outputtblid", out);
			qoupdList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return qoupdList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Qoupd> getQoupByOutput(Outputtbl out) throws Exception {
		List<Qoupd> qoupdList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Qoupd.findByOutputtblid");
			namedQuery.setParameter("outputtblid", out);
			qoupdList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return qoupdList;
	}


}
