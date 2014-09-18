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

import co.za.ngwane.epms.repository.Attachepms;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;

public class AttachepmsDAO {
	private Logger logger = Logger
			.getLogger("co.za.ngwane.epms.dao.AttachepmsDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public List<Attachepms> getAll() throws Exception {
		List<Attachepms> attachList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Attachepms.findAll");

			attachList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return attachList;
	}

	public boolean add(Attachepms attachepms) throws NamingException,
			SQLException {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			logger.info("Attempting to add Attachepms object");
			if (attachepms != null) {
				em.persist(attachepms);
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
	
	public List<Attachepms> getByQoupd(Qoupd qoupdid) throws Exception { 
		List<Attachepms> attchList = null; 

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Attachepms.findByQoupd");
			namedQuery.setParameter("qoupdid", qoupdid);
			attchList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return attchList;
	}

}
