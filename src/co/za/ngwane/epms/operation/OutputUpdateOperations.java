package co.za.ngwane.epms.operation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.za.ngwane.epms.helper.OutPutStatus;
import co.za.ngwane.epms.helper.SmsNotification;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.OutputServiceImpl;
import co.za.ngwane.epms.serviceImpl.OutputUpdateServiceImpl;
import co.za.ngwane.epms.serviceImpl.QoupdServiceImpl;

public class OutputUpdateOperations {

	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.OutputOperations");

	public boolean signOffOutput(List<Qoupd> outupdates, Userepms user) {

		boolean results = false;
		logger.info("Entering signOffOutput method Operation");

		for (Qoupd outupdate: outupdates) {
			outupdate.setStat(user.isAuditor() ? OutPutStatus.AUDITED.getCode() :OutPutStatus.SIGNED_OFF.getCode());
			outupdate.setId(0);
			outupdate.setStatUpdateD(new Timestamp(new Date().getTime()));

			try {
				results = new OutputUpdateServiceImpl().addSignedOffData(outupdate);
				//Update Output after signing off data
				if(results){
					if(outupdate.getOutputtblid().getCurrq().equalsIgnoreCase("Q1" )){
						outupdate.getOutputtblid().setQ1a(outupdate.getQscore());
						outupdate.getOutputtblid().setCurrq("Q2");
					}else if(outupdate.getOutputtblid().getCurrq().equalsIgnoreCase("Q2")){
						outupdate.getOutputtblid().setQ2a(outupdate.getQscore());
						outupdate.getOutputtblid().setCurrq("Q3");
					}else if(outupdate.getOutputtblid().getCurrq().equalsIgnoreCase("Q3")){
						outupdate.getOutputtblid().setQ3a(outupdate.getQscore());
						outupdate.getOutputtblid().setCurrq("Q4");
					}else if(outupdate.getOutputtblid().getCurrq().equalsIgnoreCase("Q4")){
						outupdate.getOutputtblid().setQ4a(outupdate.getQscore());
						outupdate.getOutputtblid().setOutputComplete(true);
					}	
					outupdate.getOutputtblid().setBudspend(outupdate.getOutputtblid().getBudspend() + outupdate.getBudspend());
					float avBalanceOutCome = outupdate.getOutputtblid().getOutcometblid().getAbalance() - outupdate.getBudspend();
					outupdate.getOutputtblid().getOutcometblid().setAbalance(avBalanceOutCome);		
					results = new OutputServiceImpl().update(outupdate.getOutputtblid(),outupdate);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		return results;
	}
	
	public boolean rejectOffOutput(List<Qoupd> outupdates, Userepms user) {

		boolean results = false;
		logger.info("Entering rejectOffOutput method Operation");

		for (Qoupd outupdate :outupdates) {
			if (outupdate != null) {
				//If Auditor Reject, set status to Audit Rejected....
				//
				outupdate.setStat(user.isAuditor() ? OutPutStatus.AUDIT_REJECTED.getCode(): OutPutStatus.REJECTED.getCode());
				outupdate.setId(0);
				outupdate.setStatUpdateD(new Timestamp(new Date().getTime()));

				try {
					results = new OutputUpdateServiceImpl().addSignedOffData(outupdate);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if (results) {
						boolean success = new SmsNotification().sendSms(
								outupdate.getOutputtblid().getUserid().getContactnumber(),
								" :) Your output with reference: " + outupdate.getOutputtblid().getRefno() + " has been rejected, please login and re-capture");
						if (success) {
							logger.info("SMS succesfully send.");
						}
						else
						{
							logger.info("SMS send failed.");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.info("Something went wrong on sendSms : "+e.getMessage());
					e.printStackTrace();
				}

			}	
		}
		

		return results;
	}
	
	public List<Qoupd> getAllPendingSignOff(Userepms userepms) {
		logger.info("Entering getAllPendingSignOff method Operation");

		List<Qoupd> list = new ArrayList<Qoupd>();
		
		List<Outputtbl> outputtblList = new OutputOperations().getOutputByUser(userepms);
		
		try {
			for(Outputtbl outputtbl :outputtblList ){
				List<Qoupd> tempList = new ArrayList<Qoupd>();
				//Determine which Status to pull
				outputtbl.setRequestPendingStatus(userepms.isAuditor() ? OutPutStatus.PENDING_AUDIT.getCode() : OutPutStatus.PENDING_SIGN_OFF.getCode());
				tempList = new QoupdServiceImpl().getByOutput(outputtbl);
				System.out.println("Array Size = " + tempList.size());
				if(tempList != null && tempList.size() > 0)
				{
					if(outputtbl.getCurrq().equalsIgnoreCase("Q1" )){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ1().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q2")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ2().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q3")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ3().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q4")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ4().toString());
					}
				
					tempList.get(0).setStatusDescription(OutPutStatus.getDescByCode(tempList.get(0).getStat()));
					list.addAll(tempList);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Qoupd> getAllRejectedSignOff(Userepms userepms) {
		logger.info("Entering getAllRejectedSignOff method Operation");

		List<Qoupd> list = new ArrayList<Qoupd>();
		
		List<Outputtbl> outputtblList = new OutputOperations().getOutputByUser(userepms);
		
		try {
			for(Outputtbl outputtbl :outputtblList ){
				List<Qoupd> tempList = new ArrayList<Qoupd>();
				outputtbl.setRequestPendingStatus(userepms.isAuditor() ? OutPutStatus.PENDING_AUDIT.getCode() : OutPutStatus.PENDING_SIGN_OFF.getCode());
				tempList = new QoupdServiceImpl().getRejectedByOutput(outputtbl);
				System.out.println("Array Size = " + tempList.size());
				if(tempList != null && tempList.size() > 0)
				{
					if(outputtbl.getCurrq().equalsIgnoreCase("Q1" )){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ1().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q2")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ2().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q3")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ3().toString());
					}else if(outputtbl.getCurrq().equalsIgnoreCase("Q4")){
						
						tempList.get(0).setCurrentqTarget(outputtbl.getQ4().toString());
					}
				
					tempList.get(0).setStatusDescription(OutPutStatus.getDescByCode(tempList.get(0).getStat()));
					list.addAll(tempList);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateQoupd(Qoupd outupdate) {

		boolean results = false;
		logger.info("Entering updateQoupd method Operation");

		if (outupdate != null) {
			outupdate.setStat(OutPutStatus.PENDING_SIGN_OFF.getCode());
			outupdate.setId(0);
			outupdate.setStatUpdateD(new Timestamp(new Date().getTime()));

			try {
				results = new OutputUpdateServiceImpl().update(outupdate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		return results;
	}


}
