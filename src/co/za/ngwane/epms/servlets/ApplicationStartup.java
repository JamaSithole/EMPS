package co.za.ngwane.epms.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import co.za.ngwane.epms.helper.JobSchedular;
import co.za.ngwane.epms.helper.Messages;

public class ApplicationStartup implements ServletContextListener
{
	
	/**
	 * 
	 */
	private final static int EVERY_15_MINUTES = 900000;
	

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		loadMessages(); 		
		String filePath =  sce.getServletContext().getRealPath("/reports/log4j.properties");
		PropertyConfigurator.configure(filePath);
		startJobScheduler();
         
}

	private void loadMessages()
	{
		Messages.getIntance();		
	}

	private void startJobScheduler()
	{
		System.out.println("THE APPLICATION STARTED");
          try{
        	  
        	  String path = ("");
        	  
        	
        	  
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
      simpleTrigger.setRepeatInterval(EVERY_15_MINUTES);
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
