package co.za.ngwane.epms.helper
{
	public class Status
	{
		public static var RECIEVED_FOR_PROCESSING : String = "Recieved for processing";
		public static var RECORD_NOT_ADDED_TO_THE_STATUS_TABLE : String = "N";
		public static var DELETED : String = "Deleted";
		public static var CANCELLED : String = "Cancelled";
		public static var ACTIVE : String = "Active";
		public static var RSAID : String = "RSAID";
		public static var PASSWORD : String = "password";
		public static var USERNAME : String = "tutum";
		public static var DEV_ENV : String = "DEV";
		public static var TST_ENV : String = "TST";
		
		public static var YES : String = "Yes";
		public static var NO : String = "No";
		
		public static var ALLOWED : Boolean = true;
		public static var NOT_ALLOWED : Boolean = false;
		
		public static var UNSATISFACTORY : Number = 66.66;
		public static var BELOW_AVE : Number = 66.66;
		public static var ACHIEVED_TARGET : Number = 66.66;
		public static var EXCEEDED_TARGET : Number = 66.66;
		

		public function Status()
		{
		}
	}
}