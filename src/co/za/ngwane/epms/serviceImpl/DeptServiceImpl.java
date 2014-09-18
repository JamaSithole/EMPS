package co.za.ngwane.epms.serviceImpl;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import co.za.ngwane.epms.dao.ClusterDAO;
import co.za.ngwane.epms.dao.DeptDAO;
import co.za.ngwane.epms.dao.DirectorateDAO;
import co.za.ngwane.epms.repository.Clustertbl;
import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Directorate;
import co.za.ngwane.epms.service.ClusterService;
import co.za.ngwane.epms.service.DeptService;
import co.za.ngwane.epms.service.DirectorateService;

public class DeptServiceImpl implements DeptService {

	@Override
	public List<Dept> getAll() throws Exception { 
		List<Dept> deptList = null;
		try {
			deptList = new DeptDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return deptList;
	}

	@Override
	public boolean add(Dept dept) throws Exception {
		boolean results = false;
		try {
			results = new DeptDAO().add(dept);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return results;
	}
	
	public List<Dept> getDeptByCluster(Clustertbl clustertbl) throws Exception {
		List<Dept> depts = null;
		if(clustertbl != null){
			depts = new DeptDAO().getDeptByCluster(clustertbl);				
		}
		
		return depts;
	}

}
