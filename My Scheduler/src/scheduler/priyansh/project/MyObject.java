package scheduler.priyansh.project;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyObject implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("Hurray..!! My Scheduler is running !!");
		System.out.println("The time is "+ new Date());
		
	}

}
