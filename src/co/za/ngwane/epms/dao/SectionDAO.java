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
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.repository.Plantbl;
import co.za.ngwane.epms.repository.Sectiontbl;
import co.za.ngwane.epms.repository.Userepms;

public class SectionDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.SectionDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}
	
	public List<Sectiontbl> getAll()
			throws Exception {
		List<Sectiontbl> sectionList = null;   

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Sectiontbl.findAll");

			sectionList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return sectionList;
	}

	public Sectiontbl retrieveByName(String name)
			throws Exception {
		Sectiontbl section = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Sectiontbl.findByName");
			namedQuery.setParameter("name", name);
			section = (Sectiontbl) namedQuery.getSingleResult();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return section;
	}
	
	public boolean add(Sectiontbl sectiontbl) throws NamingException, SQLException
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Sectiontbl object");
			if (sectiontbl != null)
			{
				em.persist(sectiontbl);
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
	
	public List<Sectiontbl> getSectionByDir(Directorate directorate) throws Exception {
		List<Sectiontbl> sectiontbls = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Sectiontbl.findByDir");
			namedQuery.setParameter("directorateid", directorate);
			sectiontbls =  namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return sectiontbls;
	}

	
}
