package email.scheduler.project;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyApp {

	public static void main(String[] args) {
		try {
			
			//File creation
			
			String location = "D:\\newCsvFilewithPipe.csv";
			CsvAttachment.writeDataForCustomSeperatorCSV(location);
			System.out.println("File created successfully");
			 
			for(int i=0;i<2;i++) {
				JobDetail job1 = JobBuilder.newJob(Job1.class)
						.withIdentity("job1", "group1").build();

				Trigger trigger1 = TriggerBuilder.newTrigger()
						.withIdentity("cronTrigger1", "group1")
						.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
						.build();
				
				Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
				scheduler1.start();
				scheduler1.scheduleJob(job1, trigger1);

				JobDetail job2 = JobBuilder.newJob(Job2.class)
						.withIdentity("job2", "group2").build();
				
				Trigger trigger2 = TriggerBuilder.newTrigger()
						.withIdentity("cronTrigger2", "group2")
						.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/2 * * * * ?")))
						.build();
				
				Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
				scheduler2.start();
				scheduler2.scheduleJob(job2, trigger2);
				
				Thread.sleep(100000);
				
				scheduler1.shutdown();
				scheduler2.shutdown();
			}
			
//			CsvAttachment.writeDataLineByLine("filePath");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}