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

import co.za.ngwane.epms.repository.Progndplink;
import co.za.ngwane.epms.repository.Progtbl;

public class ProgNdpLinkDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.ProgNdpLinkDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager()
	{
		if (emf == null)
		{
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Progndplink progndplink) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Program NDP link");
			if (progndplink != null)
			{
				em.persist(progndplink);
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
	
	//@SuppressWarnings("unchecked")
	public List<Progndplink> retrieveByProgram(Progtbl program) throws Exception
	{
		EntityManager em = getEntityManager();
		List<Progndplink> list = null;
		try
		{
			logger.info("Attempting to get Program Ndp links by Program");
			Query namedQuery = em.createNamedQuery("Progndplink.findByProgram");
			namedQuery.setParameter("progid", program);
			
			list = namedQuery.getResultList();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	}
