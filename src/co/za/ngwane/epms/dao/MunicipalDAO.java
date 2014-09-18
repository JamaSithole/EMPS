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

import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Municipal;

public class MunicipalDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.MunicipalDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}
	
	public Municipal getById(Integer id)
			throws Exception {
		Municipal municipal = null; 

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Municipal.findById");
			namedQuery.setParameter("id", id);
			
			municipal = (Municipal) namedQuery.getSingleResult(); 

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return municipal;
	}
	
	public List<Municipal> getAll()
			throws Exception {
		List<Municipal> municipalList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Municipal.findAll");

			municipalList = namedQuery.getResultList(); 

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return municipalList;
	}
	
	public boolean add(Municipal municipal) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Municipal object");
			if (municipal != null)
			{
				em.persist(municipal);
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
