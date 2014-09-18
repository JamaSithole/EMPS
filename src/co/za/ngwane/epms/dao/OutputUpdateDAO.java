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

import co.za.ngwane.epms.repository.Outupdate;
import co.za.ngwane.epms.repository.Qoupd;

public class OutputUpdateDAO {

	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.OutputUpdateDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean addOutputUpdate(Qoupd outupdate) throws NamingException,
			SQLException {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			logger.info("Attempting to add Outputupdate object");
			if (outupdate != null) {
				em.persist(outupdate);
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

	public List<Qoupd> getAll() throws Exception {
		logger.info("Attempting to getAll() Outputupdate");

		List<Qoupd> outputUpdateList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Qoupd.findAll");

			outputUpdateList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return outputUpdateList;
	}

	
}
