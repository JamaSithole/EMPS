package co.za.ngwane.epms.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author bheki.lubisi
 */
public class DateFormatter {
	public DateFormatter() {
	}

	public String formattedDate() {
		Date todaysDate = new java.util.Date();
		// Formatting date into yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new DD/MM/YYYY initial it was yyyy-MM-dd
		// SimpleDateFormat formatter = new
		// SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		String formattedDate = formatter.format(todaysDate);

		return formattedDate;
	}
	
	public static String getCurrentDate(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		
		return date;
	}

}
