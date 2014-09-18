package co.za.ngwane.epms.helper;

import java.util.List;

import co.za.ngwane.epms.operation.OutputOperations;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.repository.Usermessages;

public class EarlyWarnings {
	
	
	public static final int SMS_ONLY = 1;
	public static final int EMAIL_ONLY = 2;
	public static final int SMS_AND_EMAIl = 3;

    public EarlyWarnings() {
        // TODO Auto-generated constructor stub
    }

    public void notifications(String period, String quater) {
       
        List<Outputtbl> list = new OutputOperations().getAll();
       
        for (Outputtbl outputtbl : list) {
            boolean matchfound = false;

            for (Qoupd qoupd : outputtbl.getQoupdCollection()) {
               
                if (qoupd.getQuo().equals(quater)) {
                    matchfound = true;
                    break;
                }

            }
           
            String oneWeekBody = "Kindly provide quarterly performance information. The quarter will end in one week. Kind regards ePMS.";
            String oneDayBody = "Kindly provide quarterly performance information. The quarter will end in one day. Kind regards ePMS";
            String dueDateBody = "Kindly note that the quarterly reporting period has ended. Kind regards ePMS";
           
            if (!matchfound && period.equals("WEEK")) {
                new SendByteEmail().sendEmail(outputtbl.getUserid().getContactemail(), "", "One week before quarter end", oneWeekBody, null);
               
            } else if (!matchfound && period.equals("DAY")) {
                new SendByteEmail().sendEmail(outputtbl.getUserid().getContactemail(), "", "One day before quarter End", oneDayBody, null);
                new SmsNotification().sendSms(outputtbl.getUserid().getContactnumber(), oneDayBody);
            } else if (period.equals("END")) {
                new SendByteEmail().sendEmail(outputtbl.getUserid().getContactemail(), "", "Quarter end", dueDateBody, null);
                new SmsNotification().sendSms(outputtbl.getUserid().getContactnumber(), dueDateBody);
            }
        }
       
    }
    
    public boolean sendMessage(Usermessages usermessages){
    	
    	boolean result = true;
    	    switch (usermessages.getType())
			{
			case SMS_ONLY:
				result = new SmsNotification().sendSms(usermessages.getContactCell(), usermessages.getCode().getMsgbody());
				break;
			case EMAIL_ONLY :
				new SendByteEmail().sendEmail(usermessages.getContactEmail(), "", usermessages.getCode().getMsgsubject(), usermessages.getCode().getMsgbody(), null);
				break;
				
			case SMS_AND_EMAIl :
				result = new SmsNotification().sendSms(usermessages.getContactCell(), usermessages.getCode().getMsgbody());
				new SendByteEmail().sendEmail(usermessages.getContactEmail(), "", usermessages.getCode().getMsgsubject(), usermessages.getCode().getMsgbody(), null);
				break;
			default:
				result = false;
				break;
			}	   	
    	
		return result;
    	
    }
}