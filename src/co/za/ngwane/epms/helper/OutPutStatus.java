package co.za.ngwane.epms.helper;

public enum OutPutStatus {
	
	PENDING_SIGN_OFF(1, "Pending Sign Off"),
	SIGNED_OFF(2, "Signed Off"),
	REJECTED(3, "Rejected"),
	PENDING_AUDIT(4, "Pending Audit Sign Off"),
	AUDITED(5, "Audited"),
	AUDIT_REJECTED(6,"Audit Rejcted");
	
	private Integer code;
	private String description;
	
	OutPutStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() { 
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String getDescByCode(int status){
		for(OutPutStatus stat : OutPutStatus.values()){
			if(status == stat.getCode()) return stat.description;
		}
		return null;
	}
}
