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
import co.za.ngwane.epms.repository.Userepms;

public class DeptDAO {
	private Logger logger = Logger.getLogger("co.za.ngwane.epms.dao.DeptDAO");
	private EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EPMSPU");
		}
		return emf.createEntityManager();
	}
	
	public List<Dept> getAll()
			throws Exception {
		List<Dept> deptList = null;  

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Dept.findAll");

			deptList = namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
		} finally {
			em.close();
		}

		return deptList;
	}
	
	public boolean add(Dept dept) throws NamingException, SQLException 
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try
		{
			logger.info("Attempting to add Dept object");
			if (dept != null)
			{
				em.persist(dept);
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
	
	public List<Dept> getDeptByCluster(Clustertbl clustertbl) throws Exception {
		List<Dept> depts = null;

		EntityManager em = getEntityManager();
		try {
			Query namedQuery = em.createNamedQuery("Dept.findByCluster");
			namedQuery.setParameter("clusterid", clustertbl);
			depts =  namedQuery.getResultList();

		} catch (Exception e) {
			logger.info("Exception caught : " + e.getMessage());
			e.printStackTrace();
		} finally {
			em.close();
		}

		return depts;
	}


}
