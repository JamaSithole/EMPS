package co.za.ngwane.epms.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import co.za.ngwane.epms.dao.QoupdDAO;
import co.za.ngwane.epms.helper.EarlyWarnings;
import co.za.ngwane.epms.helper.Messages;
import co.za.ngwane.epms.helper.NotificationCodes;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.repository.Usermessages;
import co.za.ngwane.epms.service.QoupdService;

public class QoupdServiceImpl implements QoupdService
{
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.QoupdServiceImpl");

	@Override
	public boolean add(Qoupd qoupd) throws Exception 
	{
		boolean result = false;
		try
		{
			if(qoupd != null){
				result = new QoupdDAO().addQoupd(qoupd);	
				if(result){
					/*
					 * Update all entries in usermessages
					 */
					
					List<Usermessages> outputMessages =  new NotificationServiceImpl().getByOutput(qoupd.getOutputtblid());
					for(Usermessages message : outputMessages){
						message.setStatus(2);//DE-Activate Messages
						result = new NotificationServiceImpl().update(message);
					}
					
					/*
					 * Create entries for 6 PM notifications
					 * 
					 */
					Usermessages usermessages = new Usermessages();
					Calendar  calendar = Calendar.getInstance();
					calendar.add(Calendar.MINUTE, 3);
					usermessages.setContactEmail(qoupd.getOutputtblid().getUserid().getContactemail());
					usermessages.setContactCell(qoupd.getOutputtblid().getUserid().getContactnumber());
					usermessages.setStatus(1);
					usermessages.setReference(0);
					 
					 //Add End of 6PM Record
					 usermessages.setCode(Messages.getIntance().retrieveMessageByCode(NotificationCodes.SIX_PM_MSG.getCode()));
					 usermessages.setType(EarlyWarnings.SMS_AND_EMAIl);
					 usermessages.setDate(calendar.getTime());
					 usermessages.setOutput(qoupd.getOutputtblid());
					
				}
			}
			
		} catch (Exception e)
		{
			logger.info("Exception caught in adding Qoup Object : "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Qoupd> getAll() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qoupd> getByOutput(Outputtbl outputtbl) throws Exception
	{
		List<Qoupd> resultList = new ArrayList<Qoupd>();
		try
		{
			resultList = new QoupdDAO().getByOutputName(outputtbl);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}
	
	public List<Qoupd> getRejectedByOutput(Outputtbl outputtbl) throws Exception
	{
		List<Qoupd> resultList = new ArrayList<Qoupd>();
		try
		{
			resultList = new QoupdDAO().getRejectedByOutputName(outputtbl);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Qoupd> getQoupByOutput(Outputtbl outputtbl) throws Exception {
		List<Qoupd> resultList = new ArrayList<Qoupd>();
		try
		{
			resultList = new QoupdDAO().getQoupByOutput(outputtbl);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}


}
