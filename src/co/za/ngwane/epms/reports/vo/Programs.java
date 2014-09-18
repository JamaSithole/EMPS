package co.za.ngwane.epms.reports.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Programs {
	
	private String programName;
	private BigDecimal programBudget;
	private Date programStartD;
	private Date programEndD;
	private String projectName;
	private String owner;
	private BigDecimal allocBudget;
	private BigDecimal usedBudget;
	private BigDecimal availBudget;
	private double percUsed;


	
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public BigDecimal getProgramBudget() {
		return programBudget;
	}
	public void setProgramBudget(BigDecimal programBudget) {
		this.programBudget = programBudget;
	}
	public Date getProgramStartD() {
		return programStartD;
	}
	public void setProgramStartD(Date programStartD) {
		this.programStartD = programStartD;
	}
	public Date getProgramEndD() {
		return programEndD;
	}
	public void setProgramEndD(Date programEndD) {
		this.programEndD = programEndD;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public BigDecimal getAllocBudget() {
		return allocBudget;
	}
	public void setAllocBudget(BigDecimal allocBudget) {
		this.allocBudget = allocBudget;
	}
	public BigDecimal getUsedBudget() {
		return usedBudget;
	}
	public void setUsedBudget(BigDecimal usedBudget) {
		this.usedBudget = usedBudget;
	}
	public BigDecimal getAvailBudget() {
		return availBudget;
	}
	public void setAvailBudget(BigDecimal availBudget) {
		this.availBudget = availBudget;
	}
	public double getPercUsed() {
		return percUsed;
	}
	public void setPercUsed(double percUsed) {
		this.percUsed = percUsed;
	}

}
