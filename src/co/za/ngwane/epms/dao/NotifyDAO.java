package co.za.ngwane.epms.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Usermessages;


public class NotifyDAO {
	
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.NotifyDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean addusermessage(Usermessages usermessages) throws NamingException, SQLException  
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add outupdate object");
			if (usermessages != null)
			{
				em.persist(usermessages);
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
	
	public List<Usermessages> getAll(Date currentDate) throws Exception {
		List<Usermessages> messageList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Usermessages.findMessagesToProcess");
			namedQuery.setParameter("date", currentDate);
			namedQuery.setParameter("status", 1);
			messageList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return messageList;
	}
	
	public List<Usermessages> getByOutput(Outputtbl outputtbl) throws Exception {
		List<Usermessages> messageList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Usermessages.findByOutput");
			namedQuery.setParameter("output", outputtbl);
			messageList= namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return messageList;
	}
	
	public boolean update(Usermessages usermessages) throws Exception {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to update usermessages object");
			if (usermessages != null)
			{
				em.merge(usermessages);
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
		
		
		return true;
	}
	
	
}
