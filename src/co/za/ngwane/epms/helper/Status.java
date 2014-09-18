package co.za.ngwane.epms.helper;

/**
 * 
 * @author bheki.lubisi
 */
public class Status
{
	public static final int ACTIVE_Int = 1;
	public static final String ACTIVE = "Active";
	public static final String DELETED = "Deleted";
	public static final String CANCELLED = "Cancelled";
	public static final int DELETED_Int = 2;
	public static final int UPDATED = 3;
	public static final int COMPLETED = 4;

	// Timesheet statuses and Claim statuses
	public static final String RECIEVED_FOR_PROCESSING = "Recieved for processing";
	public static final String SENT_FOR_PROCESSING = "Send for processing";
	public static final String APPROVED = "Approved";
	public static final String REJECTED = "Rejected";
	public static final String DECLINED = "Declined";
	public static final String DELETED_RECORD = "Deleted";
	public static final String RECORD_ADDED_TO_THE_STATUS_TABLE = "Y";
	public static final String RECORD_NOT_ADDED_TO_THE_STATUS_TABLE = "N";
	public static final String EDITED_BY_USER = "Edited"; // This will be used
															// when updating a
															// timesheet

	// Periods
	public static final int DAILY = 13;
	public static final int WEEKLY = 14;
	public static final int FORTNIGHT = 15;
	public static final int MONTHLY = 16;

	// THis was gender and I removed it, so this two variables are available for
	// reuse
	// public static final int MALE = 17;
	// public static final int FEMALE = 18;

	// ManagementOrNot
	public static final String MANAGEMENT = "19";
	public static final String NOT_MANAGEMENT = "20";

	public static final boolean ALLOWED = true;
	public static final boolean NOT_ALLOWED = false;
	public static final boolean GENERIC = true;
	public static final String ALGORITHM = "MD5";
	public static final String ENCODING = "UTF-8";

	// Company modules
	public static final int NOT_APPLICABLE = 0;
	public static final int APPLICABLE_GENERIC = 1;
	public static final int APPLICABLE_NON_GENERIC = 2;

	public static final String CLAIM = " Claim";
	public static final String CLIENT = "Client";
	public static final String GRAND_LEAVE = "Grand Leave";
	public static final String LEAVE = "Leave";
	public static final String PROJECT = "Project";
	public static final String TIMESHEET = "Timesheet";
	public static final String USER = "User";
	public static final String USER_PROJECT = "User Project";

	public Status()
	{
	}
}
