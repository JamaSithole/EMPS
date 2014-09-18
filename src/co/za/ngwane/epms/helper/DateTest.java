package co.za.ngwane.epms.helper;

import java.util.Calendar;
import java.util.Date;

public class DateTest
{
	public static void main(String[] args)
	{
//	    Calendar now = Calendar.getInstance();
//	    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "/"
//	        + now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR));
//
//	    // add days to current date using Calendar.add method
//	    now.add(Calendar.DATE, 3);
//
//	    System.out.println("date after one day : " + (now.get(Calendar.MONTH) + 1) + "/"
//	        + now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR));
	    
		 String DATE_FORMAT = "dd-MM-yyyy";
		 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		 Calendar c1 = Calendar.getInstance(); 
		 // roll down the month
		 c1.set(1982, 02 , 90); // 1999 jan 20
		 System.out.println("Date is : " + sdf.format(c1.getTime()));
		 c1.roll(Calendar.MONTH, false); // roll down, substract 1 month
		 System.out.println("Date roll down 1 month : " + sdf.format(c1.getTime())); // 1999 jan 20

		 c1.set(1982, 02 , 90); // 1999 jan 20 
		 System.out.println("Date is : " + sdf.format(c1.getTime()));
		 c1.add(Calendar.MONTH, 1); // substract 1 month
		 System.out.println("Date minus 1 month : " + sdf.format(c1.getTime())); // 1998 dec 20
	  }
}
