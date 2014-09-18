package co.za.ngwane.epms.helper;

import java.util.List;

import co.za.ngwane.epms.dao.MessagesDAO;
import co.za.ngwane.epms.repository.Messagestbl;

public class Messages
{
	
	private static Messages instance;
	private List<Messagestbl> messages;
	
	private Messages (){
		
		try
		{
			messages = new MessagesDAO().getAll();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  Messages getIntance(){
		if(instance == null){
			instance = new Messages();
			
		}
		return instance;
	}

	public List<Messagestbl> getMessages()
	{
		return messages;
	}
	
	public Messagestbl retrieveMessageByCode(int code){
		Messagestbl messagestbl = new Messagestbl();
		for(Messagestbl message : Messages.getIntance().getMessages()){
			if(message.getCode().equals(code)){
				messagestbl = message;
				break;
			}
		 }
		return messagestbl;
		
	}

}
