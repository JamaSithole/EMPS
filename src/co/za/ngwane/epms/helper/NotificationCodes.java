package co.za.ngwane.epms.helper;

public enum NotificationCodes {
	
	WEEK_BEFORE(1, "A week before"),
	DAY_BEFORE(2, "Day before "),
	END_OF_QAUTER(3, "End Of Qauter"),
	SIX_PM_MSG(4,"6 PM Messages");
	
	
	private Integer code;
	private String description;
	
	NotificationCodes(int code, String description) {
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
		for(NotificationCodes stat : NotificationCodes.values()){
			if(status == stat.getCode()) return stat.description;
		}
		return null;
	}
}
