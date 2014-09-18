package co.za.ngwane.epms.operation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Logger;

import java.io.IOException;

import co.za.ngwane.epms.repository.Attachepms;

public class FileUploadOperation 
{
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.FileUploadOperation");
	List<Attachepms> attList = new ArrayList<Attachepms>();
	
	public boolean fileUpload(List<Attachepms> attList )
	{
		String directory = "C:\\Devland\\Invoices";
		
		File file = new File(directory);
		if (!file.exists()) 
		{
			file.mkdir();
		}
		
		return false;
	}
	
	public static Attachepms uploadFile(String name, byte[] content) throws Exception 
	{
		Attachepms attachment = new Attachepms();
		attachment.setAttachment(content);
		
		String directory = "C:\\Devland\\Invoices";
		
		File file = new File(directory);
		if (!file.exists()) 
		{
			file.mkdir();
		}
		name = directory + "/" + name;
		File fileToUpload = new File(name);
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(fileToUpload);
			fos.write(content);
			fos.close();
		} 
		catch (IOException ex) 
		{
			return null;
		}
		
		return attachment;
	}
}
