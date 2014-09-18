package co.za.ngwane.epms.operation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.za.ngwane.epms.helper.GUIDKeyGenerator;
import co.za.ngwane.epms.helper.OutPutStatus;
import co.za.ngwane.epms.helper.PercentageCalc;
import co.za.ngwane.epms.repository.Outcometbl;
import co.za.ngwane.epms.repository.Outputtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.OutcomeServiceImpl;
import co.za.ngwane.epms.serviceImpl.OutputServiceImpl;
import co.za.ngwane.epms.serviceImpl.QoupdServiceImpl;
import co.za.ngwane.epms.serviceImpl.UserepmsServiceImpl;

public class OutputOperations {

	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.OutputOperations");

	public boolean addOutput(Outputtbl outputtbl, String outputOwner) {

		boolean results = false;
		logger.info("Entering Output Operations : User Name [");// TO Be
																// Completed

		if (outputOwner != null && outputtbl != null) {
			Userepms user = new Userepms();
			logger.info("Trying to retrieve User Object for User name : "
					+ outputOwner);
			try {
				user = new UserepmsServiceImpl().getByName(outputOwner);
			} catch (Exception e) {
				logger.info("Failed to retrieve User Object for User name : "
						+ outputOwner);
				e.printStackTrace();
			}
			if (user != null) {
				logger.info("Succesfuly retrieved Userepms Object for user name : "
						+ outputOwner);
				logger.info("Trying to Add Output Object for user name : "
						+ outputOwner);

				GUIDKeyGenerator generator = new GUIDKeyGenerator();

				outputtbl.setRefno(generator.generate('O', 10));
				outputtbl.setUserid(user);
				outputtbl.setQ1a(0f);
				outputtbl.setQ2a(0f);
				outputtbl.setQ3a(0f);
				outputtbl.setQ4a(0f);
				outputtbl.setAvgScore(0f);
				outputtbl.setBudspend(0f);
				//outputtbl.setTotbud(0f);
				
				try
				{
					outputtbl.getOutcometblid().setVal(outputtbl.getOutcometblid().getVal() + outputtbl.getTotbud());
					outputtbl.getOutcometblid().setAbalance(outputtbl.getOutcometblid().getAbalance() - outputtbl.getTotbud());
					boolean result =  new OutcomeServiceImpl().update(outputtbl.getOutcometblid());
					if(!result) return result;
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return false;
				}
				
				System.out.println("Quantitative Value of This is ...." + outputtbl.isQuantitative());

				try {
					logger.info("Trying to Add Output for Outcome : "
							+ outputtbl.getOutcometblid().getName());
					results = new OutputServiceImpl().add(outputtbl);
					if (results) {
						logger.info("Added Output Object for outcome name : "
								+ outputOwner);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return results;
	}

	public List<Outputtbl> getAll() {

		List<Outputtbl> outputList = null;
		List<Outputtbl> finalList = new ArrayList<Outputtbl>();
		try {
			outputList = new OutputServiceImpl().getAll();
			for (Outputtbl output : outputList) {
				output.setQ1fs(PercentageCalc.getPercentage(output.getQ1(),
						output.getQ1a()));
				output.setQ2fs(PercentageCalc.getPercentage(output.getQ2(),
						output.getQ2a()));
				output.setQ3fs(PercentageCalc.getPercentage(output.getQ3(),
						output.getQ3a()));
				output.setQ4fs(PercentageCalc.getPercentage(output.getQ4(),
						output.getQ4a()));
				finalList.add(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Dept> getAll() : "
					+ e.getMessage());
		}
		return finalList;

	}

	public List<Outputtbl> getOutput(Outcometbl outcometbl) {
		List<Outputtbl> outputList = null;
		List<Outputtbl> finalList = new ArrayList<Outputtbl>();
		try {
			outputList = new OutputServiceImpl().getByOutcomeName(outcometbl);
			logger.info("outputList.size() is : " + outputList.size());
			for (Outputtbl output : outputList) {
				output.setQ1fs(PercentageCalc.getPercentage(output.getQ1(),
						output.getQ1a()));
				output.setQ2fs(PercentageCalc.getPercentage(output.getQ2(),
						output.getQ2a()));
				output.setQ3fs(PercentageCalc.getPercentage(output.getQ3(),
						output.getQ3a()));
				output.setQ4fs(PercentageCalc.getPercentage(output.getQ4(),
						output.getQ4a()));				
				output.setUpdates(new QoupdServiceImpl().getByOutput(output));	
				
				//Calculate Output final score
				float avgScore = (PercentageCalc.getPercentageValue(output.getQ1(),output.getQ1a()) + PercentageCalc.getPercentageValue(output.getQ2(),output.getQ2a())+
						PercentageCalc.getPercentageValue(output.getQ3(),output.getQ3a()) + PercentageCalc.getPercentageValue(output.getQ4(),output.getQ4a()))/4;
				output.setAvgScore(avgScore);
				finalList.add(output);
				//BigDecimal value = new BigDecimal(avgScore).;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in List<Outputtbl> getOutput(Outcometbl outcometbl) : "
					+ e.getMessage());
		}
		return finalList;

	}

	public boolean updateOutput(Outputtbl output, Qoupd qoupd) {
		boolean results = false;

		try {
//			try {
//				if (new OutputServiceImpl().update(output)) {
//					//Update Outcome ABALANCE
//					if(output.getBudspend() > output.getOutcometblid().getAbalance() ){
//						logger.info("Failed to Update Output, Budget [ " + output.getBudspend() + " ] Allocated greater than Available budget on Outcome [" + output.getOutcometblid().getAbalance() +" ]");
//						return false;
//					}else{
//						float avBalance = output.getOutcometblid().getAbalance() +  output.getBudspend();
//						output.getOutcometblid().setAbalance(avBalance);						
//						new OutcomeServiceImpl().update(output.getOutcometblid());
//					}
//					logger.info("Output Object updated successfully.");
//					results = true;
//				}
//			} catch (Exception e) {
//				logger.info("Failed to update Output Object. : "+e.getMessage());
//			}
			
			if( qoupd != null )
			{
				
				if(output.getBudspend() > output.getOutcometblid().getAbalance() ){
					logger.info("Failed to Update Output, Budget [ " + output.getBudspend() + " ] Allocated greater than Available budget on Outcome [" + output.getOutcometblid().getAbalance() +" ]");
					return false;
				}else{
					float avBalance = output.getOutcometblid().getAbalance() +  output.getBudspend();
					output.getOutcometblid().setAbalance(avBalance);						
					new OutcomeServiceImpl().update(output.getOutcometblid());
				}
				qoupd.setOutputtblid(output);
				qoupd.setQuo(output.getCurrq());
				qoupd.setStat(OutPutStatus.PENDING_SIGN_OFF.getCode());
				qoupd.setStatUpdateD(new Timestamp(new Date().getTime()));
				//check indicator and the set target 
				if(qoupd.getOutputtblid().isQuantitative()){
					if(qoupd.getQuo().equalsIgnoreCase("Q1")){
						qoupd.setTmet(qoupd.getQscore() >= qoupd.getOutputtblid().getQ1());
					}else if(qoupd.getQuo().equalsIgnoreCase("Q2")){
						qoupd.setTmet(qoupd.getQscore() >= qoupd.getOutputtblid().getQ2());
					}else if(qoupd.getQuo().equalsIgnoreCase("Q3")){
						qoupd.setTmet(qoupd.getQscore() >= qoupd.getOutputtblid().getQ3());
					}else if(qoupd.getQuo().equalsIgnoreCase("Q2")){
						qoupd.setTmet(qoupd.getQscore() >= qoupd.getOutputtblid().getQ4());
					}
					
				}
				try {
					if ( new QoupdServiceImpl().add(qoupd) ) {
						logger.info("Output Object updated successfully.");
						results = true;
					}
				} catch (Exception e) {
					logger.info("Failed to update Output Object. : "+e.getMessage());
				}
			}
			
		} catch (Exception e) {
			logger.info("Exception caught, msg: " + e.getMessage());
			results = false;
		}
		return results;
	}
	
	public List<Outputtbl> getOutputByUser(Userepms userepms) {
		List<Outputtbl> outputtbl = null;
		try {
			outputtbl = new OutputServiceImpl().getOutputByUser(userepms);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in Outputtbl  getOutputByUser(Userepms userepms) : "
					+ e.getMessage());
		}
		
		return outputtbl;

	}
	
	public List<Qoupd> getQoupByOutput(Outputtbl outputtbl) {
		List<Qoupd> qoupdList = null;
		try {
			qoupdList = new QoupdServiceImpl().getQoupByOutput(outputtbl);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception caught in Outputtbl  getQoupByOutput for output ref :: " +outputtbl.getRefno()+" "
					+ e.getMessage());
		}
		
		return qoupdList;
	}
	

}
