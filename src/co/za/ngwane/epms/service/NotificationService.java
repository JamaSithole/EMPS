package co.za.ngwane.epms.service;

import java.util.Date;
import java.util.List;

import co.za.ngwane.epms.repository.Usermessages;

public interface NotificationService
{
	public List<Usermessages> getMessagesToProcess(Date currentDate) throws Exception;
	public boolean update(Usermessages usermessages) throws Exception;
	public boolean add(Usermessages usermessages) throws Exception;

}
