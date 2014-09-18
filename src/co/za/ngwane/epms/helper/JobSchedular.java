package co.za.ngwane.epms.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import co.za.ngwane.epms.repository.Usermessages;
import co.za.ngwane.epms.serviceImpl.NotificationServiceImpl;
import co.za.ngwane.epms.servlets.ApplicationStartup;

public class JobSchedular implements Job
{
	
  public static final int Message_sent  = 2;
  private Logger  logger = Logger.getLogger(getClass());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		
		logger.info("JOB Schedular Started");
		/*  Find all notifications that are ready to be sent on the day
		 * 
		 * 
		 * 
		 */
		List<Usermessages> workingList = new java.util.ArrayList<Usermessages>();
		try
		{
			workingList = new NotificationServiceImpl().getMessagesToProcess(new Date());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			EarlyWarnings earlyWarnings = new EarlyWarnings();
			for(Usermessages usermessages : workingList){			
				if(earlyWarnings.sendMessage(usermessages)) {
					usermessages.setStatus(Message_sent);
					//Set status to 2, Meaning done
					new NotificationServiceImpl().update(usermessages);
				}
								
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		
		 System.out.println("THE APPLICATION STARTED");
        // testSchedular();
		 	
		 String date  = DateFormatter.getCurrentDate();
		 Calendar calendar = Calendar.getInstance();
		 System.out.println(calendar.getTime());
		 calendar.add(Calendar.MONTH, 3);
		 String threeMonths  = calendar.getTime().toString();
		 System.out.println(date);
		 System.out.println(threeMonths);
		 
	}
	
	
	
	private static void testSchedular()
	{
		try{
          // Initiate a Schedule Factory
     SchedulerFactory schedulerFactory = new StdSchedulerFactory();
     // Retrieve a scheduler from schedule factory
     Scheduler scheduler = schedulerFactory.getScheduler();
    
     // current time
     long ctime = System.currentTimeMillis();
    
     // Initiate JobDetail with job name, job group, and executable job class
     JobDetail jobDetail =
      new JobDetail("jobDetail-s1", "jobDetailGroup-s1", JobSchedular.class);
     // Initiate SimpleTrigger with its name and group name
     SimpleTrigger simpleTrigger =
      new SimpleTrigger("simpleTrigger", "triggerGroup-s1");
     // set its start up time
     simpleTrigger.setStartTime(new java.util.Date());
     // set the interval, how often the job should run (10 seconds here)
     simpleTrigger.setRepeatInterval(10000);
     // set the number of execution of this job, set to 10 times.
     // It will run 10 time and exhaust.
    // simpleTrigger.setRepeatCount(100);
     // set the ending time of this job.
     // We set it for 60 seconds from its startup time here
     // Even if we set its repeat count to 10,
     // this will stop its process after 6 repeats as it gets it endtime by then.
     //simpleTrigger.setEndTime(new Date(ctime + 60000L));
     // set priority of trigger. If not set, the default is 5
     //simpleTrigger.setPriority(10);
     // schedule a job with JobDetail and Trigger
     scheduler.scheduleJob(jobDetail, simpleTrigger);
    
     // start the scheduler
     scheduler.start();

            
         }catch (SchedulerException se) {
             System.out.println(se);
         }catch (Exception e) {
             System.out.println(e);
         }
	}
}
