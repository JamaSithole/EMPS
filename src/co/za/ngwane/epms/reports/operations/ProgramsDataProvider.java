package co.za.ngwane.epms.reports.operations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.reports.vo.Programs;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.serviceImpl.ProgramServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProjectServiceImpl;

public class ProgramsDataProvider  {
	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.reports.operations.ProgramsDataProvider");

	
	public ProgramsDataProvider() {
		
	}
	
	public ArrayList<Programs> findAllPrograms (String param) {
		ArrayList<Programs> allPrograms = new ArrayList<Programs>();
		
		List<Projtbl> projtbls = new ArrayList<Projtbl>();
		if (param.equalsIgnoreCase("All")) {
			projtbls = getAll();

		} else {
			try {
				projtbls = new ProjectServiceImpl().getByProgName(param);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		for (Projtbl projtbl : projtbls) {
			Programs program = new Programs();
			program.setProgramName(projtbl.getProgtblid().getName());
			program.setProgramBudget(new BigDecimal(String.valueOf(projtbl.getProgtblid().getTotalbudget())));
			
			if (projtbl.getProgtblid().getPlanid() != null && projtbl.getProgtblid().getPlanid() != null) {
				program.setProgramStartD(projtbl.getProgtblid().getPlanid().getStartd());
			} else {
				program.setProgramStartD(null);
			}
			
			if (projtbl.getProgtblid().getPlanid() != null && projtbl.getProgtblid().getPlanid() != null) {
				program.setProgramEndD(projtbl.getProgtblid().getPlanid().getEndd());
			} else {
				program.setProgramEndD(null);
			}
			
			program.setProjectName(projtbl.getName());
			program.setOwner(projtbl.getOwner().getName()+" "+projtbl.getOwner().getSurname());
			program.setAllocBudget(new BigDecimal(projtbl.getTotbud()));
			program.setUsedBudget(new BigDecimal(projtbl.getBudspend()));
			program.setAvailBudget(new BigDecimal(projtbl.getTotbud() - projtbl.getBudspend()));
			program.setPercUsed((new BigDecimal((projtbl.getBudspend()/projtbl.getTotbud())* 100)).doubleValue());
			
			allPrograms.add(program);
		}
		
		return allPrograms;
		
	}
	
	public List<Projtbl> getAll(){
		
		List<Projtbl> projList = null; 
		try {
			projList = new ProjectServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Projtbl> getAll() : "+e.getMessage());
		}
		return projList;
		
	}


}
