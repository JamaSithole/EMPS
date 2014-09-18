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

import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;

public class DirectorateDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.DirectorateDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}
	
	public List<Directorate> getAll()
			throws Exception {
		List<Directorate> dirList = null; 

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Directorate.findAll");

			dirList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return dirList;
	}
	
	public boolean add(Directorate directorate) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Directorate object");
			if (directorate != null)
			{
				em.persist(directorate);
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
	
	public List<Directorate> getDirByDept(Dept dept) throws Exception {
		List<Directorate> directorates = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Directorate.findByDept");
			namedQuery.setParameter("deptid", dept);
			directorates =  namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return directorates;
	}



}
