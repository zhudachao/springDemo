package com.keven.springDemo.scheduler;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	private static Logger logger =LoggerFactory.getLogger(SchedulerTask.class);
	
	
//	@Scheduled(fixedRate= 6000)
//	@Scheduled(cron="*/6 * * * * ?")
//	@Scheduled(fixedDelayString="6000")
	@Scheduled(cron="00 07 19 * * *")   //19:07:00执行
	private static void getDurTime() {
//		DateFormatUtils.format(new Date(),"yyyyMMdd:hhmmss");
		
		System.out.println("现在时间： "+DateFormatUtils.format(new Date(),"yyyyMMdd:hhmmss"));
	}
	
	

}
