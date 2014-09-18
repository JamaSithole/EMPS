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
import co.za.ngwane.epms.repository.Userepms;

public class OutputDAO {

	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.OutputDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean addOutput(Outputtbl outputtbl) throws NamingException,
			SQLException {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			logger.info("Attempting to add Output object");
			if (outputtbl != null) {
				em.persist(outputtbl);
				em.flush();

				et.commit();
				return true;
			} else {
				return false;
			}
		} catch (EntityExistsException eee) {
			System.err.println("EntityExistsException caught, msg: "
					+ eee.getMessage());
		} catch (IllegalStateException ise) {
			System.err.println("IllegalStateException caught, msg: "
					+ ise.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	public List<Outputtbl> getAll() throws Exception {
		List<Outputtbl> outputList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outputtbl.findAll");

			outputList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return outputList;
	}

	public List<Outputtbl> getByOutputName(Outcometbl out) throws Exception {
		List<Outputtbl> outputList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outputtbl.findByOutcome");
			namedQuery.setParameter("outcometblid", out);
			outputList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return outputList;
	}

	public List<Outputtbl> getOutputByUser(Userepms userepms) throws Exception {
		List<Outputtbl> outputList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Outputtbl.findByUserepms");
			namedQuery.setParameter("userid", userepms);
			outputList =  namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return outputList;
	}

	public boolean update(Outputtbl output) throws Exception { 
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.merge(output);
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
