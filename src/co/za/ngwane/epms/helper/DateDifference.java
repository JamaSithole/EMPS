package co.za.ngwane.epms.helper;

import java.util.*;

public class DateDifference
{
	public static void main(String args[])
	{
		DateDifference difference = new DateDifference();
	}

	DateDifference()
	{
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		cal1.set(2012, 11, 15);
		cal2.set(2012, 11, 20);
		System.out.println("Days= " + daysBetween(cal1.getTime(), cal2.getTime()));
	}

	public int daysBetween(Date d1, Date d2)
	{
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}
