package co.za.ngwane.epms.helper;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import _205._76._14._196.SmsLocator;

public class SmsNotification {
	
	public SmsNotification() {
		// TODO Auto-generated constructor stub
	}

	public boolean sendSms(String recepient, String short_message) {

		Date todaysDate = new java.util.Date();
		// Formatting date into yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatter.format(todaysDate);
		
		
		try {
			return new SmsLocator().getsmsSoap().send(recepient, short_message, "ngwane", formattedDate, "", "8CC414DCC1A2D58");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return false;
	}


}
