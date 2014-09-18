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
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Userepms;

public class UserepmsDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}

	public boolean add(Userepms userepms) throws NamingException,
			SQLException {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			logger.info("Attempting to add Userepms object");
			if (userepms != null) {
				em.persist(userepms);
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

	public Userepms userLogin(String username, String password)
			throws Exception {
		Userepms user = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Userepms.userLogin");
			namedQuery.setParameter("username", username);
			namedQuery.setParameter("password", password);

			user = (Userepms) namedQuery.getSingleResult();

		} catch (Exception e) {
			System.out.println("Exception caught : " + e.getMessage());
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return user;
	}

	public List<Userepms> getAll() throws Exception {
		List<Userepms> userList = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Userepms.findAll");

			userList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return userList;
	}

	public Userepms getByName(String name) throws Exception {
		Userepms userepms = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Userepms.findByName");
			namedQuery.setParameter("name", name);
			userepms = (Userepms) namedQuery.getSingleResult();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return userepms;
	}

}
