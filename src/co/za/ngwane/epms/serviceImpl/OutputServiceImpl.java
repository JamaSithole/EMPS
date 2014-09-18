package co.za.ngwane.epms.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.za.ngwane.epms.dao.OutputDAO;
import co.za.ngwane.epms.helper.EarlyWarnings;
import co.za.ngwane.epms.helper.Messages;
import co.za.ngwane.epms.helper.NotificationCodes;
import co.za.ngwane.epms.helper.PercentageCalc;
import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.repository.Usermessages;
import co.za.ngwane.epms.service.OutputService;

public class OutputServiceImpl implements OutputService {
	
	public static int NUMBER_OF_QUATERS = 4;

	@Override
	public boolean add(Outputtbl outputtbl) throws Exception {
		boolean result = false;

		try {
			if (outputtbl != null) {
				result = new OutputDAO().addOutput(outputtbl);
				Usermessages usermessages = new Usermessages();
				if(result){
					/*
					 * Add end of quater message to usermessages
					 * Add one day before message to usermessages
					 * Add one week before message to usermessages 
					 */					
					 Calendar calendar = Calendar.getInstance();
					 System.out.println(calendar.getTime());
					 calendar.add(Calendar.MONTH, 3);
					 //Now Exclude Weekends
					 while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
						 calendar.add(Calendar.DATE, 1);
						}
					 
					 usermessages.setContactEmail(outputtbl.getUserid().getContactemail());
					 usermessages.setContactCell(outputtbl.getUserid().getContactnumber());
					 usermessages.setStatus(1);
					 usermessages.setReference(0);
					 
					 //Add End of Quater Record
					 usermessages.setCode(Messages.getIntance().retrieveMessageByCode(NotificationCodes.END_OF_QAUTER.getCode()));
					 usermessages.setType(EarlyWarnings.SMS_AND_EMAIl);
					 usermessages.setDate(calendar.getTime());
					 usermessages.setOutput(outputtbl);
					 
					 result = new NotificationServiceImpl().add(usermessages);
					 
					 //ADD Day before Message
					 //Excludes weekends
					 calendar.add(Calendar.DAY_OF_MONTH, -1);
					 while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
						 calendar.add(Calendar.DATE, -1);
						}
					 usermessages.setCode(Messages.getIntance().retrieveMessageByCode(NotificationCodes.DAY_BEFORE.getCode()));
					 usermessages.setType(EarlyWarnings.SMS_AND_EMAIl);
					 usermessages.setDate(calendar.getTime());
					 usermessages.setReference(0);
					 result = new NotificationServiceImpl().add(usermessages);
					 
					 
					 //Add week before record
					 //Exclude Weekends
					 
					 calendar.add(Calendar.DAY_OF_MONTH, -5);
					 while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
						 calendar.add(Calendar.DATE, -1);
						}
					 usermessages.setCode(Messages.getIntance().retrieveMessageByCode(NotificationCodes.WEEK_BEFORE.getCode()));
					 usermessages.setType(EarlyWarnings.EMAIL_ONLY);
					 usermessages.setDate(calendar.getTime());
					 usermessages.setReference(0);
					 result= new NotificationServiceImpl().add(usermessages);						 
					 
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Outputtbl> getAll() throws Exception {

		List<Outputtbl> progList = null;
		try {
			progList = new OutputDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progList;
	}

	@Override
	public List<Outputtbl> getByOutcomeName(Outcometbl outcometbl)
			throws Exception {
		List<Outputtbl> progList = null;
		try {
			progList = new OutputDAO().getByOutputName(outcometbl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progList;
	}
	
	public List<Outputtbl> getOutputByUser(Userepms userepms)
			throws Exception {
		List<Outputtbl> outputtbl = null;
		try {
			outputtbl = new OutputDAO().getOutputByUser(userepms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputtbl;
	}


	@Override
	public boolean update(Outputtbl outputtbl, Qoupd qoupd) throws Exception {
		boolean result = false;
		List<Outputtbl> totalOutputList = new ArrayList<Outputtbl>();

		try {
			if (outputtbl != null) {
				result = new OutputDAO().update(outputtbl);
				
				if(result){
					Projtbl projtbl = new ProjectServiceImpl().retrieveByName(outputtbl.getOutcometblid().getProjtblid().getName());
					//projtbl.setBudspend(qoupd.getBudspend() + projtbl.getBudspend());
					
					
					//Find Related Outcomes
					List<Outcometbl> relatedOutcomes = new OutcomeServiceImpl().findByProjectId(projtbl);
					
					if(relatedOutcomes != null && !relatedOutcomes.isEmpty()){
						for(Outcometbl outcome : relatedOutcomes){
							//retrieve outputs and add to mainlist.
							List<Outputtbl> tempList = new ArrayList<Outputtbl>();
							tempList = new OutputDAO().getByOutputName(outcome);
							totalOutputList.addAll(tempList);							
						}
						
					}
					
					int numOfOutputs = 0;
					float totalRowScore =0;
					for(Outputtbl currentOutput : totalOutputList){
						
						float q1Score = PercentageCalc.getPercentageValue(currentOutput.getQ1(),
								currentOutput.getQ1a());
						float q2Score = PercentageCalc.getPercentageValue(currentOutput.getQ2(),
								currentOutput.getQ2a());
						float q3Score = PercentageCalc.getPercentageValue(currentOutput.getQ3(),
								currentOutput.getQ3a());
						float q4Score = PercentageCalc.getPercentageValue(currentOutput.getQ4(),
								currentOutput.getQ4a());
						
						float rowAvgScore = (q1Score + q2Score + q3Score + q4Score)/NUMBER_OF_QUATERS; 
						
						totalRowScore = totalRowScore + rowAvgScore;
						numOfOutputs++;
					}
					
					/*****************CALCULATE PROJECT SCORE AND UPDATE BUDGET *********************************/
					float projectScore = totalRowScore/numOfOutputs;					
					projectScore = PercentageCalc.round(projectScore, 2);					
					projtbl.setScore(projectScore);					
					
					/*****************UPDATE OUTCOME AVAILABLE BUDGET*********************************************************/
				//	outputtbl.getOutcometblid().setAbalance(outputtbl.getOutcometblid().getAbalance() - qoupd.getBudspend());
				//	new OutcomeServiceImpl().update(outputtbl.getOutcometblid());
					
					result = new ProjectServiceImpl().updateBudget(projtbl,qoupd);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
